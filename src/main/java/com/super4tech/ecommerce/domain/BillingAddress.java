package com.super4tech.ecommerce.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.tomcat.jni.Address;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;


//@Getter
//@Setter
//@NoArgsConstructor
//@DiscriminatorValue("billing")
//@ToString
public class BillingAddress extends Address {

    private long id;

}
