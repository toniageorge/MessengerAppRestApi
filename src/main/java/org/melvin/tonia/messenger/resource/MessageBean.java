package org.melvin.tonia.messenger.resource;

import javax.ws.rs.QueryParam;

public class MessageBean {
	@QueryParam ("year") int year;
	@QueryParam("start") int start;
	@QueryParam("size") int size;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
