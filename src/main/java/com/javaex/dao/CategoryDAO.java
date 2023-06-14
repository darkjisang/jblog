package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVO;

@Repository
public class CategoryDAO {
	private SqlSession sqlsession;
	
	public List<CategoryVO> getMainList(CategoryVO vo) {
		 List<CategoryVO>list = sqlsession.selectList("category.getMainList", vo);
		 return list;
	}
}
