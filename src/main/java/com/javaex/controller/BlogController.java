package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVO;
import com.javaex.vo.UserVO;

@Controller
public class BlogController {
	@Autowired
	BlogService service;
	@Autowired
	UserVO userVO;
	@Autowired
	BlogVO blogVO;
	
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String blogMain(@PathVariable("id") String id, Model model) {
		System.out.println("BlogController.blogMain");
		System.out.println(id);
		//model.addAttribute("model", )
		return "blog/blog-main";
	}
	
}