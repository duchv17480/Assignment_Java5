package com.ph17480.service.Iplm;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.ph17480.dto.CartItem;
import com.ph17480.service.CartService;
@Service
@SessionScope
public class CartServiceIplm implements CartService{
	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
	
	@Override
	public void add(CartItem item) {
		CartItem exitseditem = map.get(item.getId());
		if (exitseditem !=null) {
			exitseditem.setAvailable(item.getAvailable()+exitseditem.getAvailable());
		}else {
			map.put(item.getId(), item);
		}
	}
	@Override
	public Collection<CartItem> getCartItems() {
		return map.values();
	}
	@Override
	public void remove(int productID) {
		map.remove(productID);
	}
	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public void update(int productID, int quantity) {
		CartItem item = map.get(productID);
		item.setAvailable(quantity + item.getAvailable());
		if (item.getAvailable() <= 0) {
			map.remove(productID);
		}

	}

	@Override
	public double getAmount() {
		return map.values().stream().mapToDouble(item -> item.getAvailable() * item.getPrice()).sum();

	}
	@Override
	public int getCount() {
		if (map.isEmpty()) {
			return 0;
		}
		return map.values().size();
	}
	
}
