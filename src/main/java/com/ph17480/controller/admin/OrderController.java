package com.ph17480.controller.admin;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ph17480.dto.AccountDTO;
import com.ph17480.dto.CategoryDTO;
import com.ph17480.dto.OrderDTO;
import com.ph17480.dto.OrderDetailDTO;
import com.ph17480.entity.Account;
import com.ph17480.entity.Category;
import com.ph17480.entity.Order;
import com.ph17480.entity.OrderDetail;
import com.ph17480.mappers.OrderDetailMapper;
import com.ph17480.mappers.OrderMapper;
import com.ph17480.repositories.AccountRepository;
import com.ph17480.repositories.OrderDetailRepositories;
import com.ph17480.repositories.OrderRepositories;

@Controller
@RequestMapping("admin/orders")
public class OrderController {
	
	@Autowired
	private OrderRepositories orderRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private OrderDetailRepositories orderDetail;
	
	@Autowired
	private HttpServletRequest request;
	
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
	@GetMapping("/edit/{id}")
	public String edit(Model model , @PathVariable("id") Order order) {
		List<Account> listaccount = accountRepo.findAll();
		model.addAttribute("listaccount", listaccount);
		model.addAttribute("order",order);
		model.addAttribute("view","/views/admin/orders/edit.jsp");
		return "trangChu";
	}
	@PostMapping(value = "/store")
	public String store(Model model, @Valid @ModelAttribute("order") OrderDTO orderDTO, BindingResult result){
		if (result.hasErrors()) {
			List<Account> listaccount = accountRepo.findAll();
			model.addAttribute("listaccount", listaccount);
			model.addAttribute("view","/views/admin/orders/create.jsp");
			return "trangChu";
		} else {
			String getDate = request.getParameter("date");
			Order entity = this.orderMapper.convertToEntity(orderDTO);
			Account account = new Account();
			account.setId(orderDTO.getUser());
			entity.setUser(account);
			entity.setCreateDate(getDate);
			this.orderRepo.save(entity);
			return "redirect:/admin/orders";
		}
	}
	@PostMapping(value = "/update/{id}")
	public String update(Model model, @Valid @ModelAttribute("order") OrderDTO orderDTO, BindingResult result){
		if (result.hasErrors()) {
			List<Account> listaccount = accountRepo.findAll();
			model.addAttribute("listaccount", listaccount);
			model.addAttribute("view","/views/admin/orders/edit.jsp");
			return "trangChu";
		} else {
			String getDate = request.getParameter("createDate");
			Order entity = this.orderMapper.convertToEntity(orderDTO);
			Account account = new Account();
			account.setId(orderDTO.getUser());
			entity.setUser(account);
			entity.setCreateDate(getDate);
			this.orderRepo.save(entity);
			return "redirect:/admin/orders";
		}
	}
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id")Order order) {
		this.orderRepo.delete(order);
		return "redirect:/admin/orders";
	}
	@GetMapping(value = "{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		List<OrderDetail> list =this.orderDetail.findOrder(id);
		System.out.println(list+"hahahahah");
		model.addAttribute("listOrderDetail", list);
		model.addAttribute("view","/views/admin/orderDetails/index.jsp");
		return "trangChu";
	}
	
	

}
