package com.super4tech.ecommerce.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class BillingAddress {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String billFullName;
    @Email
    @NotBlank
    private String billEmail;
    @NotBlank
    private String billStreet;
    @NotBlank
    private String billCity;
    @NotBlank
    private String billState;
    @NotBlank
    private String billZip;
}
