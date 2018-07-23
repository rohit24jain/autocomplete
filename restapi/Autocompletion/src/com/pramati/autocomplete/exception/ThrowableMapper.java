package com.pramati.autocomplete.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ThrowableMapper implements ExceptionMapper<java.lang.Throwable> {

	@Override
	public Response toResponse(Throwable arg0) {
		return Response.status(Status.NOT_FOUND).entity("404 - Not found").type(MediaType.TEXT_PLAIN).build();
	}

	
}
