package com.digiportal.digiportal_bk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digiportal.digiportal_bk.Model.UsersEntity;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity,String>{



}
