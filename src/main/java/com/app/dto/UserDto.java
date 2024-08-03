package com.app.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;

    @NotEmpty(message="username should not be empty or null.")
    @Size(min = 8,message = "username should be minimum 8 char long")
    private String username;

    @NotEmpty(message="username should not be empty or null.")
    @Email(message = "please put a valid email")
    private String email;

    @NotEmpty(message="password should not be empty or null.")
    @Size(min = 6,message = "password should be minimum 6 char long")
    private String password;

    public UserDto(String username, String email, String password) {

        this.username = username;
        this.email = email;
        this.password = password;
    }
}
