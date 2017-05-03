package org.melvin.tonia.messenger.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {

	private long id;
	private String message;
	private Date createdDate;
	private String author;
	private Map<Long, Comment> commentMap = new HashMap<Long, Comment>();
	private List<Link> links = new ArrayList<Link>();
	public Message() {
		
	}
	
	
	public Message(long id, String message, Date createdDate, String author) {
		this.id = id;
		this.message = message;
		this.createdDate = createdDate;
		this.author = author;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@XmlTransient
	public Map<Long, Comment> getCommentMap() {
		return commentMap;
	}


	public void setCommentMap(Map<Long, Comment> commentMap) {
		this.commentMap = commentMap;
	}


	public List<Link> getLinks() {
		return links;
	}


	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public void addLink(String urilink, String rel){
		Link link = new Link();
		link.setLink(urilink);
		link.setRel(rel);
		links.add(link);
	}
}
