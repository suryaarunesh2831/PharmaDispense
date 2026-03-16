package com.example.pharmacy.controller;

import com.example.pharmacy.dto.response.DispenseRecordDTOLogResponse;
import com.example.pharmacy.dto.request.DispenseRecordDTORequest;
import com.example.pharmacy.dto.response.DispenseRecordDTOResponse;
import com.example.pharmacy.model.DispenseRecord;
import com.example.pharmacy.service.DispenseRecordService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@Data
@RestController
@RequestMapping("/PharmaDispense/DispenseRecord")
public class DispenseRecordController {

    @Autowired
    DispenseRecordService service;
    //1. View prescription List By dispenseRec ord Date
    @GetMapping("/viewByDate/{date}")
    public ResponseEntity<List<DispenseRecordDTOLogResponse>> viewDispenseRecordByDate(@PathVariable LocalDate date){
        List<DispenseRecordDTOLogResponse> body = service.viewDispenseRecordByDate(date);
        return ResponseEntity.ok(body);
    }

    //2. Technician to create DispenseRecord
    @PostMapping("/create")
    public ResponseEntity<DispenseRecordDTOResponse> createDispenseRecord(@RequestBody DispenseRecordDTORequest record){
        DispenseRecordDTOResponse body = service.createDispenseRecord(record);
        return ResponseEntity.ok(body);
    }

    //3. Technician Records number of DispenseRecord
    @GetMapping("/view")
    public ResponseEntity<List<DispenseRecord>> viewAllDispenseRecord(){
        List<DispenseRecord> body = service.viewAllDispenseRecord();
        return ResponseEntity.ok(body);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<DispenseRecordDTOResponse> viewDispenseRecord(@PathVariable Long id){
        DispenseRecordDTOResponse body = service.viewDispenseRecord(id);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/update")
    public DispenseRecordDTOResponse updateDispenseRecord(@RequestBody DispenseRecord record){
        return  service.updateDispenseRecord(record);
    }

    @DeleteMapping("/remove/{id}")
    public void removeDispenseRecord(@PathVariable  Long id){
        service.removeDispenseRecord(id);
    }

    @DeleteMapping("/remove")
    public void removeAllDispenseRecord(){
        service.removeAllDispenseRecord();
    }

}
