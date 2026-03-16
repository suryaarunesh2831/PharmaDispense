package com.example.pharmacy.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Verification")
@Data
public class Verification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long verificationId;




    private String pharmacistId;





    private LocalDateTime verifiedDate;


    private String notes;

   @OneToMany
   @JoinColumn(name="Prescription ID")
   List<Prescription> prescriptionList=new ArrayList<>();


    @ManyToOne
    @JoinColumn(name="Pharmacist ID")
    private User user_verification ;







}