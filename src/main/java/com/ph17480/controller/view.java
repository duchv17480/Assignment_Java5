package com.ph17480.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ph17480.entity.Product;
import com.ph17480.repositories.ProductRepositories;

@Controller
public class view {
	
	@Autowired
	private ProductRepositories proRepo;
	
	@RequestMapping("/trangchu")
	public String trangChu(Model model) {
		List<Product> listpro= this.proRepo.findAll();
		model.addAttribute("listpro", listpro);
		model.addAttribute("view", "/views/viewproduct.jsp");
		return "trangChu";
	}

}
