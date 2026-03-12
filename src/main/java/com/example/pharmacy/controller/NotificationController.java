package com.example.pharmacy.controller;

import com.example.pharmacy.dto.NotificationRequest;
import com.example.pharmacy.model.Notification;
import com.example.pharmacy.model.NotificationCategory;
import com.example.pharmacy.model.NotificationStatus;
import com.example.pharmacy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.pharmacy.service.NotificationService;

import java.util.*;

@RequestMapping("/PharmaDispense/Notification")
@RestController
public class NotificationController {

    @Autowired
    NotificationService service;

    // Created after certain actions ( creating prescriptions,Out of Stock... )
    @PostMapping("/create")
    public Notification createNotification(@RequestBody NotificationRequest notification){
        return  service.createNotification(notification);
    }

    // Admin Views all notifications
    @GetMapping("/get/All")
    public List<Notification> getNotifications(){
        return service.getNotfications();
    }

    // Admin views notifications by category
    @GetMapping("/viewBy/category/{category}")
    public List<Notification> viewByCategory(@PathVariable NotificationCategory category){
        return service.findByCategory(category);
    }

    @GetMapping("/get/{id}")
    public Notification getNotification(@PathVariable Long id){
        Optional<Notification> notification = service.getNotification(id);
        return notification.orElse(null);
    }


    @GetMapping("/viewBy/status/{status}")
    public List<Notification> viewByStatus(@PathVariable NotificationStatus status){
        return service.findByStatus(status);
    }

}
