package com.cht.domain;

import com.opensymphony.xwork2.ActionSupport;

public class OGNLController extends ActionSupport {
	private Customers customers;

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	// 自訂建構子
	public OGNLController() {
		customers = new Customers();
		customers.setCustomerid("001");
		customers.setCompanyname("種花店");
		customers.setAddress("板橋區");
		customers.setPhone("008009");
	}

	private String country;

	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		country = "中華民狗";
		return SUCCESS;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}