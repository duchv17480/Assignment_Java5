package com.ph17480.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ph17480.entity.Account;
import com.ph17480.repositories.AccountRepository;
import com.ph17480.utils.HashUtil;

@Controller
public class loginController {
	@Autowired
	private AccountRepository userRepo;
	@Autowired
	private HttpServletRequest request;
	@GetMapping("/login")
	public String loginGetForm() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
		HttpSession session= request.getSession();
		Account entity=this.userRepo.finByEmail(email);
		if (entity == null) {
			System.out.println("1");
			session.setAttribute("error", "sai email");
			return "redirect:/login";
		}
		boolean checkpw=HashUtil.verify(password, entity.getPassword());
		if (!checkpw) {
			session.setAttribute("error", "sai  password");
			return "redirect:/login";
		}
		session.setAttribute("accounts", entity);
		return "redirect:/admin/accounts";
	}
}
