package com.example.pharmacy.controller;

import com.example.pharmacy.model.Drug;
import com.example.pharmacy.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PharmaDispense/Drug")
public class DrugController {

    @Autowired
    DrugService drugservice;

    @PostMapping("/create")
     public  Drug createdrug(@RequestBody Drug drugitem)
    {
          return drugservice.createdrug(drugitem);

    }

    @PostMapping("/create/list")
    public  List<Drug> createdrugs(@RequestBody List<Drug>drugitems)
    {
        return drugservice.createdrugs(drugitems);

    }
    @GetMapping("/view/{id}")
    public Drug getDrugById(@PathVariable Long id)
    {
        return drugservice.getDrugById(id);
    }
    @GetMapping("/view/list/unsorted")
    public List<Drug> getAll()
    {
        return drugservice.getAll();
    }
    @GetMapping("/view/list/sorted")
    public List<Drug> getAllSorted()
    {
        return drugservice.getAllSorted();
    }


    @PutMapping("/modify/{id}")
    public Drug updatedrug(@PathVariable Long id,@RequestBody Drug request)
    {
        return drugservice.updatedrug(id,request);
    }
    @DeleteMapping("/remove/{id}")
    public String deleteDrugById(@PathVariable Long id)
    {

        return drugservice.deleteDrugById(id);
    }
    @DeleteMapping("/remove/list")
    public String deleteAll()
    {

        return drugservice.deleteAll();
    }


}
