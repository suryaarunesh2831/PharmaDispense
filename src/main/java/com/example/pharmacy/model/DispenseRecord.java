package com.example.pharmacy.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "DispenseRecord")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DispenseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dispenseId;

    @OneToOne
    @JoinColumn(name="Prescription ID")
    Prescription prescription;


    private Long dispensedQuantity;
    private LocalDate dispensedDate;

     @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name="Pharmacist ID")
     private User user;

}