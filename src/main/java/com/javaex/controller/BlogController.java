package com.javaex.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVO;

@Controller
public class BlogController {
	@Autowired
	BlogService service;
	
	
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String blogMain(Model model, @PathVariable("id") String id) {
		Map<String, Object> list = new HashMap<>();
		list = service.getMainList(id);
		System.out.println("list" + list);
		model.addAttribute("list", list);
		return "blog/blog-main";
	}
	
	@RequestMapping(value = "/{id}/admin/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public String myBlogAdmin(Model model, @PathVariable("id") String id) {
		BlogVO vo = service.getBlog(id);
		model.addAttribute("myBlog", vo);
		return "blog/admin/blog-admin-basic";
	}
	
	@RequestMapping(value = "/{id}/admin/basicContent")
	public String basicAdminContent(@PathVariable("id") String id, @ModelAttribute BlogVO vo,
								@RequestParam("file") MultipartFile file) {
		
		System.out.println("BlogController.basicAdminContent");
		System.out.println(vo);
		System.out.println(file);
		if(service.basicUpdate(vo, file)>0) {
			System.out.println("Update 성공");
		}
		return "redirect:/{id}/admin/basic";
	}
	
	@RequestMapping(value = "/{id}/admin/category")
	public String myBlogAdminCategory() {
		System.out.println("BlogController.myBlogAdminCategory");
		return "blog/admin/blog-admin-cate";
	}
	
	@RequestMapping(value = "/{id}/admin/writeForm")
	public String myBlogAdminWrite() {
		System.out.println("BlogController.myBlogAdminWrite");
		return "blog/admin/blog-admin-write";
	}
	
}