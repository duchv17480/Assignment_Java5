package com.ph17480.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ph17480.entity.Product;
import com.ph17480.repositories.ProductRepositories;
import com.ph17480.service.CartService;

@Controller
public class view {
	
	@Autowired
	private ProductRepositories proRepo;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping("/trangchu")
	public String index(Model model) {
		String pageParam = request.getParameter("page");
		String limitParam = request.getParameter("limit");


		int page = pageParam == null ? 0 : Integer.parseInt(pageParam);
		int limit = limitParam == null ? 6 : Integer.parseInt(limitParam);
		Pageable pageable = PageRequest.of(page, limit);
		
		Page pageData = this.proRepo.findAll(pageable);

		model.addAttribute("pageData", pageData);
		model.addAttribute("view", "/views/viewproduct.jsp");
		return "trangChu";
	}

}
