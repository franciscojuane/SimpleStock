package com.francisco.springmvcboot.Controllers.Rest;

import java.time.LocalDateTime;

public class ExceptionResponse {
	private String exceptionName;
	private LocalDateTime time;
	private String details;

	public ExceptionResponse(String exceptionName, LocalDateTime time, String details) {
		super();
		this.exceptionName = exceptionName;
		this.time = time;
		this.details = details;
	}

	public ExceptionResponse(String exceptionName, LocalDateTime time) {
		super();
		this.exceptionName = exceptionName;
		this.time = time;
		this.details = details;
	}

	public ExceptionResponse() {
		super();
	}

	public String getExceptionName() {
		return exceptionName;
	}

	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
