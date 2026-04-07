package com.digiportal.digiportal_bk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.digiportal.digiportal_bk.Service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.digiportal.digiportal_bk.Model.UsersEntity;


@RestController

public class UserController {

    @Autowired
    private UserService userService;

    
    @PostMapping("/users")
    public UsersEntity saveUsersEntity( @RequestBody UsersEntity usersEntity) {
        return userService.saveUsersEntity(usersEntity);
    }
    
}
