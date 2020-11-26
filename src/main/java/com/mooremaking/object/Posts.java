package com.mooremaking.object;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="blogpost")
public class Posts {
	
	@Id
	@Column(name="post_id")
	private long postID;
	
	@Column(name="post_dategory")
	private String postCategory;
	
	@Column(name="post_title")
	private String postTitle;
	
	@Column(name="post")
	private String post;
	
	@Column(name="post_image_url")
	private String postImageURL;
	
	@Column(name="post_date")
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
