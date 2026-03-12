package com.example.pharmacy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.*;
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

    public List<AuditLog> getAuditlog() {
        return auditlog;
    }

    public void setAuditlog(List<AuditLog> auditlog) {
        this.auditlog = auditlog;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<AuditLog>auditlog;
    public User() {}

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @OneToMany(mappedBy ="user" )
    private List<Prescription> prescriptions=new ArrayList<>();
    //
//    @ManyToMany
//            @JoinTable(
//                    name="UserNotification table",
//                    joinColumns = @JoinColumn(name="UserID"),
//                    inverseJoinColumns = @JoinColumn(name="NotificationId")
//
//            )
//    List<Notification>notificationList=new ArrayList<>();
//


    @OneToMany(mappedBy = "user_verification")
    List<Verification>verificationList=new ArrayList<>();


}