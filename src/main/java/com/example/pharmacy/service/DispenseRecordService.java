package com.example.pharmacy.service;

import com.example.pharmacy.dto.request.DispenseRecordDTORequest;
import com.example.pharmacy.dto.response.DispenseRecordDTOLogResponse;
import com.example.pharmacy.dto.response.DispenseRecordDTOResponse;
import com.example.pharmacy.model.DispenseRecord;
import com.example.pharmacy.model.Prescription;
import com.example.pharmacy.model.PrescriptionItem;
import com.example.pharmacy.model.User;
import com.example.pharmacy.repository.DispenseRepository;
import com.example.pharmacy.repository.PrescriptionItemRepository;
import com.example.pharmacy.repository.PrescriptionRepository;
import com.example.pharmacy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DispenseRecordService {

    @Autowired
    UserRepo user_repo;

    @Autowired
    DispenseRepository dispense_repo;

    @Autowired
    PrescriptionRepository prescription_repo;

    @Autowired
    PrescriptionItemRepository prescriptionItem_repo;


    // 1. view dispenseRecord by date in Admin Dashboard (Pending)
    public List<DispenseRecordDTOLogResponse> viewDispenseRecordByDate(LocalDate date) {
        List<DispenseRecord> records = dispense_repo.findByDispensedDate(date);
        if (records == null || records.isEmpty()) {
            return List.of();
        }

        return records.stream()
                .flatMap(record -> {
                    Prescription p = record.getPrescription();
                    if (p == null || p.getItem() == null || p.getItem().isEmpty()) {
                        return Stream.empty();
                    }
                    return p.getItem().stream()
                            .map(item -> new DispenseRecordDTOLogResponse(
                                    item.getDrugObj() != null ? item.getDrugObj().getDrugId() : null,
                                    item.getDrugObj() != null ? item.getDrugObj().getBrandName() : null,
                                    item.getQuantity(),
                                    record.getDispensedDate()
                            ));
                })
                .toList();
    }


    // 2. create dispense Record by Technician
    public DispenseRecordDTOResponse createDispenseRecord(DispenseRecordDTORequest record){
        DispenseRecord obj = new DispenseRecord();
        obj.setDispensedDate(record.getDispensedDate());
        obj.setDispensedQuantity(record.getDispensedQuantity());

        // setting prescription to DispenseRecord
        Prescription pres = prescription_repo.findById(record.getPrescriptionId())
                .orElse(null);
        obj.setPrescription(pres);

        // setting prescription to User
        User user = user_repo.findById(record.getUserId()).orElse(null);
        if(user!=null){
            obj.setUser(user);
        }

        DispenseRecord saved = dispense_repo.save(obj);
        DispenseRecordDTOResponse response = new DispenseRecordDTOResponse();
        response.setDispensedDate(obj.getDispensedDate());
        response.setDispensedQuantity(obj.getDispensedQuantity());
        response.setPrescriptionId(obj.getPrescription().getPrescriptionId());
        response.setUserId(obj.getUser().getUserID());
        return response;
    }

    public DispenseRecordDTOResponse viewDispenseRecord(Long id){
        DispenseRecord record = dispense_repo.findById(id).orElse(null);
        DispenseRecordDTOResponse response = new DispenseRecordDTOResponse();
        response.setDispensedDate(record.getDispensedDate());
        response.setDispensedQuantity(record.getDispensedQuantity());
        response.setPrescriptionId(record.getPrescription().getPrescriptionId());
        response.setUserId(record.getUser().getUserID());
        return response;
    }


    public DispenseRecordDTOResponse updateDispenseRecord(DispenseRecord record){
        DispenseRecord saved = dispense_repo.save(record);
        DispenseRecordDTOResponse response = new DispenseRecordDTOResponse();
        response.setDispensedDate(saved.getDispensedDate());
        response.setDispensedQuantity(saved.getDispensedQuantity());
        response.setPrescriptionId(record.getPrescription().getPrescriptionId());
        response.setUserId(record.getUser().getUserID());
        return response;
    }

    public List<DispenseRecord> viewAllDispenseRecord(){
        return dispense_repo.findAll();
    }
    public void removeDispenseRecord(Long id){
        dispense_repo.deleteById(id);
    }

    public void removeAllDispenseRecord(){
        dispense_repo.deleteAll();
    }
}
