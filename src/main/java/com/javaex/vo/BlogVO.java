package com.javaex.vo;

public class BlogVO {
	private String id, blogTitle, blogFile;
	
	public BlogVO() {
		super();
	}

	public BlogVO(String id, String blogTitle, String blogFile) {
		super();
		this.id = id;
		this.blogTitle = blogTitle;
		this.blogFile = blogFile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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