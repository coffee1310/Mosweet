package com.mosweet.Mosweet.Mosweet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("/")
public class MainController {
    @GetMapping("/")
	public String mainPage(Model model) {
		model.addAttribute("title", "Mosweet");
		return "index";
	}

	@GetMapping("products/")
	public String prodcutsPage(Model model) {
		model.addAttribute("title", "");
		return "products";
	}
}
