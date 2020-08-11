package com.super4tech.ecommerce.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany
    private List<Product> products;

}
