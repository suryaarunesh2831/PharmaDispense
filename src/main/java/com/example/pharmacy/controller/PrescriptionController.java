package com.example.pharmacy.controller;

import com.example.pharmacy.dto.PrescriptionDTORequest;
import com.example.pharmacy.model.Prescription;
import com.example.pharmacy.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/PharmaDispense/Prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;
    @PostMapping("/create/{userId}")
    public Prescription createPrescription(@PathVariable Integer userId, @RequestBody PrescriptionDTORequest prescription)
    {
        return prescriptionService.createPrescription(userId,prescription);
    }
    @GetMapping("/all")
    public List<Prescription> getAllPrescriptions()
    {
        return prescriptionService.getAllPrescriptions();
    }
    @GetMapping("/{id}")
    public Prescription getPrescriptionById(@PathVariable Long id)
    {
        return prescriptionService.getPrescriptionById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deletePrescription(@PathVariable Long id)
    {
        return prescriptionService.deletePrescription(id);
    }
}
 