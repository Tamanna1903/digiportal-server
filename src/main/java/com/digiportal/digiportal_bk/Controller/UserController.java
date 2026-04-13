package com.digiportal.digiportal_bk.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digiportal.digiportal_bk.Model.UsersEntity;
import com.digiportal.digiportal_bk.Repository.UserRepository;
import com.digiportal.digiportal_bk.Service.UserService;



@CrossOrigin(origins = "http://localhost:8081") // Allow requests from React app
@RestController

public class UserController {

   
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepository;

    
    @PostMapping("/users")
    public UsersEntity saveUsersEntity( @RequestBody UsersEntity usersEntity) {
        return userService.saveUsersEntity(usersEntity);
    }

    @GetMapping("/getusers")
    public ResponseEntity<List<UsersEntity>> getAllUsers(){
        List<UsersEntity> users=userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<UsersEntity> getUserByUsername(@PathVariable String username){
        UsersEntity user=userRepository.findById(username).orElse(null);
        return ResponseEntity.ok(user);}
    
    
    
    
    
}
