package com.example.pharmacy.controller;

import com.example.pharmacy.dto.request.StockTransactionRequestDto;
import com.example.pharmacy.dto.response.StockTransactionResponseDto;
import com.example.pharmacy.service.StockTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PharmaDispense/StockTransaction")
public class StockTransactionController {

    @Autowired
    private StockTransactionService stockTransactionService;

    @PostMapping("/create/{inventoryId}")
    public ResponseEntity<StockTransactionResponseDto> create(@PathVariable Long inventoryId, @RequestBody StockTransactionRequestDto stockTransaction) {
        return new ResponseEntity<>(stockTransactionService.create(inventoryId, stockTransaction), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StockTransactionResponseDto> update(@PathVariable Long id, @RequestBody StockTransactionRequestDto request) {
        return new ResponseEntity<>(stockTransactionService.update(id, request), HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<StockTransactionResponseDto> getbyId(@PathVariable Long id) {
        return new ResponseEntity<>(stockTransactionService.getbyId(id), HttpStatus.OK);
    }

    @GetMapping("/view/list")
    public ResponseEntity<List<StockTransactionResponseDto>> getAll() {
        return new ResponseEntity<>(stockTransactionService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletebyId(@PathVariable Long id) {
        return new ResponseEntity<>(stockTransactionService.deletebyId(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAll() {
        return new ResponseEntity<>(stockTransactionService.deleteAll(), HttpStatus.OK);
    }
}