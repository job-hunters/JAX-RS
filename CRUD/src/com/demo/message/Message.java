package com.demo.message;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.demo.comment.Comment;
import com.demo.dao.DatabaseClass;
import com.demo.hateoas.Link;

import jakarta.xml.bind.annotation.XmlTransient;

public class Message {

	private long id;
	private String message;
	private String owner;
	private Date created;
	private List<Comment> comments;
	private Set<Link> links;

	public Message() {}

	public Message(String message, String owner) {
		super();
		this.id = DatabaseClass.getNewId();
		this.message = message;
		this.owner = owner;
		this.created = new Date();
		this.comments = new ArrayList<Comment>();
		this.links = new HashSet<Link>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
	//exclude comments by renaming the getter
	//XmlTransient doesn't work
	@XmlTransient
	public List<Comment> comments() {
		return comments;
	}

	public void addComment(Comment comment) {
		this.comments.add(comment);
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Set<Link> getLinks() {
		return links;
	}

	public void addLink(String rel, String link) {
		this.links.add(new Link(rel, link));
	}

}
