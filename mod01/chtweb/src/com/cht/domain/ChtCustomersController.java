package com.cht.domain;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.opensymphony.xwork2.ActionSupport;

public class ChtCustomersController extends ActionSupport {

	private String customerid;
	private String message;
	// 部屬工廠務建
	private ApplicationContext factory = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	private DataSource dataSource;

	// 因為是透過Jdbc樣板取得 只給用get
	public DataSource getDataSource() {
		return dataSource;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	/**
	 * @return
	 */
	public String select() {
		// TODO Auto-generated method stub
		// 判斷有輸入內容的時候進行查詢 nullpointerException
		if (customerid.length() > 0) {
			customerid = "B001";
		}
		message = "查詢成功!!";
		return SUCCESS;
	}

	// 初始畫method
	public void selectInitializer() {
		// 誰會把我這個動起來RR?
	}

	public void prepareSelect() {
		customerid = "B002";
	}

	// 查詢作業
	public String queryByID() {
		// 透過工廠取得dao物件
		JdbcTemplate dao = factory.getBean("jdbcTemplate", JdbcTemplate.class);
		dataSource = dao.getDataSource();
		return "ok";
	}
}