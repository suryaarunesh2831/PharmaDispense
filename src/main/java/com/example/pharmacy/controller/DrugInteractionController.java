package com.example.pharmacy.controller;

import com.example.pharmacy.model.Drug;
import com.example.pharmacy.model.DrugInteraction;
import com.example.pharmacy.service.DrugInteractionService;
import com.example.pharmacy.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/DrugInteraction")
public class DrugInteractionController {

    @Autowired
    DrugInteractionService drugInteractionService;

    @PostMapping("/post")
    public DrugInteraction createInteraction(@RequestBody DrugInteraction interaction)
    {
        return drugInteractionService.createInteraction(interaction);

    }
    @GetMapping("/get/{id}")
    public DrugInteraction getInteractionById(@PathVariable Long id)
    {
        return drugInteractionService.getInteractionById(id);
    }
    @GetMapping("/get/All")
    public List<DrugInteraction> getAll()
    {
        return drugInteractionService.getAll();
    }
    @PutMapping("/update/{id}")
    public DrugInteraction updateInteraction(@PathVariable Long id,@RequestBody DrugInteraction request)
    {
        return drugInteractionService.updateInteraction(id,request);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteDrugInteractionById(@PathVariable Long id)
    {
        return drugInteractionService.deleteDrugInteractionById(id);
    }
    @DeleteMapping("/delete/All")
    public String deleteAll()
    {

        return drugInteractionService.deleteAll();
    }


}
