package com.demo.message;

import java.util.Date;

import com.demo.dao.DatabaseClass;

public class Message {

	private long id;
	private String message;
	private String owner;
	private Date created;

	//required for the Message Body Object Mapping 
	public Message() {}
	
	public Message(String message, String owner) {
		super();
		this.id = DatabaseClass.getNewId();
		this.message = message;
		this.owner = owner;
		this.created = new Date();
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
		//TODO Date Format
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public boolean equals(Object obj) {
		Message msg = (Message) obj;
		return msg.getId() == this.getId();
	}
}
