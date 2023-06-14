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
}