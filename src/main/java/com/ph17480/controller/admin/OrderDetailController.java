package com.ph17480.controller.admin;

import java.util.List;

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

import com.ph17480.dto.OrderDTO;
import com.ph17480.dto.OrderDetailDTO;
import com.ph17480.entity.Order;
import com.ph17480.entity.OrderDetail;
import com.ph17480.entity.Product;
import com.ph17480.mappers.OrderDetailMapper;
import com.ph17480.repositories.OrderDetailRepositories;
import com.ph17480.repositories.OrderRepositories;
import com.ph17480.repositories.ProductRepositories;

@Controller
@RequestMapping("admin/details")
public class OrderDetailController {
	@Autowired
	private OrderDetailRepositories orderDetailRepo;
	
	@Autowired
	private OrderRepositories orderRepo;
	
	@Autowired
	private ProductRepositories proRepo;
	
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	
	
	@GetMapping
	public String index (Model model) {
		List<OrderDetail> listOrderDetail = this.orderDetailRepo.findAll();
		model.addAttribute("listOrderDetail", listOrderDetail);
		model.addAttribute("view","/views/admin/orderDetails/index.jsp");
		return "trangChu";
	}
	@GetMapping("/create")
	public String create(Model model ,@ModelAttribute("orderDetail") OrderDetailDTO detail) {
		List<Product> listProduct = this.proRepo.findAll();
		model.addAttribute("listProduct",listProduct);
		List<Order> listOrder = this.orderRepo.findAll();
		model.addAttribute("listOrder",listOrder);
		model.addAttribute("view","/views/admin/orderDetails/create.jsp");
		return "trangChu";
	}
	@GetMapping("/edit/{id}")
	public String edit(Model model , @PathVariable("id") OrderDetail entity) {
		OrderDetailDTO orderDetail = this.orderDetailMapper.convertToDTO(entity);
		model.addAttribute("orderDetail",orderDetail);
		
		List<Product> listProduct = this.proRepo.findAll();
		model.addAttribute("listProduct",listProduct);
		
		List<Order> listOrder = this.orderRepo.findAll();
		model.addAttribute("listOrder",listOrder);
		
		model.addAttribute("view","/views/admin/orderDetails/edit.jsp");
		return "trangChu";
	}
	@PostMapping("/store")
	public String store(Model model, @Valid @ModelAttribute("orderDetail") OrderDetailDTO detail, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("view","/views/admin/orderDetails/index.jsp");
			return "trangChu";
		}else {
			OrderDetail entity = this.orderDetailMapper.convertToEntity(detail);
			
			Order order = new Order();
			order.setId(detail.getOrder_id());
			Product product = new Product();
			product.setId(detail.getProduct_id());
			
			entity.setOrder(order);
			entity.setProduct(product);
			
			this.orderDetailRepo.save(entity);
			return "redirect:/admin/details";
		}
	}
	
	@PostMapping("delete/{id}")
	public String delete(@PathVariable("id")Integer id) {
		this.orderDetailRepo.deleteById(id);
		return "redirect:/admin/details";
	}

}
