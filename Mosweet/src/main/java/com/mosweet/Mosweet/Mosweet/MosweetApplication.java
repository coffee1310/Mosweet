package com.mosweet.Mosweet.Mosweet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class MosweetApplication {

	public static void main(String[] args) {
		SpringApplication.run(MosweetApplication.class, args);
	}

//	@GetMapping("/")
//	public String mainPage(Model model) {
//		model.addAttribute("title", "Mosweet");
//		return "index";
//	}
//
//	@GetMapping("products/")
//	public String prodcutsPage(Model model) {
//		model.addAttribute("title", "");
//		return "procucts";
//	}
}
