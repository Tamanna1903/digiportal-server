package com.digiportal.digiportal_bk.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name="Digiusers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersEntity {

    @Id
    @Column(nullable=false,unique=true,name="username")
    private String username;

   //@OneToOne(mappedBy="digiusers",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    //private PasswordEnity passwordEnity;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false, unique=false)
    private String name;

    @Column(nullable=false,length=10,unique=true)
    private String phone;

    @Column(nullable=true,unique=false,length=1)
    private char gender;

    @Column(nullable=false,unique=false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate DOB;


    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime UpdatedAt;    


}
