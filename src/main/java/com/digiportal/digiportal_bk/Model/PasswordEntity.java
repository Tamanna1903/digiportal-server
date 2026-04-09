package com.digiportal.digiportal_bk.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
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
public class PasswordEntity {
    @Id
    @Column(nullable=false,unique=false, name="pwdusername")
    private String pwdusername;

   // @OneToOne(fetch=FetchType.LAZY)
    //@JoinColumn(name="username")
    //private UsersEntity usersEntity;
    @Column(nullable=false,unique=false)
    @Pattern(
        regexp=".*[!@£$%^&*()].*",
        message="Password must contain a special character"
    )
    private String pwdhash;

       @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime UpdatedAt;
    



}
