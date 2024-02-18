package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.student;
import com.example.demo.service.appService;

import ch.qos.logback.core.model.Model;

@Controller
public class appController {
	
	@Autowired
	private appService service;
	
	@GetMapping("/")
	public String form() {
		return "form";
	}
	
	@PostMapping("/save")
	public String save(@RequestParam("name")String name,@RequestParam("address")String address) {
		service.saves(name, address);
		return "success";
	}
	
	@GetMapping("/list")
	public String list(org.springframework.ui.Model model) {
		List<student>list=service.list();
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("/update")
	public String update(org.springframework.ui.Model model ,@RequestParam("id")int id) {
		 Optional<student> li= service.update(id);
		 model.addAttribute("list", li);
		return "update_form";
	}
	@PostMapping("/update_save")
	public String update_save(@RequestParam("id")int id ,@RequestParam("name")String name,@RequestParam("address")String address) {
		service.update_save(id, name, address);
		return "update_success";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id")int id) {
		service.delete(id);
		return "delete_successful";
	}
	@GetMapping("/search")
	public String search(org.springframework.ui.Model model,@RequestParam("search")int id) {
		student s= service.search(id);
		model.addAttribute("search",s );
		return "search";
	}

}
