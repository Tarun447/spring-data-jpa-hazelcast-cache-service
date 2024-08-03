package com.app.controller;


import com.app.dto.UserDto;
import com.app.exception.UserNotFoundException;
import com.app.model.User;
import com.app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid  UserDto user)
    {
        return new ResponseEntity<User>(service.createUSer(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllUser()
    {
        return ResponseEntity.ok(service.getAllUser());
    }


    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) throws UserNotFoundException
    {
        return ResponseEntity.ok(service.getByUsername(username));
    }


    @PutMapping
    public ResponseEntity<?> UpdateUser(@RequestBody @Valid  UserDto user)
    {
        return new ResponseEntity<User>(service.updateUser(user), HttpStatus.OK);
    }


    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUserByUsername(@PathVariable String username)
    {
        return ResponseEntity.ok(service.deleteByUsername(username));
    }


}
