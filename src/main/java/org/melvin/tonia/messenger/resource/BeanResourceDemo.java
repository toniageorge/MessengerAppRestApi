package org.melvin.tonia.messenger.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.melvin.tonia.messenger.model.Message;
import org.melvin.tonia.messenger.service.MessageService;

@Path("/messageBeansDemo")
public class BeanResourceDemo {
	MessageService mservice = new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam MessageBean messageBean){
		if(messageBean.getYear() >0 ){
			
			return mservice.getMessageFiltered(messageBean.getYear());
		}
		if(messageBean.getStart()>=0 && messageBean.getSize() >=0){
			
			return mservice.getMessagePaginated(messageBean.getStart(), messageBean.getSize());
		}
		return mservice.getAllMessages();
		
	}
}

