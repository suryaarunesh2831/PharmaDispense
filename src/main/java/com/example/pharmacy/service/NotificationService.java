package com.example.pharmacy.service;

import com.example.pharmacy.dto.request.NotificationDTORequest;
import com.example.pharmacy.dto.response.NotificationDTOResponse;
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

    //1. create a Notification and set who are receive it
    public NotificationDTOResponse createNotification(NotificationDTORequest request){
        Notification notification=new Notification();
        notification.setNotificationId(request.getId());
        notification.setMessage(request.getMessage());
        notification.setStatus(request.getStatus());
        notification.setCategory(request.getCategory());
        notification.setCreateDate(request.getCreationDate());
        List<User> users = user_repo.findAllById(request.getUserIds());
        notification.setUserList(users);

        Notification saved = repo.save(notification);

        NotificationDTOResponse response = new NotificationDTOResponse();
        response.setId(saved.getNotificationId());
        response.setStatus(saved.getStatus());
        response.setCategory(saved.getCategory());
        response.setCreationDate(saved.getCreateDate());
        response.setMessage(saved.getMessage());
        response.setUserIds(saved.getUserList());// Here Returning Entities Need to Rework
        return response;
    }

    public NotificationDTOResponse getNotification(Long id){
        Optional<Notification> saved = repo.findById(id);
        NotificationDTOResponse response =new NotificationDTOResponse();
        if(saved.isPresent()){
            Notification obj = saved.get();
            response.setId(obj.getNotificationId());
            response.setStatus(obj.getStatus());
            response.setCategory(obj.getCategory());
            response.setCreationDate(obj.getCreateDate());
            response.setMessage(obj.getMessage());
            response.setUserIds(obj.getUserList());
        }
        return response;
    }

    public List<Notification> getNotfications(){
        return repo.findAll();
    }

    public List<Notification> findByCategory(NotificationCategory category){
        return repo.findByCategory(category);
    }
    public List<Notification> findByStatus(NotificationStatus status){
        return repo.findByStatus(status);
    }


}
