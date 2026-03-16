package com.example.pharmacy.controller;

import com.example.pharmacy.dto.request.InventoryItemRequestDto;
import com.example.pharmacy.dto.response.InventoryResponseDto;
import com.example.pharmacy.model.InventoryItem;
import com.example.pharmacy.service.InventroyItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/PharmaDispense/InventoryItem")
public class InventoryItemController {

    @Autowired
    private InventroyItemService inventoryItemService;

    @PostMapping("/create")
    public ResponseEntity<InventoryResponseDto> createInventoryItem(@RequestBody InventoryItemRequestDto inventoryitem) {
        return new ResponseEntity<>(inventoryItemService.createInventoryItem(inventoryitem), HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<InventoryResponseDto> getInventoryItemById(@PathVariable Long id) {
        return new ResponseEntity<>(inventoryItemService.getInventoryItemById(id), HttpStatus.OK);
    }

    @GetMapping("/view/list")
    public ResponseEntity<List<InventoryResponseDto>> getAll() {
        return new ResponseEntity<>(inventoryItemService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<InventoryResponseDto> updateInventoryItem(@PathVariable Long id, @RequestBody InventoryItemRequestDto request) {
        return new ResponseEntity<>(inventoryItemService.updateInventoryItem(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteInventoryItemById(@PathVariable Long id) {
        return new ResponseEntity<>(inventoryItemService.deleteInventoryItemById(id), HttpStatus.OK);
    }

    @DeleteMapping("/remove/list")
    public ResponseEntity<String> deleteAll() {
        return new ResponseEntity<>(inventoryItemService.deleteAll(), HttpStatus.OK);
    }

    @GetMapping("/view/reorder")
    public ResponseEntity<List<InventoryResponseDto>> reorderdrugs() {
        return new ResponseEntity<>(inventoryItemService.reorderdrugs(), HttpStatus.OK);
    }

    @GetMapping("/view/quantity/{drugId}")
    public ResponseEntity<Optional<Long>> findquantitybasedonDrug(@PathVariable Long drugId) {
        return new ResponseEntity<>(inventoryItemService.findquantitybasedonDrug(drugId), HttpStatus.OK);
    }
}