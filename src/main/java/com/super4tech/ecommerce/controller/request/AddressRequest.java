package com.super4tech.ecommerce.controller.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

    private Long id;

    @NotEmpty
    private String street;

    @NotEmpty
    private String city;

    @NotEmpty
    @Pattern(regexp = "[\\w]{2}", message = "State mus be 2 words!")
    private String state;

}
