package com.example.pharmacy.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Prescription")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;


    private Long patientId;


    private Long physicianId;


    private LocalDateTime createdDate;


    private String status;

    @ManyToOne
    @JoinColumn(name="Physician ID")
    private User user;

    @OneToMany(mappedBy = "prescription")
    List<PrescriptionItem>listofprescription=new ArrayList<>();

    @ManyToOne
    Verification verificationtable;


    @ManyToOne
    DispenseRecord record;


}