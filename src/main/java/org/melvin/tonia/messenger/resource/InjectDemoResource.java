package org.melvin.tonia.messenger.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectDemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	
	@GET
	@Path("annotaions")
	public String getAnnotaions(@MatrixParam("questNo") int questNo, @HeaderParam("SessionId") String sessionId){
		
		return "QuestionNumber "+ questNo +" and session id is " +sessionId;
	}
	
	@GET
	@Path("context")
	public String getContextTest(@Context UriInfo uriInfo , @Context HttpHeaders header){
		
		return "The URL is " +uriInfo.getAbsolutePath().toString() +"  header is "+header;
	}

}
