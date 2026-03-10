package com.example.pharmacy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.*;
@Data
@Entity
@Table(name = "`User`")   // IMPORTANT: escape reserved table name
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    private String name;
    private String role;
    private String email;
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<AuditLog>auditlog;
    public User() {}

    @OneToMany(mappedBy ="user" )
    private List<Prescription> prescriptions=new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Verification>verificationList=new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<DispenseRecord>verificationList2=new ArrayList<>();

}