package com.digiportal.digiportal_bk.Model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Password")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordEnity {
    @Id
    @Column(nullable=false,unique=true, name="pwdusername")
    private String pwdusername;

   // @OneToOne(fetch=FetchType.LAZY)
    //@JoinColumn(name="username")
    //private UsersEntity usersEntity;
    @Column(nullable=false,unique=true)
    private String pwdhash;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime UpdatedAt;    
    



}
