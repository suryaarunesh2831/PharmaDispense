package com.example.pharmacy.dto;

import com.example.pharmacy.model.NotificationCategory;
import com.example.pharmacy.model.NotificationStatus;
import com.example.pharmacy.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class NotificationRequest {
    long Id;
    String msg;
    NotificationCategory category;
    NotificationStatus status;
    LocalDateTime creationDate;
    List<Integer> userIds;
}
