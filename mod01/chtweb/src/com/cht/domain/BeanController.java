package com.cht.domain;

public class BeanController {
	//attribute
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String doIt(){
		return "success";
	}
}
