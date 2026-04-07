package com.digiportal.digiportal_bk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.digiportal.digiportal_bk.Model.UsersEntity;
import com.digiportal.digiportal_bk.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
   //private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
   private final PasswordEncoder passwordEncoder;
   public UserServiceImpl(PasswordEncoder passwordEncoder){
    this.passwordEncoder=passwordEncoder;
   }

    
    
    @Override
    public UsersEntity saveUsersEntity(UsersEntity usersEntity){
        usersEntity.setPassword(passwordEncoder.encode(usersEntity.getPassword()));
        System.out.println(usersEntity.getPassword());
        return userRepository.save(usersEntity);

    }
}
