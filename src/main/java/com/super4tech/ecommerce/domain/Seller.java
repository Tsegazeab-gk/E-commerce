package com.super4tech.ecommerce.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Seller {
    @Id
    @GeneratedValue
    private Long serllerId;


    @NotBlank
    private String fullName;

    @Valid
    @Embedded
    private PhoneNumber phoneNumber;

    @NotBlank
    @Email
    private String email;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_Id")
    @Valid
    private User user;


}
