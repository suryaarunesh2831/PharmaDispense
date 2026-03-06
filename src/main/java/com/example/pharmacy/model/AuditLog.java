package com.example.pharmacy.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "AuditLog")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AuditID;        // Primary Key
    private String Action;      // CREATE, DELETE, UPDATE, LOGIN, etc.
    private String Resource;    // e.g., "Drug:12" or "/api/admin/users"
    private LocalDateTime Timestamp;
    private String Metadata;    // JSON or text

    @ManyToOne
    @JoinColumn(name="User ID")
    private User user;



}


