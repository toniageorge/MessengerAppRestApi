package org.melvin.tonia.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.melvin.tonia.messenger.model.ErrorMessage;
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exp) {
	
	ErrorMessage errorMessage = new ErrorMessage(Status.NOT_FOUND.toString(), exp.getMessage(),"http://DatanotFound")	;
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
