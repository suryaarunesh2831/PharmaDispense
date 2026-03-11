package com.example.pharmacy.controller;



import com.example.pharmacy.model.InventoryItem;
import com.example.pharmacy.service.InventroyItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/PharmaDispense/InventoryItem")
public class InventoryItemController {

    @Autowired
    InventroyItemService inventoryItemService;

    @PostMapping("/create")
    public InventoryItem createInventoryItem(@RequestBody InventoryItem inventoryitem)
    {
        return inventoryItemService.createInventoryItem(inventoryitem);

    }
    @GetMapping("/view/{id}")
    public InventoryItem getInventoryItemById(@PathVariable Long id)
    {
        return inventoryItemService.getInventoryItemById(id);
    }
    @GetMapping("/view/list")
    public List<InventoryItem> getAll()
    {
        return inventoryItemService.getAll();
    }
    @PutMapping("/modify/{id}")
    public InventoryItem updateInventoryItem(@PathVariable Long id,@RequestBody InventoryItem request)
    {
        return inventoryItemService.updateInventoryItem(id,request);
    }
    @DeleteMapping("/remove/{id}")
    public String deleteInventoryItemById(@PathVariable Long id)
    {

        return inventoryItemService.deleteInventoryItemById(id);
    }
    @DeleteMapping("/remove/list")
    public String deleteAll()
    {

        return inventoryItemService.deleteAll();
    }
    @GetMapping("/view/reorder")
    public List<InventoryItem>reorderdrugs()
    {
    return inventoryItemService.reorderdrugs();
    }

    @GetMapping("/view/{drugId}")
    public Optional<Long> findquantitybasedonDrug(@PathVariable Long drugId)
    {
        return inventoryItemService.findquantitybasedonDrug(drugId);
    }



}
