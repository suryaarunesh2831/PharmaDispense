package com.example.pharmacy.service;

import com.example.pharmacy.model.Prescription;
import com.example.pharmacy.model.User;

import com.example.pharmacy.repository.PrescriptionRepository;
import com.example.pharmacy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;


@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepo;
    @Autowired
    private UserRepo userRepo;
    public Prescription createPrescription(Integer userId, Prescription prescription) {
        User user = userRepo.findById(userId).orElse(null);

        if (user != null) {
            prescription.setUser(user);
            return prescriptionRepo.save(prescription);
        }
        return null;
    }
    public List<Prescription> getAllPrescriptions()
    {
        return prescriptionRepo.findAll();
    }
    public Prescription getPrescriptionById(Long id)
    {
        Prescription prescription=prescriptionRepo.findById(id).orElse(null);
        return prescription;
    }
    public String deletePrescription(Long id)
    {
        Prescription prescription=prescriptionRepo.findById(id).orElse(null);
        if (prescription!=null)
        {
            prescriptionRepo.deleteById(id);
            return "Prescription deleted successfuly";
        }
        return "Prescription not found";
    }
}
