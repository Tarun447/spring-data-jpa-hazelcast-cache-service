package com.app.repository;

import com.app.dto.UserDto;
import com.app.exception.UserNotFoundException;
import com.app.model.User;

import java.util.List;


public interface UserRepository {

    public User saveUSer(UserDto user);
    public User getByUsername(String username) throws UserNotFoundException;
    public List<User> getAll();
    public String deleteByUsername(String  username) throws UserNotFoundException;
    public User updateUser(UserDto user) throws UserNotFoundException;

}
