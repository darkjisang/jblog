package com.javaex.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;

@Controller
public class BlogController {
	@Autowired
	BlogService service;
	
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String blogMain(@PathVariable("id") String id, Model model) {
		System.out.println("BlogController.blogMain");
		System.out.println(id);
		//model.addAttribute("", )
		//model.addAttribute("model", )
		Map<String, Object> list = new HashMap<>();
		list = service.getMainList(id);
		System.out.println("list" + list);
		model.addAttribute("list", list);

		return "blog/blog-main";
	}
	
}