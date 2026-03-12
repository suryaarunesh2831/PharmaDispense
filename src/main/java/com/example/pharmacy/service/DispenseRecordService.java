package com.example.pharmacy.service;

import com.example.pharmacy.dto.DispenseRecordDTOResponse;
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

    // 1. view dispenseRecord by date in Admin Dashboard
    public List<DispenseRecordDTOResponse> viewDispenseRecordByDate(LocalDate date){
        Optional<DispenseRecord> obj = dispense_repo.findByDispensedDate(date);
        if(obj.isEmpty()){
            return new ArrayList<>();
        }

        List<DispenseRecordDTOResponse> result = new ArrayList<>();

        DispenseRecord record = obj.get();
        Prescription prescription = record.getPrescription();
        for(PrescriptionItem item: prescription.getItem())
        {
            result.add(new DispenseRecordDTOResponse(
                    item.getDrugObj().getDrugId(),
                    item.getDrugObj().getBrandName(),
                    item.getQuantity(),
                    record.getDispensedDate()));
        }
        return result;
    }
    // 2. create dispense Record by Technician
    public DispenseRecord createDispenseRecord(DispenseRecord record){
        DispenseRecord obj = new DispenseRecord();
        obj.setDispensedDate(record.getDispensedDate());
        obj.setDispensedQuantity(record.getDispensedQuantity());

        Prescription pres = prescription_repo.findById(record.getPrescription().getPrescriptionId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Prescription not found: id=" + record.getPrescription().getPrescriptionId()));
        obj.setPrescription(pres);

        User user = user_repo.findById(record.getUser().getUserID()).orElse(null);
        if(user!=null){
            obj.setUser(user);
        }
        return dispense_repo.save(obj);
    }

    public DispenseRecord viewDispenseRecord(Long id){
        return dispense_repo.findById(id).orElse(null);
    }

    public List<DispenseRecord> viewAllDispenseRecord(){
        return dispense_repo.findAll();
    }

    public DispenseRecord updateDispenseRecord(DispenseRecord record){
        return dispense_repo.save(record);
    }

    public void removeDispenseRecord(Long id){
        dispense_repo.deleteById(id);
    }

    public void removeAllDispenseRecord(){
        dispense_repo.deleteAll();
    }
}
