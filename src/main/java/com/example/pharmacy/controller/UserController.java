package com.example.pharmacy.controller;
import com.example.pharmacy.model.User;
import com.example.pharmacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/user")
public class UserController {
    //roles:Physician,Pharmacist,Pharmacy Technician,Inventory Manager,Admin,Nurse
    @Autowired
    private UserService userService;
    @PostMapping("/post")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @PostMapping("/post/All")
    public List<User> createUsers(@RequestBody List<User> users) {
        return userService.createUsers(users);
    }

    @GetMapping("/get/{id}")
    public  User getUserById(@PathVariable Integer id)
    {
        return userService.getUserById(id);
    }
    @GetMapping("/get/All")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }
    @PutMapping("/put/{id}")
    public User updateUser(@PathVariable Integer id,@RequestBody User user)
    {
        return userService.updateUser(id,user);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id)
    {
        return userService.deleteUser(id);
    }
    @DeleteMapping("/delete/All")
    public String deleteAllUser()
    {
        return userService.deleteAllUser();
    }
    //   @OneToMany(mappedBy = "user")
//    private List<AuditLog>auditlog;
//
//    @OneToMany(mappedBy ="user" )
//    List<Prescription> listofprescription=new ArrayList<>();
//
//    @ManyToMany
//            @JoinTable(
//                    name="UserNotification table",
//                    joinColumns = @JoinColumn(name="UserID"),
//                    inverseJoinColumns = @JoinColumn(name="NotificationId")
//
//            )
//    List<Notification>notificationList=new ArrayList<>();
//
//    @OneToMany(mappedBy = "user")
//    List<Verification>verificationList=new ArrayList<>();
//
//    @OneToMany(mappedBy = "user")
//    List<DispenseRecord>verificationList2=new ArrayList<>();




}