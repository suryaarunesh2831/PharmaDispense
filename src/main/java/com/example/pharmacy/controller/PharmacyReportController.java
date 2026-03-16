package com.example.pharmacy.controller;
import com.example.pharmacy.dto.request.PharmacyReportDTORequest;
import com.example.pharmacy.dto.response.PharmacyReportDTOResponse;
import com.example.pharmacy.model.PharmacyReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.pharmacy.service.*;
import java.util.List;

@RestController
@RequestMapping("/PharmaDispense/PharmacyReport")
public class PharmacyReportController {


    @Autowired
    PharmacyReportService service;

    @GetMapping("/viewList")
    public ResponseEntity<List<PharmacyReport>> getAllReports(){
        List<PharmacyReport> body = service.getAllReports();
        return ResponseEntity.ok(body);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<PharmacyReportDTOResponse> readById(@PathVariable int id){
        PharmacyReportDTOResponse body = service.readById(id);
        return ResponseEntity.ok(body);
    }

    @PostMapping("/create")
    public ResponseEntity<PharmacyReportDTOResponse> create(@RequestBody PharmacyReportDTORequest obj){
        PharmacyReportDTOResponse body = service.create(obj);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PharmacyReport> update(@PathVariable int id,@RequestBody PharmacyReport obj){
        PharmacyReport body = service.update(id,obj);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable  int id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
