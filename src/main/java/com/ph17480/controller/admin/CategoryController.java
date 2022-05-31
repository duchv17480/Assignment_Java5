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

import com.ph17480.dto.AccountDTO;
import com.ph17480.dto.CategoryDTO;
import com.ph17480.entity.Account;
import com.ph17480.entity.Category;
import com.ph17480.mappers.cateMapper;
import com.ph17480.repositories.CategoryRepository;
import com.ph17480.utils.HashUtil;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {
	
	@Autowired
	private CategoryRepository cateRepo;
	
	@Autowired
	private cateMapper cateMaper;
	@GetMapping
	public String index(Model model) {
		List<Category> listCate = this.cateRepo.findAll();
		model.addAttribute("listCate", listCate);
		model.addAttribute("view","/views/admin/categories/index.jsp");
		return "trangChu";
	}
	@GetMapping(value = "/create")
	public String create(@ModelAttribute("cate") CategoryDTO cate,Model model) {
		model.addAttribute("view","/views/admin/categories/create.jsp");
		return "trangChu";
	}
	@PostMapping(value = "/store")
	public String store(Model model, @Valid @ModelAttribute("cate") CategoryDTO cateDTO, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("view","/views/admin/categories/create.jsp");
			return "redirect:/admin/categories/create";
		} else {
			Category entity = this.cateMaper.convertToEntity(cateDTO);
			this.cateRepo.save(entity);
			return "redirect:/admin/categories";
		}
	}
	@GetMapping(value = "/edit/{id}")
	public String edit(Model model, @PathVariable("id") Category cate) {
		CategoryDTO entity = this.cateMaper.convertToDTO(cate);
		model.addAttribute("cate", cate);
		model.addAttribute("view","/views/admin/categories/edit.jsp");
		return "trangChu";
	}

	@PostMapping(value = "/update/{id}")
	public String update(Model model, @Valid @ModelAttribute("cate") CategoryDTO cate, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("có lỗi");
			model.addAttribute("view","/views/admin/categories/edit.jsp");
			return "trangChu";
		} else {
			System.out.println("k loi");
			Category entity = this.cateMaper.convertToEntity(cate);
			this.cateRepo.save(entity);
			return "redirect:/admin/categories";
		}
	}

	@PostMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		this.cateRepo.deleteById(id);
		return "redirect:/admin/categories";
	}

}



