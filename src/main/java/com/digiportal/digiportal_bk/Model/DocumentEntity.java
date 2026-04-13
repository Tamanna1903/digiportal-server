package com.digiportal.digiportal_bk.Model;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Documents")
public class DocumentEntity {

    @Id
    @Column(nullable=false,unique=true,name="username")
    private String username;

    @Column(nullable=false,unique=false)
    private String documentType;

    @Column(nullable=false,unique=false)
    private String documentNumber;

    @Column(nullable=false,unique=false)
    private boolean isActive;

    @Column(nullable=false,unique=false)
    private byte[] documentData;

     @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime UpdatedAt;


}
