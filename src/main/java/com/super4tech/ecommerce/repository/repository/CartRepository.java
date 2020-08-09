package com.super4tech.ecommerce.repository.repository;

import com.super4tech.ecommerce.domain.Cart;

public interface CartRepository {

	Cart create(Cart cart);

	Cart read(String cartId);

	void update(String cartId, Cart cart);

	void delete(String cartId);

	void emptyCart(String cartId);
}
