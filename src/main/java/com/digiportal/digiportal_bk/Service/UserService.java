package com.digiportal.digiportal_bk.Service;

import java.util.List;

import com.digiportal.digiportal_bk.Model.UsersEntity;

public interface UserService {
UsersEntity saveUsersEntity(UsersEntity usersEntity);
List<UsersEntity> getAllUsers();

}