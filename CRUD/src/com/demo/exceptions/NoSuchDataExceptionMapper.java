package com.demo.exceptions;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NoSuchDataExceptionMapper implements ExceptionMapper<NotFoundException> {

	@Override
	public Response toResponse(NotFoundException exp) {
		return Response.status(Status.NOT_FOUND.getStatusCode())
						.entity(new ErrorMessage(exp.getMessage(), Status.NOT_FOUND.getStatusCode()))
						.build();
	}
}
