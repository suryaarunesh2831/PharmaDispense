package com.example.pharmacy.controller;



import com.example.pharmacy.model.InventoryItem;
import com.example.pharmacy.service.InventroyItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/InventoryItem")
public class InventoryItemController {

    @Autowired
    InventroyItemService inventoryItemService;

    @PostMapping("/post")
    public InventoryItem createInventoryItem(@RequestBody InventoryItem inventoryitem)
    {
        return inventoryItemService.createInventoryItem(inventoryitem);

    }
    @GetMapping("/get/{id}")
    public InventoryItem getInventoryItemById(@PathVariable Long id)
    {
        return inventoryItemService.getInventoryItemById(id);
    }
    @GetMapping("/get/All")
    public List<InventoryItem> getAll()
    {
        return inventoryItemService.getAll();
    }
    @PutMapping("/update/{id}")
    public InventoryItem updateInventoryItem(@PathVariable Long id,@RequestBody InventoryItem request)
    {
        return inventoryItemService.updateInventoryItem(id,request);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteInventoryItemById(@PathVariable Long id)
    {

        return inventoryItemService.deleteInventoryItemById(id);
    }
    @DeleteMapping("/delete/All")
    public String deleteAll()
    {

        return inventoryItemService.deleteAll();
    }



}
