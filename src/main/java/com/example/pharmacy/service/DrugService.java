package com.example.pharmacy.service;

import com.example.pharmacy.model.Drug;
import com.example.pharmacy.repository.DrugRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DrugService {
    @Autowired
    DrugRepo drugRepo;

    public  Drug createdrug(Drug drugitem)
    {
        return drugRepo.save(drugitem);
    }

    public Drug getDrugById( Long id)
    {
        return drugRepo.findById(id).orElse(null);
    }

    public List<Drug> getAll()
    {
        return drugRepo.findAll();
    }

    public Drug updatedrug(Long id, Drug request)
    {
        Drug existing=drugRepo.findById(id).get();

        existing.setGenericName(request.getGenericName());
        existing.setBrandName(request.getBrandName());
        existing.setStrength(request.getStrength());
        existing.setRoute(request.getRoute());
        existing.setClassification(request.getClassification());
        existing.setStatus(request.getStatus());

        return drugRepo.save(existing);


    }

    public String deleteDrugById(Long id)
    {
        drugRepo.deleteById(id);
        return "The drug has been successfully deleted";
    }

    public String deleteAll()
    {
        drugRepo.deleteAll();
        return "The drug table has been successfully cleared";
    }



}
