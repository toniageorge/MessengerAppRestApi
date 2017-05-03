package org.melvin.tonia.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Comment {

	private long id;
	private String message;
	private Date createdDate;
	
	public Comment(long id, String message, Date createdDate, String author) {
		this.id = id;
		this.message = message;
		this.createdDate = createdDate;
		this.author = author;
	}
	public Comment(){
		
		
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
	private String author;
}
