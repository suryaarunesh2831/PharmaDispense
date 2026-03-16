package com.example.pharmacy.dto.request;

import com.example.pharmacy.model.NotificationCategory;
import com.example.pharmacy.model.NotificationStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class NotificationDTORequest {
    long Id;
    String message;
    NotificationCategory category;
    NotificationStatus status;
    LocalDateTime creationDate;
    List<Integer> userIds;
}
