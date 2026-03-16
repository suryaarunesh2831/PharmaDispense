package com.example.pharmacy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long notificationId;
    private String message;
    @Enumerated(EnumType.STRING)
    private NotificationCategory category;
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;
    private LocalDateTime createDate;

    @ManyToMany
    @JoinTable(name = "user_notifications",
            joinColumns = @JoinColumn(name = "notification_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<User> userList=new ArrayList<>();
}