package com.filmland.springbootstarter.dto;

import java.util.Date;

public class ResponseStatus {

	private Date date;
	private String status;
	private String message;

	public ResponseStatus(Date date, String status, String message) {
		super();
		this.date = date;
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
