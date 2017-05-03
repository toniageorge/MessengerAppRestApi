package org.melvin.tonia.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.melvin.tonia.messenger.database.DataBaseClass;
import org.melvin.tonia.messenger.exception.DataNotFoundException;
import org.melvin.tonia.messenger.model.Comment;
import org.melvin.tonia.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messageMap = DataBaseClass.getMessageMap();

	public MessageService() {
		Message m1 = new Message(1,"Hello",new Date(), "Tonia");
		Message m2 = new Message(2,"Hi",new Date(), "MELVIN");
		Comment c1 = new Comment(1,"my first comment",new Date(), "tonia frnd");
		Comment c2 = new Comment(2,"my second comment",new Date(), "mel frnd");
		Map<Long, Comment> commentMap = new HashMap<Long, Comment>();
		Map<Long, Comment> commentMap2 = new HashMap<Long, Comment>();
		commentMap.put(1L, c1);
		commentMap2.put(2L, c2);
		
		m1.setCommentMap(commentMap);
		m2.setCommentMap(commentMap2);
		messageMap.put(1L,m1);
		messageMap.put(2L,m2);
	}

	public List<Message> getAllMessages(){		
		return new ArrayList<Message>( messageMap.values());
	}
	
	public Message getMessage(long Id){	
		if(messageMap.get(Id) == null){
			
			throw(new DataNotFoundException("The Id you are looking is not found"+ Id));
		}
		return messageMap.get(Id);
	}
	
	public List<Message> getMessageFiltered(int year){
		List<Message> messageForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message msg : messageMap.values()){
			cal.setTime(msg.getCreatedDate());
			if(cal.get(Calendar.YEAR)==year){
				messageForYear.add(msg);				
			}
		}
		return messageForYear;
		
	}
	
	public List<Message> getMessagePaginated(int start,int size){
		List<Message> messagepaginated = new ArrayList(messageMap.values());
		if((start+ size) > messagepaginated.size()){
			
			return new ArrayList<Message>();
		}
		return messagepaginated.subList(start, start+size);
		
		
	}
	
	public Message addMessage(Message m){		
		m.setId(messageMap.size()+1);
		System.out.print("messageMap"+ messageMap.size());
		messageMap.put(m.getId(), m);
		return m;		
	}
	public Message updateMessage(Message message){
		if(message.getId()==0){			
			return null;
		}
		messageMap.put(message.getId(), message);
		return message;
	}
	public void deleteMessage(long Id){
		 messageMap.remove(Id);
	}
	
	
}
