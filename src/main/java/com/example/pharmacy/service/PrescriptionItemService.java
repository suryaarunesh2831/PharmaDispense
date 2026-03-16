package com.example.pharmacy.service;


import com.example.pharmacy.model.Drug;
import com.example.pharmacy.model.Prescription;
import com.example.pharmacy.model.PrescriptionItem;
import com.example.pharmacy.repository.DrugRepo;
import com.example.pharmacy.repository.PrescriptionItemRepository;
import com.example.pharmacy.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrescriptionItemService {

    @Autowired
    PrescriptionItemRepository prescriptionItemRepository;
    @Autowired
    PrescriptionRepository prescriptionRepository;
    @Autowired
    DrugRepo drugRepository;

    public PrescriptionItem createPrescriptionItem(PrescriptionItem prescriptionItem) {

        // 1. Check and fetch Prescription
        if (prescriptionItem.getPrescription() == null ||
                prescriptionItem.getPrescription().getPrescriptionId() == null) {
            throw new RuntimeException("prescriptionId is missing in JSON");
        }

        Prescription prescription = prescriptionRepository
                .findById(prescriptionItem.getPrescription().getPrescriptionId())
                .orElseThrow(() -> new RuntimeException("Prescription not found"));

        // 2. Check and fetch Drug
        if (prescriptionItem.getDrugObj() == null ||
                prescriptionItem.getDrugObj().getDrugId() == null) {
            throw new RuntimeException("drugObj.drugId is missing in JSON");
        }

        Drug drug = drugRepository
                .findById(prescriptionItem.getDrugObj().getDrugId())
                .orElseThrow(() -> new RuntimeException("Drug not found"));

        // 3. Add item to prescription list
        List<PrescriptionItem> list = prescription.getItem();
        if (list == null) list = new ArrayList<>();
        list.add(prescriptionItem);

        // 4. Set relationships
        prescriptionItem.setPrescription(prescription);
        prescriptionItem.setDrugObj(drug);

        prescription.setItem(list);

        // 5. Save
        return prescriptionItemRepository.save(prescriptionItem);
    }

    public List<PrescriptionItem> getAllPrescriptionItem(){
        return prescriptionItemRepository.findAll();
    }

    public PrescriptionItem getPrescriptionById(Long id){
        return prescriptionItemRepository.findById(id).orElse(null);
    }

    public PrescriptionItem updatePrescriptionById(Long id,PrescriptionItem updatedPrescriptionItem){
        PrescriptionItem existingPrescriptionItem = prescriptionItemRepository.findById(id).orElse(null);

        existingPrescriptionItem.setDose(updatedPrescriptionItem.getDose());
        existingPrescriptionItem.setDurationDays(updatedPrescriptionItem.getDurationDays());
        existingPrescriptionItem.setFrequency(updatedPrescriptionItem.getFrequency());
        existingPrescriptionItem.setQuantity(updatedPrescriptionItem.getQuantity());

        return prescriptionItemRepository.save(existingPrescriptionItem);
    }

    public void deleteAllPrescriptionItem(){
        prescriptionItemRepository.deleteAll();
    }
}