package com.ohana0.spring.ex.jstl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jstl")
public class JSTLController {
	@GetMapping("/ex01")
	public String ex01() {
		return "jstl/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		List<String> fruitList = new ArrayList<>();
		fruitList.add("사과");
		fruitList.add("딸기");
		fruitList.add("포도");
		fruitList.add("배");
		
		model.addAttribute("fruitList", fruitList);
		
		return "jstl/ex02";
	}
	@GetMapping("/ex04")
	public String ex03(Model model) {
		
		return "jstl/ex04";
	}
}
