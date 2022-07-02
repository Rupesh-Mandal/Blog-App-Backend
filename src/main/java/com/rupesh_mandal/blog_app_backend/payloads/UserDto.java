package com.rupesh_mandal.blog_app_backend.payloads;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Valid
    private int id;

    @NotEmpty()
    @Size(min = 4,message = "Username must be min 4 charactes !!")
    private String name;

    @Email(message = "Email address is not valid !!")
    private String email;

    @NotEmpty
    @Size(min = 4,max = 10,message = "password must be min 4 charactes and max 10 characters !!")
    private String password;

    @NotEmpty
    private String about;

}
