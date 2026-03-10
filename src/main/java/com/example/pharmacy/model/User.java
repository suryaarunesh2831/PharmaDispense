package com.example.pharmacy.model;

/* IGNORE THIS BLOCK
    public class User {
 */
    /** Business key used across the system as FK in many tables. *//*
    private String userId;
/*
    /** Person's display name. *//*
    private String name;

    /** Role: Physician / Pharmacist / Technician / Inventory / Admin. *//*
    private String role;

    /** Unique email used for login/communication. *//*
    private String email;

    /** Optional contact number. *//*
    private String phone;*/
/*
    // --- Constructors ---
    public User() {}
    public User(String userId, String name, String role, String email, String phone) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.email = email;
        this.phone = phone;
    }

    // --- Getters & Setters ---
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}   */

import com.example.pharmacy.model.AuditLog;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserID;     // Primary Key

    private String Name;    // Full Name

    private String Role;    // Physician / Pharmacist / Technician / Inventory / Admin

    private String Email;   // Unique email

    private String Phone;   // Contact No.

    @OneToMany(mappedBy = "user")
    private List<AuditLog>auditlog;

    @OneToMany(mappedBy ="user" )
    List<Prescription> listofprescription=new ArrayList<>();

    @ManyToMany
            @JoinTable(
                    name="UserNotification table",
                    joinColumns = @JoinColumn(name="UserID"),
                    inverseJoinColumns = @JoinColumn(name="NotificationId")

            )
    List<Notification>notificationList=new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Verification>verificationList=new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<DispenseRecord>verificationList2=new ArrayList<>();



}