package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVO;

@Repository
public class CategoryDAO {
	@Autowired
	private SqlSession sqlsession;
	
	public List<CategoryVO> getCategory(String id) {
		 List<CategoryVO>list = sqlsession.selectList("category.getCategoryList", id);
		 return list;
	}
}
