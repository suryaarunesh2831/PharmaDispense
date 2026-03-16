package com.example.pharmacy.controller;


import com.example.pharmacy.model.PrescriptionItem;
import com.example.pharmacy.service.PrescriptionItemService;
import jakarta.persistence.Access;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Table(name = "PrescriptionItem")
@RequestMapping("/pharmaDispense/PrescriptionItem")
public class PrescriptionItemController {

    @Autowired
    PrescriptionItemService prescriptionItemService;

    @PostMapping("/create")
    public PrescriptionItem createPrescriptionItem(@RequestBody PrescriptionItem prescriptionItem){
        return prescriptionItemService.createPrescriptionItem(prescriptionItem);
    }

    @PutMapping("/update/{id}")
    public  PrescriptionItem upadtePrescriptionItem(@PathVariable Long id,@RequestBody PrescriptionItem prescriptionItem){
        return prescriptionItemService.updatePrescriptionById(id, prescriptionItem);
    }

    @GetMapping("/viewList")
    public List<PrescriptionItem> getAllPrescriptionItem(){
        return prescriptionItemService.getAllPrescriptionItem();
    }
    @GetMapping("/view/{id}")
    public PrescriptionItem getPrescriptionById(@PathVariable Long id){
        return prescriptionItemService.getPrescriptionById(id);
    }
    @DeleteMapping("/remove")
    public void deleteAllPrescriptionItem(){
        prescriptionItemService.deleteAllPrescriptionItem();
    }
}
