package com.niit.DAO;

import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.CustomerOrder;

public interface CartItemDAO {
	void saveOrUpdateCartItem(CartItem cartItem);

	void removeCartItem(int cartItemId);

	Cart getCart(int cartId);

	CustomerOrder createOrder(Cart cart);
}
