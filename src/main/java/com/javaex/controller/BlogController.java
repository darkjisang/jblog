package com.javaex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.vo.BlogVO;
import com.javaex.vo.CategoryVO;
import com.javaex.vo.JsonResult;

@Controller
public class BlogController {
	@Autowired
	BlogService service;
	@Autowired
	CategoryService cateService;
	
	private Map<String, Object> list = new HashMap<String, Object>();
	
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String blogMain(Model model, @PathVariable("id") String id) {
		list = service.getMainList(id);
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
		if(service.basicUpdate(vo, file)>0) {
			System.out.println("Update 성공");
		}
		return "redirect:/{id}/admin/basic";
	}
	
	@RequestMapping(value = "/{id}/admin/category", method = {RequestMethod.GET, RequestMethod.POST})
	public String myBlogAdminCategory(Model model, @PathVariable("id") String id) {
		BlogVO vo = service.getBlog(id);
		model.addAttribute("myBlog", vo);
//		list = service.getCateAdmin(id);
//		model.addAttribute("list", list);
		return "blog/admin/blog-admin-cate";
	}	
	
	@ResponseBody
	@RequestMapping(value = "/categoryList", method = {RequestMethod.GET, RequestMethod.POST})
	public JsonResult myBlogAdminCategory(@RequestParam("id") String id) {
		List<CategoryVO> getCateList = cateService.getAdminCatelist(id);
		JsonResult js = new JsonResult();
		//System.out.println("getCateList: " + getCateList);
		js.success(getCateList);
		return js;
	}
	
	@ResponseBody
	@RequestMapping(value = "/categoryInsert", method = {RequestMethod.GET, RequestMethod.POST})
	public JsonResult insertCategory(@RequestBody CategoryVO data) {
		CategoryVO cateVO = cateService.categoryInsert(data);
		JsonResult js = new JsonResult();
		js.success(cateVO);
		return js;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteCategory", method = {RequestMethod.GET, RequestMethod.POST})
	public JsonResult deleteCategory(@RequestBody  CategoryVO data) {
	    System.out.println("BlogController.deleteCategory");
	    JsonResult js = new JsonResult();
	    System.out.println(data);
	    int cnt = data.getCateNo();
   		cateService.deleteCategory(cnt);
	    js.success(cnt);
	    return js;
	}
	
	@RequestMapping(value = "/{id}/admin/writeForm")
	public String myBlogAdminWrite() {
		System.out.println("BlogController.myBlogAdminWrite");
		return "blog/admin/blog-admin-write";
	}
	
}