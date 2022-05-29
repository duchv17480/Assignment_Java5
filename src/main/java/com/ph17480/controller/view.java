package com.ph17480.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class view {
	@RequestMapping("/trangchu")
	public String trangChu(Model model) {
		model.addAttribute("view", "/views/admin/accounts/index.jsp");
		return "trangChu";
	}

}
