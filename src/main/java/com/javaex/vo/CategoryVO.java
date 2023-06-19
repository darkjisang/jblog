package com.javaex.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class CategoryVO {
	private int cateNo, postCnt, cateCnt;
	private String id, cateName, description;
	private Date regDate;
	
	public CategoryVO() {
		super();
	}
	
	public CategoryVO(int cateNo, int postCnt, int cateCnt, String id, String cateName, String description,
			Date regDate) {
		super();
		this.cateNo = cateNo;
		this.postCnt = postCnt;
		this.cateCnt = cateCnt;
		this.id = id;
		this.cateName = cateName;
		this.description = description;
		this.regDate = regDate;
	}

	public int getCateCnt() {
		return cateCnt;
	}

	public void setCateCnt(int cateCnt) {
		this.cateCnt = cateCnt;
	}

	public int getPostCnt() {
		return postCnt;
	}

	public void setPostCnt(int postCnt) {
		this.postCnt = postCnt;
	}

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "CategoryVO [cateNo=" + cateNo + ", postCnt=" + postCnt + ", cateCnt=" + cateCnt + ", id=" + id
				+ ", cateName=" + cateName + ", description=" + description + ", regDate=" + regDate + "]";
	}
}