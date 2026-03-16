package com.example.pharmacy.service;

import com.example.pharmacy.dto.request.DrugInteractionRequestDto;
import com.example.pharmacy.dto.response.DrugInteractionResponseDto;
import com.example.pharmacy.model.Drug;
import com.example.pharmacy.model.DrugInteraction;
import com.example.pharmacy.repository.DrugInteractionRepo;
import com.example.pharmacy.repository.DrugRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugInteractionService {

    @Autowired
    DrugInteractionRepo drugInteractionRepo;

    @Autowired
    DrugRepo drugrepo;

    // CREATE
    public DrugInteractionResponseDto createInteraction(DrugInteractionRequestDto interactionDto) {
        Drug mainDrug = drugrepo.findById(interactionDto.getDrug_id()).get();
        Drug interactingDrug = drugrepo.findById(interactionDto.getInteractingdrug_id()).get();

        DrugInteraction drugInteraction = new DrugInteraction();
        drugInteraction.setDrug(mainDrug);
        drugInteraction.setInteractingdrug(interactingDrug);
        drugInteraction.setSeverity(interactionDto.getSeverity());
        drugInteraction.setDescription(interactionDto.getDescription());

        DrugInteraction save = drugInteractionRepo.save(drugInteraction);

        // Convert to ResponseDto
        DrugInteractionResponseDto response = new DrugInteractionResponseDto();
        response.setInteractionID(save.getInteractionID());
        response.setDrug_id(save.getDrug().getDrugId());
        response.setInteractingdrug_id(save.getInteractingdrug().getDrugId());
        response.setSeverity(save.getSeverity());
        response.setDescription(save.getDescription());

        return response;
    }

    // GET BY ID
    public DrugInteractionResponseDto getInteractionById(Long id) {
        DrugInteraction save = drugInteractionRepo.findById(id).get();

        DrugInteractionResponseDto response = new DrugInteractionResponseDto();
        response.setInteractionID(save.getInteractionID());
        response.setDrug_id(save.getDrug().getDrugId());
        response.setInteractingdrug_id(save.getInteractingdrug().getDrugId());
        response.setSeverity(save.getSeverity());
        response.setDescription(save.getDescription());

        return response;
    }

    // GET ALL
    public List<DrugInteractionResponseDto> getAll() {
        List<DrugInteraction> list = drugInteractionRepo.findAll();
        List<DrugInteractionResponseDto> responseList = new ArrayList<>();

        for (DrugInteraction save : list) {
            DrugInteractionResponseDto dto = new DrugInteractionResponseDto();
            dto.setInteractionID(save.getInteractionID());
            dto.setDrug_id(save.getDrug().getDrugId());
            dto.setInteractingdrug_id(save.getInteractingdrug().getDrugId());
            dto.setSeverity(save.getSeverity());
            dto.setDescription(save.getDescription());
            responseList.add(dto);
        }
        return responseList;
    }

    // UPDATE
    public DrugInteractionResponseDto updateInteraction(Long id, DrugInteractionRequestDto request) {
        DrugInteraction existing = drugInteractionRepo.findById(id).get();

        Drug mainDrug = drugrepo.findById(request.getDrug_id()).get();
        Drug interactingDrug = drugrepo.findById(request.getInteractingdrug_id()).get();

        existing.setDrug(mainDrug);
        existing.setInteractingdrug(interactingDrug);
        existing.setSeverity(request.getSeverity());
        existing.setDescription(request.getDescription());

        DrugInteraction save = drugInteractionRepo.save(existing);

        DrugInteractionResponseDto response = new DrugInteractionResponseDto();
        response.setInteractionID(save.getInteractionID());
        response.setDrug_id(save.getDrug().getDrugId());
        response.setInteractingdrug_id(save.getInteractingdrug().getDrugId());
        response.setSeverity(save.getSeverity());
        response.setDescription(save.getDescription());

        return response;
    }

    public String deleteDrugInteractionById(Long id) {
        drugInteractionRepo.deleteById(id);
        return "The interaction is deleted";
    }

    public String deleteAll() {
        drugInteractionRepo.deleteAll();
        return "All the interactions are deleted";
    }

    public Long findcountofrecords() {
        return drugInteractionRepo.findcountofrecords();
    }

    public Long getInteractingDrug(Long id) {
        return drugInteractionRepo.getInteractingDrug(id);
    }

    public List<String> getalternates(Long id) {
        return drugrepo.getDrugAlternatesByDrugId(id);
    }
}