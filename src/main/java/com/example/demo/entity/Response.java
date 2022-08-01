package com.example.demo.entity;

public class Response<T> {
	
	private T message;
	private Boolean error;
	private String errorMessage;
	
	public Response() {
	}
	public T getMessage() {
		return message;
	}
	public void setMessage(T message) {
		this.message = message;
	}
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
