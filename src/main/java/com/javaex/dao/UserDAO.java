package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVO;

@Repository
public class UserDAO {
	@Autowired
	private SqlSession sqlsession;
	
	public int userInsert(UserVO vo) {
		return sqlsession.insert("user.userInsert", vo);
	}
	public int blogInsert(UserVO vo) {
		return sqlsession.insert("user.blogInsert", vo);
	}
	public int categoryInsert(UserVO vo) {
		return sqlsession.insert("user.categoryInsert", vo);
	}
	
	public UserVO getIdCheck(String id) {
		return sqlsession.selectOne("user.idCheck", id);
	}
	
	public UserVO getLoginUser(UserVO vo) {
		return sqlsession.selectOne("user.loginUser", vo);
	}
}