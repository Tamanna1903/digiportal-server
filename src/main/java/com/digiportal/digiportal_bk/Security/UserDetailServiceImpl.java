package com.digiportal.digiportal_bk.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.digiportal.digiportal_bk.Model.PasswordEntity;
import com.digiportal.digiportal_bk.Model.UsersEntity;
import com.digiportal.digiportal_bk.Repository.PasswordRepository;
import com.digiportal.digiportal_bk.Repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordRepository passwordRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // Load from your UsersEntity
        UsersEntity user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User not found: " + username));
        
         PasswordEntity passwordEntity = passwordRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Password not found for user: " + username));


        return User.withUsername(user.getUsername())
                .password(passwordEntity.getPwdhash())
                .roles("USER")
                .build();
    }
}