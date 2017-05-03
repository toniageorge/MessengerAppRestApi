package org.melvin.tonia.messenger.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.melvin.tonia.messenger.model.Message;
import org.melvin.tonia.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService mservice = new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam ("year") int year, @QueryParam("start") int start, @QueryParam("size") int size){
		if(year >0 ){
			
			return mservice.getMessageFiltered(year);
		}
		if(start>0 && size >0){
			
			return mservice.getMessagePaginated(start, size);
		}
		return mservice.getAllMessages();
		
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo){
		Message m1 = GetUrlSelfLink(messageId, uriInfo);
		return Response.status(Status.FOUND).entity(m1).build();
		//return mservice.getMessage(messageId);
	}

	private Message GetUrlSelfLink(long messageId, UriInfo uriInfo) {
		Message m1= mservice.getMessage(messageId);
		String uri= uriInfo.getBaseUriBuilder().path(MessageResource.class).path(String.valueOf(m1.getId())).build().toString();
		m1.addLink(uri, "self");
		return m1;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message, @Context UriInfo uriInfo){
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(message.getId())).build();
		return Response.created(uri).entity(mservice.addMessage(message)).build();
		//return mservice.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long messageId, Message message){
		message.setId(messageId);
		return mservice.updateMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	public void  deleteMessage(@PathParam("messageId") long messageId){	
		 mservice.deleteMessage(messageId);
	}
	
	@Path("/{messageId}/comments")
	@Produces(MediaType.APPLICATION_JSON)
	public CommentResources getComments(){	
		return new CommentResources();
	}
}
