package com.digiportal.digiportal_bk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digiportal.digiportal_bk.Model.DocumentEntity;

public interface DocumentRepository extends JpaRepository<DocumentEntity, String> {

}
