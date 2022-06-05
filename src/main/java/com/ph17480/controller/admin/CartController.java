package com.ph17480.controller.admin;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ph17480.dto.CartItem;
import com.ph17480.entity.Product;
import com.ph17480.repositories.ProductRepositories;
import com.ph17480.service.CartService;

@Controller
@RequestMapping("admin/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductRepositories proRepo;
	
	@GetMapping("/list")
	public String list(Model model) {
		Collection<CartItem> cartItem = cartService.getCartItems();
		model.addAttribute("cartItem",cartItem);
		model.addAttribute("total",cartService.getAmount());
		model.addAttribute("NoOfItem",cartService.getCount());
		return "admin/carts/list";
	}
	@GetMapping("/add/{id}")
	public String add (@PathVariable("id") Integer id) throws IllegalAccessException, InvocationTargetException {
		Product product = proRepo.getOne(id);
		if (product!=null) {
			CartItem item = new CartItem();
			BeanUtils.copyProperties(product, item);
			item.setAvailable(1);
			cartService.add(item);
		}
		return "redirect:/admin/cart/list";
	}

}
