package com.digiportal.digiportal_bk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.digiportal.digiportal_bk.Model.PasswordEntity;
import com.digiportal.digiportal_bk.Repository.PasswordRepository;

@Service
public class PasswordServiceImpl implements PasswordService{
    
    @Autowired
    private PasswordRepository passwordRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public PasswordEntity savePasswordEntity(PasswordEntity passwordEntity){
        passwordEntity.setPwdhash(passwordEncoder.encode(passwordEntity.getPwdhash()));
        System.out.println(passwordEntity.getPwdhash());
        return passwordRepository.save(passwordEntity);
    }

}
