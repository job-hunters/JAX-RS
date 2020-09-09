package com.demo.message;

import java.util.List;
import java.util.Optional;

import com.demo.dao.DatabaseClass;

public class MessageService {

	public List<Message> getMessages() {
		return DatabaseClass.getMessages();
	}

	public Message getMessageById(long messageId) {

		return DatabaseClass.getMessages().stream().filter(message -> message.getId() == messageId).findFirst()
				.orElse(null);
	}

	public Message addMessage(Message message) {
		Message newMessage = new Message(message.getMessage(), message.getOwner());
		DatabaseClass.getMessages().add(newMessage);
		return newMessage;
	}

	public void deleteMessage(long id) {
		Optional<Message> msg = DatabaseClass.getMessages()
				.stream()
				.filter(message -> message.getId() == id)
				.findFirst();
		msg.ifPresent(name ->DatabaseClass.getMessages().remove(msg.get()));
	}

}
