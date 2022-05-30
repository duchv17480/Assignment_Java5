package com.ph17480.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {
	@GetMapping
	public String index(Model model) {
		model.addAttribute("view","/views/admin/categories/index.jsp");
		return "trangChu";
	}
}
