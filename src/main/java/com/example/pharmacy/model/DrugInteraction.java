package com.example.pharmacy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "DrugInteraction")
public class DrugInteraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int InteractionID;             // Primary Key
                // Foreign Key → Drug table

    private int InteractingDrugID;         // Foreign Key → Drug table (interacting drug)

    private String Severity;

    private String Description;

    @OneToOne
    @JoinColumn(name="Drug ID")
    private Drug drugObj;

    @ManyToMany(mappedBy = "drugInteractions")
    private List<Drug>drugList=new ArrayList<>();



}

