package com.example.pharmacy.service;

import com.example.pharmacy.dto.request.InventoryItemRequestDto;
import com.example.pharmacy.dto.response.InventoryResponseDto;
import com.example.pharmacy.model.Drug;
import com.example.pharmacy.model.InventoryItem;
import com.example.pharmacy.model.StockTransaction;
import com.example.pharmacy.repository.DrugRepo;
import com.example.pharmacy.repository.InventoryItemRepo;
import com.example.pharmacy.repository.StockTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InventroyItemService {

    @Autowired
    private InventoryItemRepo inventoryItemRepo;

    @Autowired
    private DrugRepo drugRepo;

    @Autowired
    private StockTransactionRepo stockTransactionRepo;

    public InventoryResponseDto createInventoryItem(InventoryItemRequestDto requestDto) {
        // 1. Map Request -> Entity
        InventoryItem inventoryItem = new InventoryItem();
        Drug drug = drugRepo.findById(requestDto.getDrugId()).get();

        inventoryItem.setDrugobj(drug);
        inventoryItem.setBatchNumber(requestDto.getBatchNumber());
        inventoryItem.setExpiryDate(requestDto.getExpiryDate());
        inventoryItem.setQuantityonHand(requestDto.getQuantityonHand());
        inventoryItem.setReorderLevel(requestDto.getReorderLevel());

        InventoryItem savedItem = inventoryItemRepo.save(inventoryItem);

        // 2. Manually set Response DTO
        InventoryResponseDto response = new InventoryResponseDto();
        response.setInventoryID(savedItem.getInventoryID());
        response.setDrugId(savedItem.getDrugobj().getDrugId());
        response.setBatchNumber(savedItem.getBatchNumber());
        response.setExpiryDate(savedItem.getExpiryDate());
        response.setQuantityonHand(savedItem.getQuantityonHand());
        response.setReorderLevel(savedItem.getReorderLevel());

        return response;
    }

    public InventoryResponseDto getInventoryItemById(Long id) {
        InventoryItem item = inventoryItemRepo.findById(id).get();

        InventoryResponseDto response = new InventoryResponseDto();
        response.setInventoryID(item.getInventoryID());
        response.setDrugId(item.getDrugobj().getDrugId());
        response.setBatchNumber(item.getBatchNumber());
        response.setExpiryDate(item.getExpiryDate());
        response.setQuantityonHand(item.getQuantityonHand());
        response.setReorderLevel(item.getReorderLevel());

        return response;
    }

    public List<InventoryResponseDto> getAll() {
        List<InventoryItem> items = inventoryItemRepo.findAll();
        List<InventoryResponseDto> responseList = new ArrayList<>();

        for (InventoryItem item : items) {
            InventoryResponseDto response = new InventoryResponseDto();
            response.setInventoryID(item.getInventoryID());
            response.setDrugId(item.getDrugobj().getDrugId());
            response.setBatchNumber(item.getBatchNumber());
            response.setExpiryDate(item.getExpiryDate());
            response.setQuantityonHand(item.getQuantityonHand());
            response.setReorderLevel(item.getReorderLevel());

            responseList.add(response);
        }
        return responseList;
    }

    public InventoryResponseDto updateInventoryItem(Long id, InventoryItemRequestDto requestDto) {
        InventoryItem existing = inventoryItemRepo.findById(id).get();
        Drug drug = drugRepo.findById(requestDto.getDrugId()).get();

        existing.setBatchNumber(requestDto.getBatchNumber());
        existing.setExpiryDate(requestDto.getExpiryDate());
        existing.setReorderLevel(requestDto.getReorderLevel());
        existing.setQuantityonHand(requestDto.getQuantityonHand());
        existing.setDrugobj(drug);

        InventoryItem updatedItem = inventoryItemRepo.save(existing);

        InventoryResponseDto response = new InventoryResponseDto();
        response.setInventoryID(updatedItem.getInventoryID());
        response.setDrugId(updatedItem.getDrugobj().getDrugId());
        response.setBatchNumber(updatedItem.getBatchNumber());
        response.setExpiryDate(updatedItem.getExpiryDate());
        response.setQuantityonHand(updatedItem.getQuantityonHand());
        response.setReorderLevel(updatedItem.getReorderLevel());

        return response;
    }

    public String deleteInventoryItemById(Long id) {
        inventoryItemRepo.deleteById(id);
        return "The Inventory Item has been successfully deleted";
    }

    public String deleteAll() {
        inventoryItemRepo.deleteAll();
        return "The InventoryItem table has been successfully cleared";
    }

    public List<InventoryResponseDto> reorderdrugs() {
        return inventoryItemRepo.findItemsNeedingReorder();
    }

    public Optional<Long> findquantitybasedonDrug(Long drugId) {
        return inventoryItemRepo.finddrugquantitybasedonId(drugId);
    }



}