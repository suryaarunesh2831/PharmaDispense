package com.example.pharmacy.controller;

import com.example.pharmacy.model.PharmacyReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.pharmacy.service.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/PharmaDispense/PharmacyReport")
public class PharmacyReportController {


    @Autowired
    PharmacyReportService service;

    @GetMapping("/get/All")
    public List<PharmacyReport> getAllReports(){
        return service.getAllReports();
    }

    @GetMapping("/get/{id}")
    public Optional<PharmacyReport> readById(@PathVariable int id){
        return service.readById(id);
    }

    @PostMapping("/post")
    public PharmacyReport create(@RequestBody  PharmacyReport obj){
        return service.create(obj);
    }

    @PutMapping("/update/{id}")
    public PharmacyReport update(@PathVariable int id,@RequestBody PharmacyReport obj){
        return service.update(id,obj);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable  int id){
        service.deleteById(id);
    }
}
