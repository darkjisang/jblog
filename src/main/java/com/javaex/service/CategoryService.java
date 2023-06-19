package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDAO;
import com.javaex.vo.CategoryVO;

@Service
public class CategoryService {
	@Autowired
	private CategoryDAO dao;

	// 카테고리 어드민 리스트
	public List<CategoryVO> getAdminCatelist(String id) {
		System.out.println("BlogService.getAdminCatelist");
		return dao.getAdminCatelist(id);
	}
	
	public CategoryVO categoryInsert(CategoryVO vo) {
		int cateNo = dao.categoryInsert(vo);
		System.out.println(vo);
		System.out.println(cateNo);
		return dao.getCategory(cateNo);
	}
	
	public int deleteCategory(int cateNo) {
		return dao.deleteCategory(cateNo); 
	}
}