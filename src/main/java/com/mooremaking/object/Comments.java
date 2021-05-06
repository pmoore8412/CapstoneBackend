package com.mooremaking.object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_comments")
public class Comments {

	@Id
	@Column(name="comment_id")
	private long commentID;
	
	@Column(name="related_postid")
	private long relatedPostID;
	
	@Column(name="user_comment")
	private String userComment;
	
	@Column(name="comment_date")
	private String commentDate;
	
	public long getCommentID() {
		return commentID;
	}
	
	public void setCommentID(long commentID) {
		this.commentID = commentID;
	}
	
	public String getUserComment() {
		return userComment;
	}
	
	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}
	
	public String getCommentDate() {
		return commentDate;
	}
	
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public long getRelatedPostID() {
		return relatedPostID;
	}

	public void setRelatedPostID(long relatedPostID) {
		this.relatedPostID = relatedPostID;
	}
	
}
