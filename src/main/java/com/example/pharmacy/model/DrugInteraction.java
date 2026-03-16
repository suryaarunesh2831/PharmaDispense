package com.example.pharmacy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "DrugInteraction")
public class DrugInteraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long InteractionID;



    @ManyToOne
    @JoinColumn(name="drug_id")

    private Drug drug;

    @ManyToOne
    @JoinColumn(name="Interacting drug_id")
    private Drug interactingdrug;






    private String Severity;

    private String Description;


    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Drug getInteractingdrug() {
        return interactingdrug;
    }

    public void setInteractingdrug(Drug interactingdrug) {
        this.interactingdrug = interactingdrug;
    }

    public String getSeverity() {
        return Severity;
    }

    public void setSeverity(String severity) {
        Severity = severity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


    public Long getInteractionID() {
        return InteractionID;
    }

    public void setInteractionID(Long interactionID) {
        InteractionID = interactionID;
    }
}

