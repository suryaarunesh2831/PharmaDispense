package com.example.pharmacy.controller;

import com.example.pharmacy.model.MAR;
import com.example.pharmacy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mar")
public class MarController {

    @Autowired
    MarService service;

    @PostMapping("/post")
    public MAR create(@RequestBody  MAR obj){
        return  service.create(obj);
    }

    @GetMapping("/get/All")
    public List<MAR> read(){
        return service.read();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMAR(@PathVariable int id){
            service.deleteById(id);
    }
}
