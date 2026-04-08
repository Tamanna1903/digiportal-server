package com.digiportal.digiportal_bk.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.digiportal.digiportal_bk.Service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.digiportal.digiportal_bk.Model.UsersEntity;
import org.springframework.web.bind.annotation.GetMapping;




@RestController

public class UserController {

   
    @Autowired
    private UserService userService;

    
    @PostMapping("/users")
    public UsersEntity saveUsersEntity( @RequestBody UsersEntity usersEntity) {
        return userService.saveUsersEntity(usersEntity);
    }

    @GetMapping("/getusers")
    public ResponseEntity<List<UsersEntity>> getAllUsers(){
        List<UsersEntity> users=userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    
    
    
    
}
