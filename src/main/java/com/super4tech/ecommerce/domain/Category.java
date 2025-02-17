package com.super4tech.ecommerce.domain;

import javax.persistence.*;
import java.util.List;



@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long categoryId;

    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Product> products;


	@Override
	public String toString() {
		return "Category{" +
				"categoryId=" + categoryId +
				", categoryName='" + categoryName + '\'' +

				'}';
	}

	public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}


}
