package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVO;
import com.javaex.vo.PostVO;

@Repository
public class PostDAO {
	@Autowired
	private SqlSession sqlsession;
	
	public List<PostVO> getPostList(String id){
		List<PostVO> list = sqlsession.selectList("post.getPostList", id);
		return list;
	}

}
