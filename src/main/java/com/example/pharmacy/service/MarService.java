package com.example.pharmacy.service;

import com.example.pharmacy.dto.request.MarDTORequest;
import com.example.pharmacy.dto.response.MarDTOResponse;
import com.example.pharmacy.repository.*;
import com.example.pharmacy.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MarService {

    @Autowired
    UserRepo user_repo;
    @Autowired
    DrugRepo drug_repo;
    @Autowired
    marRepository marRepo;

    public MarDTOResponse create(MarDTORequest request){
        MAR mar = new MAR();
        mar.setMARID(request.getMARID());

        Optional<User> nurse = user_repo.findById(request.getNurseId());
        User obj = new User();
        if(nurse.isPresent()){
            obj= nurse.get();
        }

        mar.setNurse(obj);
        mar.setDose(request.getDose());

        Optional<Drug> drug = drug_repo.findById(request.getDrugId());
        Drug drug_obj = new Drug();
        if(drug.isPresent()){
            drug_obj = drug.get();
        }

        mar.setDrug(drug_obj);
        mar.setStatus(request.getStatus());


        mar.setPatientID(request.getPatient());
        mar.setAdministeredTime(request.getAdministeredTime());
        mar.setScheduledTime(request.getScheduledTime());

        MAR saved = marRepo.save(mar);

        MarDTOResponse response = new MarDTOResponse();
        response.setMARID(saved.getMARID());
        response.setDose(saved.getDose());
        response.setNurseId(saved.getNurse().getUserID());
        response.setDrugId(saved.getDrug().getDrugId());
        response.setStatus(saved.getStatus());
        response.setPatient(saved.getPatientID());
        response.setScheduledTime(saved.getScheduledTime());
        response.setAdministeredTime(saved.getAdministeredTime());

        return response;
    }


    public List<MAR> read(){
        return marRepo.findAll();
    }

    public void deleteById(int id){
        marRepo.deleteById(id);
    }
}
