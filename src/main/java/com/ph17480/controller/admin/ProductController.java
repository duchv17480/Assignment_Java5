package com.ph17480.controller.admin;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.naming.Binding;
import javax.persistence.Column;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ph17480.dto.ProductDTO;
import com.ph17480.entity.Category;
import com.ph17480.entity.Product;
import com.ph17480.mappers.ProductMapper;
import com.ph17480.repositories.CategoryRepository;
import com.ph17480.repositories.ProductRepositories;
import com.ph17480.utils.uploadFileUtils;

@Controller
@RequestMapping("admin/products")
public class ProductController {

	@Autowired
	private ProductRepositories proRepo;

	@Autowired
	private CategoryRepository cateRepo;

	@Autowired
	private ProductMapper proMapper;

	@Autowired
	private uploadFileUtils uploadUtils;
	
	@Autowired
	private HttpServletRequest request;

	@GetMapping
	public String index(Model model) {
		List<Product> litsPro = this.proRepo.findAll();
		model.addAttribute("listPro", litsPro);
		model.addAttribute("view", "/views/admin/products/index.jsp");
		return "trangChu";
	}

	@GetMapping("/create")
	public String create(Model model, @ModelAttribute("product") ProductDTO proDTO) {
		List<Category> listCate = this.cateRepo.findAll();
		model.addAttribute("listCate", listCate);
		System.out.println(listCate + "----------------");
		model.addAttribute("view", "/views/admin/products/create.jsp");
		return "trangChu";
	}

	@PostMapping("/store")
	public String store(@Valid @ModelAttribute("product") ProductDTO proDTO,
			BindingResult result, Model model,
			@RequestParam("image") MultipartFile uploadFile
			) {
		if (result.hasErrors()) {
			List<Category> listCate = this.cateRepo.findAll();
			model.addAttribute("listCate", listCate);
			model.addAttribute("view","/views/admin/products/create.jsp");
			return "trangChu";
		}
		String image = request.getParameter("image");
		Product entity = proMapper.convertToEntity(proDTO);
		Category category = new Category();
		category.setId(proDTO.getCategory());
		entity.setCategory(category);
		entity.setImage(image);
		this.uploadUtils.handleUploadFile(uploadFile);
		this.proRepo.save(entity);
		return "redirect:/admin/products";
	}
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id")Integer id) {
		this.proRepo.deleteById(id);
		return "redirect:/admin/products";
	}
}
