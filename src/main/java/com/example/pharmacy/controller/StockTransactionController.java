package com.example.pharmacy.controller;

import com.example.pharmacy.model.InventoryItem;
import com.example.pharmacy.model.StockTransaction;
import com.example.pharmacy.repository.InventoryItemRepo;
import com.example.pharmacy.repository.StockTransactionRepo;
import com.example.pharmacy.service.StockTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PharmaDispense/StockTransaction")
public class StockTransactionController {

    @Autowired
    StockTransactionService stockTransactionService;

    @PostMapping("/create")
    StockTransaction create(@RequestBody StockTransaction stockTransaction)
    {

        return stockTransactionService.create(stockTransaction);
    }
    @PutMapping("/modify/{id}")
    StockTransaction update(@PathVariable Long id,@RequestBody StockTransaction request)
    {
        return stockTransactionService.update(id,request);
    }
    @GetMapping("/view/{id}")
    StockTransaction getbyId(@PathVariable Long id)
    {
        return stockTransactionService.getbyId(id);
    }
    @GetMapping("/view/list")
    List<StockTransaction> getAll()
    {
        return stockTransactionService.getAll();
    }
    @DeleteMapping("/remove/{id}")
    void deletebyId(@PathVariable Long id)
    {
        stockTransactionService.deletebyId(id);

    }
    @DeleteMapping("/remove/list")
    void deleteAll()
    {
        stockTransactionService.deleteAll();

    }
}
