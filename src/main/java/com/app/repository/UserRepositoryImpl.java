package com.app.repository;

import com.app.dto.UserDto;
import com.app.exception.UserNotFoundException;
import com.app.model.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private EntityManager entityManager;


    @Autowired
    private ModelMapper mapper;

    @Override
    @Transactional
    public User saveUSer(UserDto user) {

        User  us = mapper.map(user,User.class);
        us.setUsername(us.getUsername().toLowerCase());
        entityManager.persist(us);
        return us;
    }

    @Override
    public User getByUsername(String username) throws UserNotFoundException {
        User user = entityManager.createQuery("select u from User u where u.username=:username",User.class)
                .setParameter("username",username.toLowerCase()).getSingleResult();
       if(user!=null)
       {
           return  user;
       }else{
           throw new UserNotFoundException("User not found with username "+username);
       }

    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u",User.class).getResultList();
    }

    @Override
    @Transactional
    public String deleteByUsername(String username) throws UserNotFoundException {
        User user = entityManager.createQuery("select u from User u where u.username=:username",User.class)
                .setParameter("username",username.toLowerCase()).getSingleResult();
        if(user!=null)
        {
            entityManager.remove(user);
            return  "user record deleted with username "+username;
        }else{
            throw new UserNotFoundException("User not found with username "+username);
        }

    }

    @Override
    @Transactional
    public User updateUser(UserDto user) throws UserNotFoundException {
        User us = entityManager.createQuery("select u from User u where u.username=:username",User.class)
                .setParameter("username",user.getUsername().toLowerCase()).getSingleResult();
        if(us!=null)
        {
                us.setUsername(user.getUsername());
                us.setPassword(user.getPassword());
                us.setEmail(user.getEmail());
            entityManager.merge(us);

           return us;
        }else{
            throw new UserNotFoundException("User not found");
        }
    }
}
