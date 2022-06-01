package com.ph17480.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ph17480.dto.AccountDTO;
import com.ph17480.entity.Account;
import com.ph17480.mappers.AccountMapper;
import com.ph17480.repositories.AccountRepository;
import com.ph17480.utils.HashUtil;

@Controller
@RequestMapping("/admin/accounts")
public class AccountController {
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private AccountMapper accountMapper;
	
	@GetMapping()
	public String index(Model model) {
		String sortBy = request.getParameter("sort_by");
		String sortDirection = request.getParameter("sort_direction");
		String pageParam = request.getParameter("page");
		String limitParam = request.getParameter("limit");

		String sortField = sortBy == null ? "id" : sortBy;
		Sort sort = (sortDirection == null || sortDirection.equals("asc")) ? Sort.by(Direction.ASC, sortField)
				: Sort.by(Direction.DESC, sortField);

		int page = pageParam == null ? 0 : Integer.parseInt(pageParam);
		int limit = limitParam == null ? 4 : Integer.parseInt(limitParam);
		Pageable pageable = PageRequest.of(page, limit, sort);
		
		String timKiem = request.getParameter("timKiem");
		List<Account> ds = this.accountRepo.findByUserNameLike("timKiem");
		
		Page pageData = this.accountRepo.findAll(pageable);

		model.addAttribute("pageData", pageData);
		model.addAttribute("view","/views/admin/accounts/index.jsp");
		return "trangChu";
	}
	@GetMapping(value = "{id}")
	public String show(Model model, @PathVariable("id") Account entity) {

		AccountDTO userDTO = this.accountMapper.convertToDTO(entity);
		model.addAttribute("user", userDTO);
		model.addAttribute("view","/views/admin/accounts/show.jsp");
		return "trangChu";
	}
	@GetMapping(value = "/create")
	public String create(@ModelAttribute("account") AccountDTO user,Model model) {
		model.addAttribute("view","/views/admin/accounts/create.jsp");
		return "trangChu";
	}

	@PostMapping(value = "/store")
	public String store(Model model, @Valid @ModelAttribute("account") AccountDTO account, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("view","/views/admin/accounts/create.jsp");
			return "trangChu";
		} else {
			Account entity = this.accountMapper.convertToEntity(account);
			String hashedPw = HashUtil.hash(entity.getPassword());
			entity.setPassword(hashedPw);
			this.accountRepo.save(entity);
			return "redirect:/admin/accounts";
		}
	}

	@GetMapping(value = "/edit/{id}")
	public String edit(Model model, @PathVariable("id") Account entity) {
		AccountDTO account = this.accountMapper.convertToDTO(entity);
		model.addAttribute("account", entity);
		model.addAttribute("view","/views/admin/accounts/edit.jsp");
		return "trangChu";
	}

	@PostMapping(value = "/update/{id}")
	public String update(Model model, @Valid @ModelAttribute("account") AccountDTO account, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("có lỗi");
			model.addAttribute("view","/views/admin/accounts/edit.jsp");
			return "trangChu";
		} else {
			System.out.println("k loi");
			Account entity = this.accountMapper.convertToEntity(account);
			this.accountRepo.save(entity);
			return "redirect:/admin/accounts";
		}
	}

	@PostMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		this.accountRepo.deleteById(id);
		return "redirect:/admin/accounts";
	}

}

