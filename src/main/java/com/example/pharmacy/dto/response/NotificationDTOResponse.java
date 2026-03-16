package com.example.pharmacy.dto.response;

import com.example.pharmacy.model.NotificationCategory;
import com.example.pharmacy.model.NotificationStatus;
import com.example.pharmacy.model.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class NotificationDTOResponse {
    long Id;
    String message;
    NotificationCategory category;
    NotificationStatus status;
    LocalDateTime creationDate;
    List<User> userIds;
}
