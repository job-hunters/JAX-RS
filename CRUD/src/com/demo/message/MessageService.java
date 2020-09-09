package com.demo.message;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.demo.dao.DatabaseClass;

public class MessageService {

	public List<Message> getMessages() {
		return DatabaseClass.getMessages();
	}

	public Message getMessageById(long messageId) {

		return DatabaseClass.getMessages().stream().filter(message -> message.getId() == messageId).findFirst()
				.orElseThrow(() -> new NoSuchElementException ("No Data Found"));
	}

	public Message addMessage(Message message) {
		Message newMessage = new Message(message.getMessage(), message.getOwner());
		DatabaseClass.getMessages().add(newMessage);
		return newMessage;
	}

	public void deleteMessage(long id) {
		Optional<Message> msgOptional = DatabaseClass.getMessages()
				.stream()
				.filter(message -> message.getId() == id)
				.findFirst();
		
		msgOptional.map(name ->DatabaseClass.getMessages().remove(msgOptional.get()))
				   .orElseThrow();
	}

}
