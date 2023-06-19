package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVO;

@Repository
public class BlogDAO {
	@Autowired
	private SqlSession sqlsession;
	
	public BlogVO getBlog(String id) {
		return sqlsession.selectOne("blog.getBlog", id);
	}
	
	public int basicUpdate(BlogVO vo) {
		return sqlsession.update("blog.basicUpdate", vo);
	}
	
}