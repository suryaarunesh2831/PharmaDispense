package com.example.pharmacy.service;

import com.example.pharmacy.dto.request.PrescriptionDTORequest;
import com.example.pharmacy.model.Prescription;
import com.example.pharmacy.model.User;

import com.example.pharmacy.repository.PrescriptionItemRepository;
import com.example.pharmacy.repository.PrescriptionRepository;
import com.example.pharmacy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionItemRepository prescriptionItemRepo;
    @Autowired
    private PrescriptionRepository prescriptionRepo;
    @Autowired
    private UserRepo userRepo;
    public Prescription createPrescription(Integer userId, PrescriptionDTORequest obj) {

        User user = userRepo.findById(userId).orElse(null);

        if (user != null) {
            Prescription prescription = new Prescription();
            prescription.setUser(user);
            prescription.setCreatedDate(obj.getCreatedDate());
            prescription.setStatus(obj.getStatus());
            prescription.setPatientId(obj.getPatientId());
            if(obj.getItemIds()!=null)
             prescription.setItem(prescriptionItemRepo.findAllById(obj.getItemIds()));
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
