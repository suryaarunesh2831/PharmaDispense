package com.example.pharmacy.service;


import com.example.pharmacy.model.InventoryItem;
import com.example.pharmacy.model.StockTransaction;
import com.example.pharmacy.repository.InventoryItemRepo;
import com.example.pharmacy.repository.StockTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockTransactionService {

    @Autowired
    StockTransactionRepo stockTransactionRepo;
    @Autowired
    InventoryItemRepo inventoryItemRepo;


  public  StockTransaction create(StockTransaction stockTransaction)
    {
        stockTransactionRepo.save(stockTransaction);
        InventoryItem inventoryItem=inventoryItemRepo.findById(stockTransaction.getInventoryItem().getInventoryID()).get();
        inventoryItem.setStockt(stockTransaction);
        stockTransaction.setInventoryItem(inventoryItem);


        inventoryItemRepo.save(inventoryItem);

        return inventoryItem.getStockt();
    }
   public  StockTransaction update(Long id,StockTransaction request)
    {
        StockTransaction existing=stockTransactionRepo.findById(id).get();

        existing.setQuantity(request.getQuantity());
        existing.setTransactionDate(request.getTransactionDate());
        existing.setTransactionType(request.getTransactionType());
        request.setReferenceID(request.getReferenceID());
        existing.setInventoryItem(request.getInventoryItem());
        request.getInventoryItem().setStockt(existing);

        stockTransactionRepo.save(existing);
        InventoryItem inventoryItem=inventoryItemRepo.findById(existing.getInventoryItem().getInventoryID()).get();
        inventoryItem.setStockt(existing);
        existing.setInventoryItem(inventoryItem);


        inventoryItemRepo.save(inventoryItem);

        return existing;
    }
   public  StockTransaction getbyId(Long id)
    {
        return stockTransactionRepo.findById(id).get();
    }
    public List<StockTransaction> getAll()
    {
        return stockTransactionRepo.findAll();
    }
    public String deletebyId(Long id)
    {
        StockTransaction stock =stockTransactionRepo.findById(id).get();
        InventoryItem item=stock.getInventoryItem();

        item.setStockt(null);

        inventoryItemRepo.save(item);
        stockTransactionRepo.deleteById(id);

        return "Stocktransaction item deleted";

    }
    public String deleteAll()
    {
        for(InventoryItem item:inventoryItemRepo.findAll())
        {
            item.setStockt(null);
            inventoryItemRepo.save(item);
        }


        stockTransactionRepo.deleteAll();
        return "Stocktransaction list  deleted";

    }

}
