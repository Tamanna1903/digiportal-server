package com.digiportal.digiportal_bk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digiportal.digiportal_bk.Model.PasswordEntity;
import com.digiportal.digiportal_bk.Service.PasswordService;

@RestController
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping("/pwd")
    public PasswordEntity passwordEntity(@RequestBody PasswordEntity passwordEntity){
        return passwordService.savePasswordEntity(passwordEntity);
    }

}
