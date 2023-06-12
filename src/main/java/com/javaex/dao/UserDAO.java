package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVO;

@Repository
public class UserDAO {
	@Autowired
	private SqlSession sqlsession;
	
	public void userInsert(UserVO vo) {
		System.out.println("UserDAO.userInsert");
		System.out.println(vo);
	}
}