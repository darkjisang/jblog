package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDAO;
import com.javaex.vo.UserVO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;
	public void userInsert(UserVO vo) {
		System.out.println("UserService.userInsert");
		System.out.println(vo);
		dao.userInsert(vo);
	}
}