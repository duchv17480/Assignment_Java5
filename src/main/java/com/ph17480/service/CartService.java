package com.ph17480.service;

import java.util.Collection;

import com.ph17480.dto.CartItem;

public interface CartService {

	void add(CartItem item);

	Collection<CartItem> getCartItems();

	int getCount();

	double getAmount();

	void update(int productID, int quantity, int total);

	void clear();

	void remove(int productID);


}
