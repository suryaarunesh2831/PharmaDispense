package com.example.pharmacy.controller;

import com.example.pharmacy.model.Drug;
import com.example.pharmacy.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drug")
public class DrugController {

    @Autowired
    DrugService drugservice;

    @PostMapping("/post")
    public  Drug createdrug(@RequestBody Drug drugitem)
    {
        return drugservice.createdrug(drugitem);

    }
    @GetMapping("/get/{id}")
    public Drug getDrugById(@PathVariable Long id)
    {
        return drugservice.getDrugById(id);
    }
    @GetMapping("/get/All")
    public List<Drug> getAll()
    {
        return drugservice.getAll();
    }
    @PutMapping("/update/{id}")
    public Drug updatedrug(@PathVariable Long id,@RequestBody Drug request)
    {
        return drugservice.updatedrug(id,request);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteDrugById(@PathVariable Long id)
    {
        return drugservice.deleteDrugById(id);
    }
    @DeleteMapping("/delete/All")
    public String deleteAll()
    {
        drugservice.deleteAll();
        return drugservice.deleteAll();
    }
}