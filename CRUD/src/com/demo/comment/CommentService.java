package com.demo.comment;

import java.util.List;

import com.demo.message.Message;
import com.demo.message.MessageService;

public class CommentService {

	MessageService messageService = new MessageService();
	
	public List<Comment> getComments(long messageId) {
		return messageService.getMessageById(messageId).comments();
	}

	public Comment addComment(long messageId, Comment comment) {
		Message message = messageService.getMessageById(messageId);
		Comment newComment =  new Comment(comment.getComment(), comment.getOwner());
		message.addComment(newComment);
		return newComment;
	}

}
