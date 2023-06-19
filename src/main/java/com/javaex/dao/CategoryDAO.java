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
	
	public List<CategoryVO> getCategoryList(String id) {
		return sqlsession.selectList("category.getCategoryList", id);
	}
	
	public List<CategoryVO> getAdminCatelist(String id) {
		 return sqlsession.selectList("category.getAdminCateList", id);
	}
	
	public int categoryInsert(CategoryVO vo) {
		sqlsession.insert("category.categoryInsert", vo);
		return vo.getCateNo();
	}
	
	public CategoryVO getCategory(int cateNo) {
		return sqlsession.selectOne("category.getCategory", cateNo);
	}
	
	public int deleteCategory(int cateNo) {
		return sqlsession.delete("category.deleteCategory", cateNo);
	}
}
