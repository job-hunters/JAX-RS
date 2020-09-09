package com.demo.comment;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

public class CommentController {

	CommentService commentService = new CommentService();

	@Path("")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getComments(@PathParam("messageId") long messageId) {
		return Response.ok(commentService.getComments(messageId)).build();
	}

	@Path("")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addComments(Comment comment, @PathParam("messageId") long messageId, @Context UriInfo uriInfo) {
		Comment newComment = commentService.addComment(messageId,comment);
		return Response.created(uriInfo.getAbsolutePathBuilder()
									   .path(Long.toString(newComment.getId()))
									   .build())
					   .entity(newComment)
					   .build();
	}
	
	
}
