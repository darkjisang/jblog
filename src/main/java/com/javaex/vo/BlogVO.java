package com.javaex.vo;

import org.springframework.stereotype.Component;

@Component
public class BlogVO {
	private int id;
	private String blogTitle, blogFile;
	
	public BlogVO() {
		super();
	}

	public BlogVO(int id, String blogTitle, String blogFile) {
		super();
		this.id = id;
		this.blogTitle = blogTitle;
		this.blogFile = blogFile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogFile() {
		return blogFile;
	}

	public void setBlogFile(String blogFile) {
		this.blogFile = blogFile;
	}

	@Override
	public String toString() {
		return "BlogVO [id=" + id + ", blogTitle=" + blogTitle + ", blogFile=" + blogFile + "]";
	}
}