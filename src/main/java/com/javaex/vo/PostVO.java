package com.javaex.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class PostVO {
	private int postNo, cateNo;
	private String postTilte, postContent;
	private Date regDate;
	
	public PostVO() {
		super();
	}

	public PostVO(int postNo, int cateNo, String postTilte, String postContent, Date regDate) {
		super();
		this.postNo = postNo;
		this.cateNo = cateNo;
		this.postTilte = postTilte;
		this.postContent = postContent;
		this.regDate = regDate;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public String getPostTilte() {
		return postTilte;
	}

	public void setPostTilte(String postTilte) {
		this.postTilte = postTilte;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "PostVO [postNo=" + postNo + ", cateNo=" + cateNo + ", postTilte=" + postTilte + ", postContent="
				+ postContent + ", regDate=" + regDate + "]";
	}
}