package com.example.pharmacy.controller;

import com.example.pharmacy.dto.request.DrugRequestDto;
import com.example.pharmacy.dto.response.DrugResponseDto;
import com.example.pharmacy.service.DrugService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/PharmaDispense/Drug")
public class DrugController {

    @Autowired
    DrugService drugservice;

    // ---------------- CREATE ONE (DTO -> ResponseDTO) -----------------
    @PostMapping("/create")
    public ResponseEntity<DrugResponseDto> createdrug(@Valid @RequestBody DrugRequestDto drugitem)
    {
        return new ResponseEntity<>(drugservice.createdrug(drugitem), HttpStatus.OK);
    }

    // ---------------- CREATE MANY (Entity list) -----------------
    @PostMapping("/create/list")
    public ResponseEntity<List<DrugResponseDto>> createdrugs(@Valid @RequestBody List<DrugRequestDto> drugitems)
    {
        return new ResponseEntity<>(drugservice.createdrugs(drugitems), HttpStatus.OK);
    }

    // ---------------- GET ONE BY ID (returns entity) -----------------
    @GetMapping("/view/{id}")
    public ResponseEntity<DrugResponseDto> getDrugById(@PathVariable Long id)
    {
        return new ResponseEntity<>(drugservice.getDrugById(id), HttpStatus.OK);
    }

    // ---------------- GET ALL UNSORTED -----------------
    @GetMapping("/view/list/unsorted")
    public ResponseEntity<List<DrugResponseDto>> getAll()
    {
        return new ResponseEntity<>(drugservice.getAll(), HttpStatus.OK);
    }

    // ---------------- GET ALL SORTED -----------------
    @GetMapping("/view/list/sorted")
    public ResponseEntity<List<DrugResponseDto>> getAllSorted()
    {
        return new ResponseEntity<>(drugservice.getAllSorted(), HttpStatus.OK);
    }

    // ---------------- UPDATE (takes entity, returns entity) -----------------
    @PutMapping("/modify/{id}")
    public ResponseEntity<DrugResponseDto> updatedrug(@PathVariable Long id, @Valid @RequestBody DrugRequestDto request)
    {
        return new ResponseEntity<>(drugservice.updatedrug(id, request), HttpStatus.OK);
    }

    // ---------------- DELETE BY ID -----------------
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteDrugById(@PathVariable Long id)
    {
        return new ResponseEntity<>(drugservice.deleteDrugById(id), HttpStatus.OK);
    }

    // ---------------- DELETE ALL -----------------
    @DeleteMapping("/remove/list")
    public ResponseEntity<String> deleteAll()
    {
        return new ResponseEntity<>(drugservice.deleteAll(), HttpStatus.OK);
    }
}