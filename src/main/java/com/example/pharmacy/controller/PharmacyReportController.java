package com.example.pharmacy.controller;
import com.example.pharmacy.dto.request.PharmacyReportDTORequest;
import com.example.pharmacy.dto.response.PharmacyReportDTOResponse;
import com.example.pharmacy.model.PharmacyReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.pharmacy.service.*;
import java.util.List;

@RestController
@RequestMapping("/PharmaDispense/PharmacyReport")
public class PharmacyReportController {


    @Autowired
    PharmacyReportService service;

    @GetMapping("/viewList")
    public List<PharmacyReport> getAllReports(){
        return service.getAllReports();
    }

    @GetMapping("/view/{id}")
    public PharmacyReportDTOResponse readById(@PathVariable int id){
        return service.readById(id);
    }

    @PostMapping("/create")
    public PharmacyReportDTOResponse create(@RequestBody PharmacyReportDTORequest obj){
        return service.create(obj);
    }

    @PutMapping("/update/{id}")
    public PharmacyReport update(@PathVariable int id,@RequestBody PharmacyReport obj){
        return service.update(id,obj);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteById(@PathVariable  int id){
        service.deleteById(id);
    }
}
