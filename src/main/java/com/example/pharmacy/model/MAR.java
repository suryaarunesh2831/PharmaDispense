package com.example.pharmacy.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Medication_Administration_Records")
public class MAR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MARID;                 // Primary Key

    @ManyToOne
    @JoinColumn(name = "DrugID")
    private Drug Drug;     // Foreign Key → Drug table

    @ManyToOne
    @JoinColumn(name = "PatientID")
    private Patient PatientID;      // Foreign Key -> Patient table

    @ManyToOne
    @JoinColumn(name = "nurseID")
    private User nurse; // Nurse is current User

    @Column(length = 50)
    private String Dose;

    @Column(name="scheduled_time",nullable = true)
    private LocalDateTime ScheduledTime;

    @Column(name="administered_time",nullable = true)
    private LocalDateTime AdministeredTime; // nullable

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private MARStaus status;        // SCHEDULED/COMPLETED/MISSED


}


