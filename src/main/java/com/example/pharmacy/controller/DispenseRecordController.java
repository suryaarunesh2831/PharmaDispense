package com.example.pharmacy.controller;

import com.example.pharmacy.dto.DispenseRecordDTOResponse;
import com.example.pharmacy.model.DispenseRecord;
import com.example.pharmacy.service.DispenseRecordService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@Data
@RestController
@RequestMapping("/PharmaDispense/DispenseRecord")
public class DispenseRecordController {

    @Autowired
    DispenseRecordService service;
    // View prescription List By dispenseRecord Date
    @GetMapping("/viewByDate/{date}")
    public List<DispenseRecordDTOResponse> viewDispenseRecordByDate(@PathVariable LocalDate date){
        return service.viewDispenseRecordByDate(date);
    }

    // Technician to create DispenseRecord
    @PostMapping("/create")
    public DispenseRecord createDispenseRecord(@RequestBody DispenseRecord record){
        return service.createDispenseRecord(record);
    }

    @GetMapping("/view/{id}")
    public DispenseRecord viewDispenseRecord(@PathVariable Long id){
        return  service.viewDispenseRecord(id);
    }

    //Technician Records number of DispenseRecord
    @GetMapping("/view")
    public List<DispenseRecord> viewAllDispenseRecord(){
        return service.viewAllDispenseRecord();
    }

    @PutMapping("/update")
    public DispenseRecord updateDispenseRecord(@RequestBody DispenseRecord record){
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
