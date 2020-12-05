package com.mooremaking.object;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="blogpost")
public class Posts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	private Date postDate;
	
	@Column(name="day")
	private int day;
	
	@Column(name="month")
	private int month;
	
	@Column(name="year")
	private int year;
	
	@Column(name="featured")
	private boolean featured;
	
	@Column(name="sub_featured")
	private boolean subFeatured;
	
	public boolean isSubFeatured() {
		return subFeatured;
	}

	public void setSubFeatured(boolean subFeatured) {
		this.subFeatured = subFeatured;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

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
	
	public Date getPostDate() {
		return postDate;
	}
	
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

}
