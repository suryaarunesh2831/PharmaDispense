package com.example.pharmacy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.util.*;
@Data
@Entity
@Table(name = "User")   // IMPORTANT: escape reserved table name
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    private String name;
    private String role;
    private String email;
    private String phone;

    @Setter
    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<AuditLog>auditlog;
    public User() {}

    @OneToMany(mappedBy ="user" )
    @JsonManagedReference("user-prescriptions")
    private List<Prescription> prescriptions=new ArrayList<>();

    @OneToMany(mappedBy = "user_verification")
    List<Verification>verificationList=new ArrayList<>();


}