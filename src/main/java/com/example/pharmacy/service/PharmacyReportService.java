package com.example.pharmacy.service;
import com.example.pharmacy.model.PharmacyReport;
import com.example.pharmacy.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PharmacyReportService {

    @Autowired
    pharmacyReportRepository reportRepo;

    public PharmacyReport create(PharmacyReport obj){
        return reportRepo.save(obj);
    }

    public List<PharmacyReport> getAllReports(){
        return reportRepo.findAll();
    }

    public Optional<PharmacyReport> readById(int id){
        return reportRepo.findById(id);
    }

    public PharmacyReport update(int id,PharmacyReport obj){
        PharmacyReport existing = reportRepo.findById(id).orElseThrow(
                ()-> new EntityNotFoundException(" Not found "+ id));
        obj.setReportId(existing.getReportId());
        return reportRepo.save(obj);
    }

    public void deleteById(int id){
        reportRepo.deleteById(id);
    }

}
