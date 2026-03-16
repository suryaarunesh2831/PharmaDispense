package com.example.pharmacy.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DispenseRecord")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DispenseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long dispenseId;






    private Long DispensedQuantity;

    private LocalDateTime  DispensedDate;

    @OneToMany
    @JoinColumn(name="Prescription ID")
    List<Prescription> prescriptionList=new ArrayList<>();

     @ManyToOne
     @JoinColumn(name="Pharmacist ID")
     private User user;







}