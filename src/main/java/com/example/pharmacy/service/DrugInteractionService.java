package com.example.pharmacy.service;

import com.example.pharmacy.model.Drug;
import com.example.pharmacy.model.DrugInteraction;
import com.example.pharmacy.repository.DrugInteractionRepo;
import com.example.pharmacy.repository.DrugRepo;
import org.apache.naming.factory.MailSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
public class DrugInteractionService {

    @Autowired
    DrugInteractionRepo drugInteractionRepo;
    @Autowired
    DrugRepo drugrepo;


    public DrugInteraction createInteraction(@RequestBody DrugInteraction interaction)
    {
        Drug MainDrug=drugrepo.findById(interaction.getDrug().getDrugId()).get();

        Drug InteractingDrug=drugrepo.findById(interaction.getInteractingdrug().getDrugId()).get();

        interaction.setDrug(MainDrug);
        interaction.setInteractingdrug(InteractingDrug);


        return drugInteractionRepo.save(interaction);



    }

    public DrugInteraction getInteractionById(@PathVariable Long id)
    {
        return drugInteractionRepo.findById(id).get();
    }
    @GetMapping("/get/All")
    public List<DrugInteraction> getAll()
    {
        return drugInteractionRepo.findAll();
    }
    @PutMapping("/update/{id}")
    public DrugInteraction updateInteraction(@PathVariable Long id, @RequestBody DrugInteraction request)
    {
        DrugInteraction existing=drugInteractionRepo.findById(id).get();

        existing.setDescription(request.getDescription());
        existing.setSeverity(request.getSeverity());


        Drug MainDrug=drugrepo.findById(request.getDrug().getDrugId()).get();

        Drug InteractingDrug=drugrepo.findById(request.getInteractingdrug().getDrugId()).get();

        existing.setDrug(MainDrug);
        existing.setInteractingdrug(InteractingDrug);


        return drugInteractionRepo.save(existing);



    }
    @DeleteMapping("/delete/{id}")
    public String deleteDrugInteractionById(@PathVariable Long id)
    {

         drugInteractionRepo.deleteById(id);
         return "The interaction is deleted";
    }
    @DeleteMapping("/delete/All")
    public String deleteAll()
    {

         drugInteractionRepo.deleteAll();
         return "All the interactions are deleted";
    }


}
