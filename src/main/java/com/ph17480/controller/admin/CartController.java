package com.ph17480.controller.admin;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("cartItems",cartItem);
		model.addAttribute("total",cartService.getAmount());
		model.addAttribute("NoOfItem",cartService.getCount());
		model.addAttribute("view","/views/admin/carts/list.jsp");
		return "trangChu";
	}
	@GetMapping("/add/{id}")
	public String add (@PathVariable("id") Integer id) throws IllegalAccessException, InvocationTargetException {
		Product product = proRepo.getOne(id);
		if (product!=null) {
			CartItem item = new CartItem();
			item.setId(product.getId());
			item.setName(product.getName());
			item.setPrice(product.getPrice());
			item.setImage(product.getImage());
			item.setAvailable(1);
			cartService.add(item);
		}
		return "redirect:/admin/cart/list";
	}
	@GetMapping("remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		cartService.remove(id);
		return "redirect:/admin/cart/list";
	}
	@PostMapping("update")
	public String update(@RequestParam("id") Integer id ,@RequestParam("quantity") Integer available) {
		cartService.update(id, available);
		return "redirect:/admin/cart/list";
		
	}

}
