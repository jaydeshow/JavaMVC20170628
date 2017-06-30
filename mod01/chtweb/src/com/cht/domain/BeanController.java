package com.cht.domain;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class BeanController {
	//attribute
	private String message;
	private JdbcTemplate dao;
	List<Map<String,Object>> result;
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
		result=dao.queryForList("select * from customers  ");
		return "success";
	}
	public List<Map<String, Object>> getResult() {
		return result;
	}
	public void setResult(List<Map<String, Object>> result) {
		this.result = result;
	}
}
