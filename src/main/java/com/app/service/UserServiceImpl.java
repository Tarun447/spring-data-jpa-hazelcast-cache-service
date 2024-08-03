package com.app.service;

import com.app.dto.UserDto;
import com.app.exception.UserNotFoundException;
import com.app.model.User;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;



    @Override
    public User createUSer(UserDto user) {
        return repo.saveUSer(user);
    }

    @Override
    public List<User> getAllUser() {
        return repo.getAll();
    }

    @Override
    @Cacheable(cacheNames = "userCache",key = "#username")
    public User getByUsername(String username) throws UserNotFoundException {
        return repo.getByUsername(username);
    }

    @Override
    @CacheEvict(cacheNames = "userCache",key = "#username")
    public String deleteByUsername(String username)  throws UserNotFoundException {
        return repo.deleteByUsername(username);
    }

    @Override
    @CachePut(cacheNames = "userCache",key = "#user.getUsername")
    public User updateUser(UserDto user) throws UserNotFoundException {
        return repo.updateUser(user);
    }
}
