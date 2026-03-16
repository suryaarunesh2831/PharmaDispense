package com.example.pharmacy.service;

import com.example.pharmacy.model.User;
import com.example.pharmacy.repository.UserRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public User createUser(User user) {
        return userRepo.save(user);
    }

    public List<User> createUsers(List<User> users) {
        return userRepo.saveAll(users);
    }

    public User getUserById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    public User updateUser(Integer id,User user) {
        User existingUser = userRepo.findById(id).orElse(null);
        if (existingUser != null) {
            user.setUserID(id);
            return userRepo.save(user);
        }
        return null;
    }
    public String deleteUser(Integer id)
    {
        User existingUser=userRepo.findById(id).orElse(null);
        if(existingUser!=null)
        {
            userRepo.deleteById(id);
            return "User deleted successfully";
        }
        return "User not found";
    }
    public String deleteAllUser()
    {
        userRepo.deleteAll();
        return "All users are deleted";
    }

}
