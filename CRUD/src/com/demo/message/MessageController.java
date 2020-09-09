package com.demo.message;

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

//TODO Error handling
//TODO Authentication
//TODO Multiple Data Format
@Path("messages")
public class MessageController {

	MessageService messageService = new MessageService();

	@Path("")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessages() {
		return Response.ok(messageService.getMessages()).build();
	}

	@Path("{messageId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessage(@PathParam("messageId") String messageId) {
		return Response.ok(messageService.getMessageById(Long.parseLong(messageId))).build();
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
	public Response deleteMessage(@PathParam("messageId") String messageId) {
		messageService.deleteMessage(Long.parseLong(messageId));
		return Response.noContent().build();
	}

}
