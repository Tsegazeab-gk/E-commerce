package com.super4tech.ecommerce.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 4, max = 50, message = "{Size.validation}")
    private String firstName;
    @Size(min = 4, max = 50, message = "{Size.validation}")
    private String lastName;
    @Email(message = "{email.validation}")
    private String email;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_Id")
    @Valid
    private User user;
}

