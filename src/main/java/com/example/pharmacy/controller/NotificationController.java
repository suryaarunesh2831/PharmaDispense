package com.example.pharmacy.controller;

import com.example.pharmacy.model.Notification;
import com.example.pharmacy.model.NotificationCategory;
import com.example.pharmacy.model.NotificationStatus;
import com.example.pharmacy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.pharmacy.service.NotificationService;

import java.util.*;

@RequestMapping("api/notification")
@RestController
public class NotificationController {

    @Autowired
    NotificationService service;

    @PostMapping("/create")
    public Notification createNotification(@RequestBody Notification notification){
        return  service.createNotification(notification);
    }

    @GetMapping("/get/All")
    public List<Notification> getNotifications(){
        return service.getNotfications();
    }

    @GetMapping("/get/{id}")
    public Notification getNotification(@PathVariable Long id){
        Optional<Notification> notification = service.getNotification(id);
        return notification.orElse(null);
    }

    @GetMapping("/viewBy/category/{category}")
    public List<Notification> viewByCategory(@PathVariable NotificationCategory category){
        return service.findByCategory(category);
    }

    @GetMapping("/viewBy/status/{status}")
    public List<Notification> viewByStatus(@PathVariable NotificationStatus status){
        return service.findByStatus(status);
    }

    @PostMapping("/{id}/update/{user_id}")
    public void addUser(@PathVariable Long id,@PathVariable int user_id){
        service.addUser(id,user_id);
    }

    @PostMapping("/{id}/removeUser/{user_id}")
    public void removeUser(@PathVariable Long id,@PathVariable int user_id){
        service.removeUser(id,user_id);
    }

    @PostMapping("/{id}/assignUsers")
    public void assignUsers(@PathVariable Long id, @RequestBody List<User> userList){
        service.assignToUsers(id,userList);
    }

}
