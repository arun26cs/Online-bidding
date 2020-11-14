package com.onlinebid.model;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorDetails {

	private Date timeStamp;
	private String message; 
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorDetails(Date timeStamp, String message) {
		super();
		this.timeStamp = timeStamp;
		this.message = message; 
	}
	
}
