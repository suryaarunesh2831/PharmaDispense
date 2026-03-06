package com.example.pharmacy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PrescriptionItem {

    @Id
    String ItemID;
   //Prescryption ID
   //DrugId
    @OneToOne
    @JoinColumn(name="Drug ID")
    private Drug drugObj;

   int Dose;
   int Frequency;
   int DurationDays;
   int Quantity;


   @ManyToOne
   @JoinColumn(name="Prescription ID")
   private Prescription prescription;

}