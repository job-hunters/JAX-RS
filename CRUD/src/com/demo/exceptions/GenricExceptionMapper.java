package com.demo.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GenricExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exp) {
		return Response
				.serverError()
				.entity(new ErrorMessage(exp.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode()))
				.build();
	}

}
