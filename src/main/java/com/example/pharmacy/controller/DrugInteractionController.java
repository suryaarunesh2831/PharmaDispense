package com.example.pharmacy.controller;

import com.example.pharmacy.dto.request.DrugInteractionRequestDto;
import com.example.pharmacy.dto.response.DrugInteractionResponseDto;
import com.example.pharmacy.service.DrugInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PharmaDispense/DrugInteraction")
public class DrugInteractionController {

    @Autowired
    DrugInteractionService drugInteractionService;

    // ---------------- CREATE ONE (DTO -> ResponseDTO) -----------------
    @PostMapping("/create")
    public ResponseEntity<DrugInteractionResponseDto> createInteraction(@RequestBody DrugInteractionRequestDto interaction)
    {
        return new ResponseEntity<>(drugInteractionService.createInteraction(interaction), HttpStatus.OK);
    }

    // ---------------- GET ONE BY ID (ResponseDTO) -----------------
    @GetMapping("/view/{id}")
    public ResponseEntity<DrugInteractionResponseDto> getInteractionById(@PathVariable Long id)
    {
        return new ResponseEntity<>(drugInteractionService.getInteractionById(id), HttpStatus.OK);
    }

    // ---------------- GET ALL (List<ResponseDTO>) -----------------
    @GetMapping("/view/list")
    public ResponseEntity<List<DrugInteractionResponseDto>> getAll()
    {
        return new ResponseEntity<>(drugInteractionService.getAll(), HttpStatus.OK);
    }

    // ---------------- UPDATE (DTO -> ResponseDTO) -----------------
    @PutMapping("/modify/{id}")
    public ResponseEntity<DrugInteractionResponseDto> updateInteraction(@PathVariable Long id, @RequestBody DrugInteractionRequestDto request)
    {
        return new ResponseEntity<>(drugInteractionService.updateInteraction(id, request), HttpStatus.OK);
    }

    // ---------------- DELETE BY ID -----------------
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteDrugInteractionById(@PathVariable Long id)
    {
        return new ResponseEntity<>(drugInteractionService.deleteDrugInteractionById(id), HttpStatus.OK);
    }

    // ---------------- DELETE ALL -----------------
    @DeleteMapping("/remove/list")
    public ResponseEntity<String> deleteAll()
    {
        return new ResponseEntity<>(drugInteractionService.deleteAll(), HttpStatus.OK);
    }

    // ---------------- COUNT -----------------
    @GetMapping("/view/count")
    public ResponseEntity<Long> findcountofrecords()
    {
        return new ResponseEntity<>(drugInteractionService.findcountofrecords(), HttpStatus.OK);
    }

    // ---------------- NUMBER OF INTERACTING DRUGS FOR A DRUG -----------------
    @GetMapping("/view/pair/{drugid}")
    public ResponseEntity<Long> getInteractingDrug(@PathVariable Long drugid)
    {
        return new ResponseEntity<>(drugInteractionService.getInteractingDrug(drugid), HttpStatus.OK);
    }

    // ---------------- ALTERNATES FOR A DRUG (BASIC VALUES) -----------------
    @GetMapping("/view/alternates/{drugid}")
    public ResponseEntity<List<String>> getalternates(@PathVariable Long drugid)
    {
        return new ResponseEntity<>(drugInteractionService.getalternates(drugid), HttpStatus.OK);
    }
}