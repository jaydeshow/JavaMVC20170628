package com.cht.domain;

import org.springframework.jdbc.core.JdbcTemplate;

public class BeanController {
	//attribute
	private String message;
	private JdbcTemplate dao;
	public JdbcTemplate getDao() {
		return dao;
	}
	public void setDao(JdbcTemplate dao) {
		this.dao = dao;
	}
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
