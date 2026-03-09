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

    public void updateStatus(Long id,NotificationStatus status){
        Notification notification = repo.findById(id).orElse(null);
        if(notification!=null){
            notification.setStatus(status);
            repo.save(notification);
        }
    }
    public void addUser(Long notificationId,int user_id){
        Notification notification = repo.findById(notificationId).orElse(null);
        if(notification!=null){
            List<User> users = notification.getUserList();
            users.add(user_repo.findById(user_id).orElse(null));
            notification.setUserList(users);
            repo.save(notification);
        }

    }
    public void assignToUsers(Long notificationId, List<User> userList){
        Notification notification = repo.findById(notificationId).orElse(null);
        if(notification!=null){
            notification.setUserList(userList);
            repo.save(notification);
        }

    }

    public void removeUser(Long notificationId,int user_id){
        Notification notification = repo.findById(notificationId).orElse(null);
        if(notification!=null){
            List<User> users = notification.getUserList();
            users.remove(user_repo.findById(user_id).orElse(null));
            notification.setUserList(users);
            repo.save(notification);
        }
    }

}
