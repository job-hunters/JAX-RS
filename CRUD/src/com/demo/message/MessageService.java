package com.demo.message;

import java.util.List;
import java.util.Optional;

import com.demo.dao.DatabaseClass;

import jakarta.ws.rs.NotFoundException;

public class MessageService {

	public List<Message> getMessages() {
		return DatabaseClass.getMessages();
	}

	public Message getMessageById(long messageId) {

		return DatabaseClass.getMessages()
				.stream()
				.filter(message -> message.getId() == messageId).findFirst()
				.orElseThrow(NotFoundException::new);
	}

	public Message addMessage(Message message) {
		Message newMessage = new Message(message.getMessage(), message.getOwner());
		DatabaseClass.getMessages().add(newMessage);
		return newMessage;
	}

	public void deleteMessage(long id) {
		DatabaseClass.getMessages()
				.stream()
				.filter(message -> message.getId() == id)
				.findFirst()
				.map(msg -> DatabaseClass.getMessages().remove(msg))
				.orElseThrow(NotFoundException::new);
	}
	

	/**
	 * Replace if already exists else create a new one
	 * @param message
	 * @return
	 */
	public Message replaceOrCreateMessage(Message message) {
		 return  DatabaseClass.getMessages()
				.stream()
				.filter(msg -> msg.getId() == message.getId())
				.findFirst()
				.map(msg -> {
					msg.setMessage(message.getMessage());
					msg.setOwner(message.getOwner());
					msg.comments().clear();
					return msg;
				})
				.or(() -> Optional.of(addMessage(message)))
				.get();
		 
	}

	/**
	 * Model class based resource update
	 * @param updates
	 * @return
	 */
	public Message updateMessage(long messageId, Message updates) {
		 return  DatabaseClass.getMessages()
					.stream()
					.filter(msg -> msg.getId() == messageId)
					.findFirst()
					.map(msg -> {
						if(updates.getMessage() != null) {
							msg.setMessage(updates.getMessage());
						}if(updates.getOwner() != null) {
							msg.setOwner(updates.getOwner());
						}
						return msg;
					})
					.orElseThrow(NotFoundException::new);
	}

}
