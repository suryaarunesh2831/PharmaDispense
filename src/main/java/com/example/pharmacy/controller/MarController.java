package com.example.pharmacy.controller;

import com.example.pharmacy.dto.request.MarDTORequest;
import com.example.pharmacy.dto.response.MarDTOResponse;
import com.example.pharmacy.model.MAR;
import com.example.pharmacy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PharmaDispense/Mar")
public class MarController {

    @Autowired
    MarService service;

    @PostMapping("/create")
    public ResponseEntity<MarDTOResponse> create(@RequestBody MarDTORequest obj){
        MarDTOResponse body = service.create(obj);
        return ResponseEntity.ok(body);
    }

    @GetMapping("/viewList")
    public ResponseEntity<List<MAR>> read(){
        List<MAR> body = service.read();
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> deleteMAR(@PathVariable int id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
