package com.example.pharmacy.controller;

import com.example.pharmacy.dto.request.NotificationDTORequest;
import com.example.pharmacy.dto.response.NotificationDTOResponse;
import com.example.pharmacy.model.Notification;
import com.example.pharmacy.model.NotificationCategory;
import com.example.pharmacy.model.NotificationStatus;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<NotificationDTOResponse> createNotification(@RequestBody NotificationDTORequest notification){
        NotificationDTOResponse body = service.createNotification(notification);
        return  ResponseEntity.ok(body);
    }

    // Admin Views all notifications
    @GetMapping("/viewList")
    public ResponseEntity<List<Notification>> getNotifications(){
        List<Notification> body = service.getNotfications();
        return ResponseEntity.ok(body);
    }

    // Admin views notifications by category
    @GetMapping("/viewBy/category/{category}")
    public ResponseEntity<List<Notification>> viewByCategory(@PathVariable NotificationCategory category){
        List<Notification> body = service.findByCategory(category);
        return ResponseEntity.ok(body);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<NotificationDTOResponse> getNotification(@PathVariable Long id){
        NotificationDTOResponse body = service.getNotification(id);
        return ResponseEntity.ok(body);
    }


    @GetMapping("/viewBy/status/{status}")
    public ResponseEntity<List<Notification>> viewByStatus(@PathVariable NotificationStatus status){
        List<Notification> body = service.findByStatus(status);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/removeNotificationList")
    public ResponseEntity<Void> removeNotificationList(){
        service.deleteAllNotification();
        return ResponseEntity.noContent().build();
    }

}
