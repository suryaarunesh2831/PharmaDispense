package com.example.pharmacy.service;

import com.example.pharmacy.model.Notification;
import com.example.pharmacy.model.NotificationCategory;
import com.example.pharmacy.model.NotificationStatus;
import com.example.pharmacy.model.User;
import com.example.pharmacy.repository.NotificationRepository;
import com.example.pharmacy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    UserRepo user_repo;
    @Autowired
    NotificationRepository repo;

    public Notification createNotification(Notification notification){
        return repo.save(notification);
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
