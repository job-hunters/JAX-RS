package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.demo.message.Message;

public class DatabaseClass {

	private static final List<Message> messages = new ArrayList<Message>();
	private static long id = 0;
	static {
		messages.add(new Message("Hello", "Shafi"));
		messages.add(new Message("Hi", "Sanjay"));
		messages.add(new Message("How r u?", "Raj"));
	}

	public static List<Message> getMessages() {
		return messages;
	}

	public static long getNewId() {
		return (++id);
	}

}
