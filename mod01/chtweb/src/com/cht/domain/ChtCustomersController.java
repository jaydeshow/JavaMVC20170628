package com.cht.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cht.entity.Customer;
import com.opensymphony.xwork2.ActionSupport;

public class ChtCustomersController extends ActionSupport {

	private String customerid;
	private String message;
	// 部屬工廠務建
	private ApplicationContext factory = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	private DataSource dataSource;
	private Customer customer;
	// 配置一個客戶配置model
	private Customers customers;
	// 區域model
	private List<Alias> alias;

	public List<Alias> getAlias() {
		return alias;
	}

	public void setAlias(List<Alias> alias) {
		this.alias = alias;
	}

	// 自訂建構子
	public ChtCustomersController() {
		alias = new ArrayList<>();
		// 查詢資料庫多筆
		// 取DAO物件
		JdbcTemplate dao = factory.getBean("jdbcTemplate", JdbcTemplate.class);
		dataSource = dao.getDataSource();
		// 查詢區域基本資料
		String sqlString = "select * from alias";
		List<Map<String, Object>> result = dao.queryForList(sqlString);
		// 整理成自定模組
		for (int s = 0; s < result.size(); s++) {
			// 相對記錄Map
			Map<String, Object> record = result.get(s);
			//建構自定模組
			Alias area = new Alias();
			//注入欄位資訊
			area.setAliasid(Integer.parseInt(record.get("aliasid").toString()));
			area.setAlias(record.get("alias").toString());
			alias.add(area);
		}
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public Customer getCustomer() {
		return customer;
	}

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
		// if (customerid.length() > 0) {
		customerid = "B001";
		// }
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
		// preparestatement??
		String sqlSelect = "select * from customer where customer_id=?";
		// 進行DAO查詢
		customer = dao.queryForObject(sqlSelect, new Object[] { customerid },
		// 自訂查詢結果處理function-callback a delegate
		// 匿名類別時做RowMapper 建構成物件
				new RowMapper<Customer>() {
					@Override
					public Customer mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						// 直接point第一筆
						// 建構customer物件
						Customer customer = new Customer();
						customer.setCustomer_id(rs.getShort("customer_id"));
						customer.setFirst_name(rs.getString("first_name"));
						customer.setLast_name(rs.getString("last_name"));
						customer.setEmail(rs.getString("email"));
						customer.setLast_update(rs.getDate("last_update")
								.toLocaleString());
						return customer;
					}
				});
		return "ok";
	}

	// 新增客戶資料
	public String execute() {
		return SUCCESS;
	}
}