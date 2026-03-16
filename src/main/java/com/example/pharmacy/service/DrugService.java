package com.example.pharmacy.service;

import com.example.pharmacy.dto.request.DrugRequestDto;
import com.example.pharmacy.dto.response.DrugResponseDto;
import com.example.pharmacy.model.Drug;
import com.example.pharmacy.repository.DrugRepo;
import com.example.pharmacy.exception.DrugNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugService {

    @Autowired
    private DrugRepo drugRepo;

    // ---------------- CREATE ONE -----------------
    public DrugResponseDto createdrug(DrugRequestDto dto)
    {
        Drug drug = new Drug();

        drug.setGenericName(dto.getGenericName());
        drug.setBrandName(dto.getBrandName());
        drug.setStrength(dto.getStrength());
        drug.setRoute(dto.getRoute());
        drug.setClassification(dto.getClassification());
        drug.setStatus(dto.getStatus());
        drug.setDrugAlternates(dto.getDrugAlternates());

        Drug saved = drugRepo.save(drug);

        DrugResponseDto res = new DrugResponseDto();
        res.setDrugId(saved.getDrugId());
        res.setGenericName(saved.getGenericName());
        res.setBrandName(saved.getBrandName());
        res.setStrength(saved.getStrength());
        res.setRoute(saved.getRoute());
        res.setClassification(saved.getClassification());
        res.setStatus(saved.getStatus());
        res.setDrugAlternates(saved.getDrugAlternates());

        return res;
    }

    // ---------------- CREATE MULTIPLE -----------------
    public List<DrugResponseDto> createdrugs(List<DrugRequestDto> drugitems)
    {
        List<DrugResponseDto> responseList = new ArrayList<>();

        for (DrugRequestDto dto : drugitems)
        {
            Drug drug = new Drug();
            drug.setGenericName(dto.getGenericName());
            drug.setBrandName(dto.getBrandName());
            drug.setStrength(dto.getStrength());
            drug.setRoute(dto.getRoute());
            drug.setClassification(dto.getClassification());
            drug.setStatus(dto.getStatus());
            drug.setDrugAlternates(dto.getDrugAlternates());

            Drug saved = drugRepo.save(drug);

            DrugResponseDto res = new DrugResponseDto();
            res.setDrugId(saved.getDrugId());
            res.setGenericName(saved.getGenericName());
            res.setBrandName(saved.getBrandName());
            res.setStrength(saved.getStrength());
            res.setRoute(saved.getRoute());
            res.setClassification(saved.getClassification());
            res.setStatus(saved.getStatus());
            res.setDrugAlternates(saved.getDrugAlternates());

            responseList.add(res);
        }

        return responseList;
    }

    // ---------------- GET ONE BY ID -----------------
    public DrugResponseDto getDrugById(Long id)
    {
        Drug drug = drugRepo.findById(id)
                .orElseThrow(() -> new DrugNotFoundException("Drug not found with id " + id));

        DrugResponseDto res = new DrugResponseDto();
        res.setDrugId(drug.getDrugId());
        res.setGenericName(drug.getGenericName());
        res.setBrandName(drug.getBrandName());
        res.setStrength(drug.getStrength());
        res.setRoute(drug.getRoute());
        res.setClassification(drug.getClassification());
        res.setStatus(drug.getStatus());
        res.setDrugAlternates(drug.getDrugAlternates());

        return res;
    }

    // ---------------- GET ALL -----------------
    public List<DrugResponseDto> getAll()
    {
        List<Drug> list = drugRepo.findAll();
        List<DrugResponseDto> resList = new ArrayList<>();

        for (Drug drug : list)
        {
            DrugResponseDto res = new DrugResponseDto();
            res.setDrugId(drug.getDrugId());
            res.setGenericName(drug.getGenericName());
            res.setBrandName(drug.getBrandName());
            res.setStrength(drug.getStrength());
            res.setRoute(drug.getRoute());
            res.setClassification(drug.getClassification());
            res.setStatus(drug.getStatus());
            res.setDrugAlternates(drug.getDrugAlternates());

            resList.add(res);
        }

        return resList;
    }

    // ---------------- UPDATE -----------------
    public DrugResponseDto updatedrug(Long id, DrugRequestDto request)
    {
        Drug existing = drugRepo.findById(id)
                .orElseThrow(() -> new DrugNotFoundException("Drug not found with id " + id));

        existing.setGenericName(request.getGenericName());
        existing.setBrandName(request.getBrandName());
        existing.setStrength(request.getStrength());
        existing.setRoute(request.getRoute());
        existing.setClassification(request.getClassification());
        existing.setStatus(request.getStatus());
        existing.setDrugAlternates(request.getDrugAlternates());

        Drug saved = drugRepo.save(existing);

        DrugResponseDto res = new DrugResponseDto();
        res.setDrugId(saved.getDrugId());
        res.setGenericName(saved.getGenericName());
        res.setBrandName(saved.getBrandName());
        res.setStrength(saved.getStrength());
        res.setRoute(saved.getRoute());
        res.setClassification(saved.getClassification());
        res.setStatus(saved.getStatus());
        res.setDrugAlternates(saved.getDrugAlternates());

        return res;
    }

    // ---------------- GET ALL SORTED -----------------
    public List<DrugResponseDto> getAllSorted()
    {
        List<Drug> list = drugRepo.sortDrug();
        List<DrugResponseDto> resList = new ArrayList<>();

        for (Drug drug : list)
        {
            DrugResponseDto res = new DrugResponseDto();
            res.setDrugId(drug.getDrugId());
            res.setGenericName(drug.getGenericName());
            res.setBrandName(drug.getBrandName());
            res.setStrength(drug.getStrength());
            res.setRoute(drug.getRoute());
            res.setClassification(drug.getClassification());
            res.setStatus(drug.getStatus());
            res.setDrugAlternates(drug.getDrugAlternates());

            resList.add(res);
        }

        return resList;
    }

    // ---------------- DELETE ONE -----------------
    public String deleteDrugById(Long id)
    {
        if (!drugRepo.existsById(id)) {
            throw new DrugNotFoundException("Drug not found with id " + id);
        }
        drugRepo.deleteById(id);
        return "The drug has been successfully deleted";
    }

    // ---------------- DELETE ALL -----------------
    public String deleteAll()
    {
        drugRepo.deleteAll();
        return "The drug table has been successfully cleared";
    }
}