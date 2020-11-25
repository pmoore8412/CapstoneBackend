package com.mooremaking.object;


import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Table(name="blogpost")
public class Posts {
	
	@Id
	private long postID;
	private String postCategory;
	private String postTitle;
	private String post;
	private String postImageURL;
	private String postDate;
	
	public long getPostID() {
		return postID;
	}
	
	public void setPostID(long postID) {
		this.postID = postID;
	}
	
	public String getPostCategory() {
		return postCategory;
	}
	
	public void setPostCategory(String postCategory) {
		this.postCategory = postCategory;
	}
	
	public String getPostTitle() {
		return postTitle;
	}
	
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	
	public String getPost() {
		return post;
	}
	
	public void setPost(String post) {
		this.post = post;
	}
	
	public String getPostImageURL() {
		return postImageURL;
	}
	
	public void setPostImageURL(String postImageURL) {
		this.postImageURL = postImageURL;
	}
	
	public String getPostDate() {
		return postDate;
	}
	
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

}
