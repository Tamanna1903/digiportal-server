package com.digiportal.digiportal_bk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiportal.digiportal_bk.Model.UsersEntity;
import com.digiportal.digiportal_bk.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UsersEntity saveUsersEntity(UsersEntity usersEntity){
        return userRepository.save(usersEntity);
    }
}
