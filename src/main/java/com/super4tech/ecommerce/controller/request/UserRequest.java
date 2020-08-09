package com.super4tech.ecommerce.controller.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotEmpty
    @Size(min = 3, max = 50, message = "{Size.validation}")
    private String firstName;

    @NotEmpty
    @Size(min = 4, max = 50, message = "{Size.validation}")
    private String lastName;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 3, max = 50, message = "{Size.validation}")
    private String username;

    @Size(min = 6, max = 100, message = "{Size.validation}")
    @NotEmpty
    private String password;

    @NotEmpty
    private String confirm_password;
}
