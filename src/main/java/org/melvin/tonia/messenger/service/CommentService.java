package org.melvin.tonia.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.melvin.tonia.messenger.database.DataBaseClass;
import org.melvin.tonia.messenger.model.Comment;
import org.melvin.tonia.messenger.model.ErrorMessage;
import org.melvin.tonia.messenger.model.Message;

public class CommentService {

	private Map<Long, Message> messageMap = DataBaseClass.getMessageMap();
	
	public List<Comment> getAllComments(long messageId){	
		Map<Long, Comment> comments = messageMap.get(messageId).getCommentMap();
		return new ArrayList<Comment>( comments.values());
	}
	public Comment getComment(long messageId, long commentId){
		//this is not really good to write the response logic in server class .please refer line 31 for better creation with subclass of webapplication Exceptio
		ErrorMessage mes = new ErrorMessage(Status.NOT_FOUND.toString(),"Not Found....","Http://not Found");
		Response response = Response.status(Status.NOT_FOUND).entity(mes).build();
		if(messageMap.get(messageId) == null){
			throw new WebApplicationException(response);
		}
		Map<Long, Comment> comments = messageMap.get(messageId).getCommentMap();
		if(comments.get(commentId)==null){
			
			throw new NotFoundException();
		}
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment){
		Map<Long, Comment> comments = messageMap.get(messageId).getCommentMap();
		comment.setId(comments.size()+1);
		System.out.print("comments map size"+ comments.size());
		comments.put(comment.getId(), comment);
		messageMap.get(messageId).setCommentMap(comments);
		return comment;		
	}
	public Comment updateComment(long messageId, Comment comment){
		Map<Long, Comment> comments = messageMap.get(messageId).getCommentMap();
		if(comment.getId()==0){			
			return null;
		}
		comments.put(comment.getId(), comment);
		messageMap.get(messageId).setCommentMap(comments);
		return comment;
	}
	public void deleteComment(long messageId, long commentId){
		Map<Long, Comment> comments = messageMap.get(messageId).getCommentMap();
		comments.remove(commentId);
		messageMap.get(messageId).setCommentMap(comments);
	}
}
