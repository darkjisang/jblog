package com.javaex.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDAO;
import com.javaex.dao.CategoryDAO;
import com.javaex.dao.PostDAO;

@Service
public class BlogService {
	@Autowired
	private BlogDAO blogdao;
	@Autowired
	private CategoryDAO catedao;
	@Autowired
	private PostDAO postdao;
	
	public Map<String, Object>getMainList(String id){
		System.out.println("BlogService.getMainList");
		Map<String, Object> list = new HashMap<>();
		list.put("blog", blogdao.getBlog(id));
		list.put("category", catedao.getCategory(id));
		list.put("category", postdao.getPostList(id));
		return list;
	}
	
}