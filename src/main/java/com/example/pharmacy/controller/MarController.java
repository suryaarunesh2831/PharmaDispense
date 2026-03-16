package com.example.pharmacy.controller;

import com.example.pharmacy.dto.request.MarDTORequest;
import com.example.pharmacy.dto.response.MarDTOResponse;
import com.example.pharmacy.model.MAR;
import com.example.pharmacy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PharmaDispense/Mar")
public class MarController {

    @Autowired
    MarService service;

    @PostMapping("/create")
    public MarDTOResponse create(@RequestBody MarDTORequest obj){
        return service.create(obj);
    }

    @GetMapping("/viewList")
    public List<MAR> read(){
        return service.read();
    }

    @DeleteMapping("/remove/{id}")
    public void deleteMAR(@PathVariable int id){
            service.deleteById(id);
    }
}
