package com.ph17480.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ph17480.entity.Account;
import com.ph17480.entity.Order;
import com.ph17480.repositories.AccountRepository;
import com.ph17480.repositories.OrderRepositories;

@Controller
@RequestMapping("admin/orders")
public class OrderController {
	
	@Autowired
	private OrderRepositories orderRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@GetMapping
	public String index (Model model) {
		List<Order> listorder= orderRepo.findAll();
		model.addAttribute("listorder", listorder);
		model.addAttribute("view","/views/admin/orders/index.jsp");
		return "trangChu";
	}
	@GetMapping("/create")
	public String create(@ModelAttribute("order")Order order,Model model) {
		List<Account> listaccount = accountRepo.findAll();
		model.addAttribute("listaccount", listaccount);
		model.addAttribute("view","/views/admin/orders/create.jsp");
		return "trangChu";
		
	}
	

}
