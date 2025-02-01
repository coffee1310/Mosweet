package com.mosweet.Mosweet.Mosweet.controllers;

import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Category;
import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.Product;
import com.mosweet.Mosweet.Mosweet.entity.Redis.CategoryRedis;
import com.mosweet.Mosweet.Mosweet.repository.Redis.CategoryRepositoryCrud;
import com.mosweet.Mosweet.Mosweet.service.CategoryService;
import com.mosweet.Mosweet.Mosweet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("/")
public class MainController {
	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

    @GetMapping("/")
	public String mainPage(Model model) {
		model.addAttribute("title", "Mosweet");
		return "index";
	}

	@GetMapping("/category")
	public String categoryPage(Model model) {
		Iterable<Category> categories = categoryService.findAll();
		Iterable<CategoryRedis> categoriesRedis = categoryService.findAllRedis();

		if (!categories.iterator().hasNext()) {
			for (Category category : categories) {
				CategoryRedis categoryRedis = new CategoryRedis();
				categoryRedis.fromCategoryToCategoryRedis(category);
				categoryService.saveRedis(categoryRedis);
			}
			categoriesRedis = categoryService.findAllRedis();
		}

		model.addAttribute("title", "Категории");
		model.addAttribute("categories", categoriesRedis);
		return "category";
	}

	@GetMapping("/category/{slug}")
	public String categoryDetail(@PathVariable(value = "slug") String slug, Model model) {
		Iterable<Product> products = productService.getProductsBySlug(slug);
		String category = categoryService.getCategoryBySlug(slug).getCategory();
		model.addAttribute("products", products);
		model.addAttribute("category", category);
		return "products";
	}

	@GetMapping("/products/{article_number}")
	public String productPage(@PathVariable(value = "article_number") int article_number, Model model) {
		Product product = productService.getProductByArticle_number(article_number);
		model.addAttribute("title", product.getTitle());
		model.addAttribute("product", product);
		return "product";
	}

	@GetMapping("/products")
	public String prodcutsPage(Model model) {
		model.addAttribute("title", "");
		return "products";
	}
}
