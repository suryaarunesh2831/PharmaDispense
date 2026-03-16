package com.example.pharmacy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PrescriptionItem {

    @Id
    int ItemID;

    @OneToOne
    @JoinColumn(name="Drug ID")
    private Drug drugObj;

   int Dose;
   int Frequency;
   int DurationDays;
   int Quantity;


   @ManyToOne
   @JsonBackReference
   @JoinColumn(name="Prescription ID")
   private Prescription prescription;
}