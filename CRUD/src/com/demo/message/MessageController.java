package com.demo.message;

import java.util.stream.Collectors;

import com.demo.comment.CommentController;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

//TODO Multiple Data Format
//TODO Sub resource
//TODO Comments
@Path("messages")
public class MessageController {

	MessageService messageService = new MessageService();

	@Path("")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessages(@Context UriInfo uriInfo) {
		return Response.ok(messageService.getMessages().stream().map( message -> this.getHateoas(message, uriInfo)).collect(Collectors.toList())).build();
	}

	@Path("{messageId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo) {
		Message msg = messageService.getMessageById(messageId);
		getHateoas(msg, uriInfo);
		return Response.ok(msg).build();
	}

	@Path("")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		Message newMessage = messageService.addMessage(message);
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		uriBuilder.path(Long.toString(newMessage.getId()));
		return Response.created(uriBuilder.build()).entity(newMessage).build();
	}

	@Path("{messageId}")
	@DELETE
	public Response deleteMessage(@PathParam("messageId") long messageId) {
		messageService.deleteMessage(messageId);
		return Response.noContent().build();
	}
	
	@Path("{messageId}/comments")
	public CommentController getCommentController() {
		return new CommentController();
	}

	private Message getHateoas(Message message, UriInfo uriInfo) {
		UriBuilder builder = uriInfo.getBaseUriBuilder().path(this.getClass()).path(Long.toString(message.getId()));
		message.addLink("self", builder.build().toString());
		message.addLink("comments", builder.path("comments").build().toString());
		return message;
	}
	
}
