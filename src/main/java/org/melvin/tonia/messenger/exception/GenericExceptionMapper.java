package org.melvin.tonia.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.melvin.tonia.messenger.model.ErrorMessage;

//commenting here the provider annotation as we are going to get practice with webapplication exception
//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exp) {
	
	ErrorMessage errorMessage = new ErrorMessage(Status.INTERNAL_SERVER_ERROR.toString(), exp.getMessage(),"http://serverError")	;
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}

}