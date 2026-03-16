package com.example.pharmacy.service;

import com.example.pharmacy.dto.request.StockTransactionRequestDto;
import com.example.pharmacy.dto.response.StockTransactionResponseDto;
import com.example.pharmacy.model.InventoryItem;
import com.example.pharmacy.model.StockTransaction;
import com.example.pharmacy.repository.InventoryItemRepo;
import com.example.pharmacy.repository.StockTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockTransactionService {

    @Autowired
    private StockTransactionRepo stockTransactionRepo;

    @Autowired
    private InventoryItemRepo inventoryItemRepo;

    public StockTransactionResponseDto create(Long inventoryId, StockTransactionRequestDto requestDto) {
        InventoryItem inventoryItem = inventoryItemRepo.findById(inventoryId).get();

        StockTransaction stockTransaction = new StockTransaction();
        stockTransaction.setTransactionType(requestDto.getTransactionType());
        stockTransaction.setQuantity(requestDto.getQuantity());
        stockTransaction.setTransactionDate(requestDto.getTransactionDate());
        stockTransaction.setReferenceID(requestDto.getReferenceID());

        // Manual link to the parent
        stockTransaction.setInventoryItem(inventoryItem);

        StockTransaction saved = stockTransactionRepo.save(stockTransaction);

        // Manual mapping to ResponseDto
        StockTransactionResponseDto response = new StockTransactionResponseDto();
        response.setTransactionID(saved.getTransactionID());
        response.setTransactionType(saved.getTransactionType());
        response.setQuantity(saved.getQuantity());
        response.setTransactionDate(saved.getTransactionDate());
        response.setReferenceID(saved.getReferenceID());

        return response;
    }

    public StockTransactionResponseDto update(Long id, StockTransactionRequestDto requestDto) {
        StockTransaction existing = stockTransactionRepo.findById(id).get();

        existing.setQuantity(requestDto.getQuantity());
        existing.setTransactionDate(requestDto.getTransactionDate());
        existing.setTransactionType(requestDto.getTransactionType());
        existing.setReferenceID(requestDto.getReferenceID());

        StockTransaction updated = stockTransactionRepo.save(existing);

        StockTransactionResponseDto response = new StockTransactionResponseDto();
        response.setTransactionID(updated.getTransactionID());
        response.setTransactionType(updated.getTransactionType());
        response.setQuantity(updated.getQuantity());
        response.setTransactionDate(updated.getTransactionDate());
        response.setReferenceID(updated.getReferenceID());

        return response;
    }

    public StockTransactionResponseDto getbyId(Long id) {
        StockTransaction stock = stockTransactionRepo.findById(id).get();

        StockTransactionResponseDto response = new StockTransactionResponseDto();
        response.setTransactionID(stock.getTransactionID());
        response.setTransactionType(stock.getTransactionType());
        response.setQuantity(stock.getQuantity());
        response.setTransactionDate(stock.getTransactionDate());
        response.setReferenceID(stock.getReferenceID());

        return response;
    }

    public List<StockTransactionResponseDto> getAll() {
        List<StockTransaction> transactions = stockTransactionRepo.findAll();
        List<StockTransactionResponseDto> dtoList = new ArrayList<>();

        for (StockTransaction stock : transactions) {
            StockTransactionResponseDto dto = new StockTransactionResponseDto();
            dto.setTransactionID(stock.getTransactionID());
            dto.setTransactionType(stock.getTransactionType());
            dto.setQuantity(stock.getQuantity());
            dto.setTransactionDate(stock.getTransactionDate());
            dto.setReferenceID(stock.getReferenceID());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public String deletebyId(Long id) {
        // 1. Find the transaction
        StockTransaction stock = stockTransactionRepo.findById(id).get();

        // 2. Find the parent InventoryItem
        InventoryItem item = stock.getInventoryItem();

        if (item != null) {
            // 3. Remove the transaction from the InventoryItem's list
            // This is the manual way to break the One-to-Many link
            item.getStockt().remove(stock);

            // 4. Update the Parent so the DB knows the link is gone
            inventoryItemRepo.save(item);
        }

        // 5. Now delete the transaction record
        stockTransactionRepo.delete(stock);

        return "Stocktransaction item deleted";
    }

    public String deleteAll() {
        // 1. Get all inventory items
        List<InventoryItem> allItems = inventoryItemRepo.findAll();

        // 2. Clear the lists manually for every parent
        for (InventoryItem item : allItems) {
            item.getStockt().clear();
            inventoryItemRepo.save(item);
        }

        // 3. Now the StockTransaction table is free to be cleared
        stockTransactionRepo.deleteAll();

        return "Stocktransaction list deleted";
    }
}