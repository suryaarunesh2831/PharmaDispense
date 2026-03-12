package com.example.pharmacy.controller;

import com.example.pharmacy.model.Drug;
import com.example.pharmacy.model.DrugInteraction;
import com.example.pharmacy.service.DrugInteractionService;
import com.example.pharmacy.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/PharmaDispense/DrugInteraction")
public class DrugInteractionController {

    @Autowired
    DrugInteractionService drugInteractionService;

    @PostMapping("/create")
    public DrugInteraction createInteraction(@RequestBody DrugInteraction interaction)
    {
        return drugInteractionService.createInteraction(interaction);

    }
    @GetMapping("/view/{id}")
    public DrugInteraction getInteractionById(@PathVariable Long id)
    {
        return drugInteractionService.getInteractionById(id);
    }
    @GetMapping("/view/list")
    public List<DrugInteraction> getAll()
    {
        return drugInteractionService.getAll();
    }
    @PutMapping("/modify/{id}")
    public DrugInteraction updateInteraction(@PathVariable Long id,@RequestBody DrugInteraction request)
    {
        return drugInteractionService.updateInteraction(id,request);
    }
    @DeleteMapping("/remove/{id}")
    public String deleteDrugInteractionById(@PathVariable Long id)
    {
        return drugInteractionService.deleteDrugInteractionById(id);
    }
    @DeleteMapping("/remove/list")
    public String deleteAll()
    {

        return drugInteractionService.deleteAll();
    }

    @GetMapping("/view/count")
    public Long findcountofrecords()
    {
        return drugInteractionService.findcountofrecords();
    }
    @GetMapping("/view/pair/{drugid}")
    public Long getInteractingDrug(@PathVariable Long drugid)
    {
        return drugInteractionService.getInteractingDrug(drugid);

    }
    @GetMapping("/view/alternates/{drugid}")
    public List<String>getalternates(@PathVariable Long drugid)
    {
        return drugInteractionService.getalternates(drugid);
    }


}
