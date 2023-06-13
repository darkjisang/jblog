package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDAO;
import com.javaex.vo.UserVO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;
	
	public int userInsert(UserVO vo) {
		if (dao.userInsert(vo) == 1 && dao.blogInsert(vo) == 1 && dao.categoryInsert(vo) == 1) {
	        return 1;
	    } else {
	        return 0;
	    }
	}
	
	public boolean getIdCheck(String id) {
		boolean bl = true;
		if(dao.getIdCheck(id) == null) {
			bl = false;
		}
		return bl;
	}
}