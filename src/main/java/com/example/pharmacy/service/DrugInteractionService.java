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


    public DrugInteraction createInteraction( DrugInteraction interaction)
    {
        Drug MainDrug=drugrepo.findById(interaction.getDrug().getDrugId()).get();

        Drug InteractingDrug=drugrepo.findById(interaction.getInteractingdrug().getDrugId()).get();

        interaction.setDrug(MainDrug);
        interaction.setInteractingdrug(InteractingDrug);


        return drugInteractionRepo.save(interaction);



    }

    public DrugInteraction getInteractionById( Long id)
    {
        return drugInteractionRepo.findById(id).get();
    }
    public List<DrugInteraction> getAll()
    {
        return drugInteractionRepo.findAll();
    }

    public DrugInteraction updateInteraction( Long id, DrugInteraction request)
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

    public String deleteDrugInteractionById( Long id)
    {

         drugInteractionRepo.deleteById(id);
         return "The interaction is deleted";
    }

    public String deleteAll()
    {

         drugInteractionRepo.deleteAll();
         return "All the interactions are deleted";
    }

    public Long findcountofrecords()
    {
        return drugInteractionRepo.findcountofrecords();
    }

    public Long getInteractingDrug(Long id)
    {


        return drugInteractionRepo.getInteractingDrug(id);

    }
    public List<String>getalternates(Long id)
    {

        return drugrepo.getDrugAlternatesByDrugId(id);
    }

}
