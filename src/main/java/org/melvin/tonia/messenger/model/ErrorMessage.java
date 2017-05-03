package org.melvin.tonia.messenger.model;

public class ErrorMessage {

	private String errorCode;
	private String message;
	private String documentation;
	
	public ErrorMessage() {
		
	}
	public ErrorMessage(String errorCode, String message, String documentation) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.documentation = documentation;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDocumentation() {
		return documentation;
	}
	
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
}
