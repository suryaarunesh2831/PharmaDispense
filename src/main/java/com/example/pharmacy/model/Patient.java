package com.example.pharmacy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 100)
    private String name;
    @Column(unique = true)
    private String email;
    @Column(nullable = false, length = 30)
    private String phone;

}
