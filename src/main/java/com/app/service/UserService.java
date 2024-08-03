package com.app.service;


import com.app.dto.UserDto;
import com.app.exception.UserNotFoundException;
import com.app.model.User;

import java.util.List;

public interface UserService {

    public User createUSer(UserDto user);

    public List<User> getAllUser();

    public User getByUsername(String username) throws UserNotFoundException;

    public String deleteByUsername(String username) throws UserNotFoundException;


    public User updateUser(UserDto user) throws  UserNotFoundException;
}
