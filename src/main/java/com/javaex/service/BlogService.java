package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDAO;

@Service
public class BlogService {
	@Autowired
	BlogDAO dao;
}