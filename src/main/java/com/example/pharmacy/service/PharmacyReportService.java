package com.example.pharmacy.service;
import com.example.pharmacy.dto.request.PharmacyReportDTORequest;
import com.example.pharmacy.dto.response.PharmacyReportDTOResponse;
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

    public PharmacyReportDTOResponse create(PharmacyReportDTORequest request){
        PharmacyReport report = new PharmacyReport();
        report.setReportId(request.getReportId());
        report.setMetrics(request.getMetrics());
        report.setScope(request.getScope());
        report.setGeneratedDate(request.getGeneratedDate());

        PharmacyReport saved = reportRepo.save(report);

        PharmacyReportDTOResponse response = new PharmacyReportDTOResponse();
        response.setReportId(saved.getReportId());
        response.setScope(saved.getScope());
        response.setMetrics(saved.getMetrics());
        response.setGeneratedDate(saved.getGeneratedDate());
        return response;
    }

    public PharmacyReportDTOResponse readById(int id){
        Optional<PharmacyReport> saved = reportRepo.findById(id);
        PharmacyReportDTOResponse response = new PharmacyReportDTOResponse();
        if(saved.isPresent()){
            PharmacyReport obj = saved.get();
            response.setReportId(obj.getReportId());
            response.setScope(obj.getScope());
            response.setMetrics(obj.getMetrics());
            response.setGeneratedDate(obj.getGeneratedDate());
        }
        return response;
    }

    public List<PharmacyReport> getAllReports(){
        return reportRepo.findAll();
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
