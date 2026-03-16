package com.example.pharmacy.model;



import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "Medication_Administration_Records")
public class MAR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MARID;                 // Primary Key
             // Foreign Key → Drug table
    private String Dose;

    private java.time.LocalDateTime ScheduledTime;

    private java.time.LocalDateTime AdministeredTime;   // nullable

    private int NurseID;               // Foreign Key → Nurse table
    private String Status;


}


