package com.example.pharmacy.service;

import com.example.pharmacy.dto.NotificationRequest;
import com.example.pharmacy.model.Notification;
import com.example.pharmacy.model.NotificationCategory;
import com.example.pharmacy.model.NotificationStatus;
import com.example.pharmacy.model.User;
import com.example.pharmacy.repository.NotificationRepository;
import com.example.pharmacy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    UserRepo user_repo;
    @Autowired
    NotificationRepository repo;

    //1. create a Notification and set who are receive it
    public Notification createNotification(NotificationRequest notification){
        Notification obj=new Notification();
        obj.setNotificationId(notification.getId());
        obj.setMessage(notification.getMsg());
        obj.setStatus(notification.getStatus());
        obj.setCategory(notification.getCategory());
        obj.setCreateDate(notification.getCreationDate());
        List<User> users = user_repo.findAllById(notification.getUserIds());
        obj.setUserList(users);
        return repo.save(obj);
    }

    public List<Notification> getNotfications(){
        return repo.findAll();
    }

    public Optional<Notification> getNotification(Long id){
        return repo.findById(id);
    }

    public List<Notification> findByCategory(NotificationCategory category){
        return repo.findByCategory(category);
    }
    public List<Notification> findByStatus(NotificationStatus status){
        return repo.findByStatus(status);
    }


}
