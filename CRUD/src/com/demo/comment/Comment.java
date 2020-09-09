package com.demo.comment;

import java.util.Date;

import com.demo.dao.DatabaseClass;

public class Comment {

	private long id;
	private String comment;
	private String owner;
	private Date created;

	public Comment() {
		super();
	}

	public Comment(String comment, String owner) {
		super();
		this.id = DatabaseClass.getNewId();
		this.comment = comment;
		this.owner = owner;
		this.created = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
