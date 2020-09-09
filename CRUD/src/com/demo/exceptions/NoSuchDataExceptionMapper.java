package com.demo.exceptions;

import java.util.NoSuchElementException;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NoSuchDataExceptionMapper implements ExceptionMapper<NoSuchElementException> {

	@Override
	public Response toResponse(NoSuchElementException exp) {
		return Response.status(Status.NOT_FOUND.getStatusCode())
						.entity(new ErrorMessage(exp.getMessage(), Status.NOT_FOUND.getStatusCode()))
						.build();
	}
}
