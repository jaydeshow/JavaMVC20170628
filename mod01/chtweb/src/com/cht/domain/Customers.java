package com.cht.domain;

public class Customers {
	private String customerid;
	private String companyname;
	private String address;
	private String phone;
	private int aliasid;
	
	public int getAliasid() {
		return aliasid;
	}
	public void setAliasid(int aliasid) {
		this.aliasid = aliasid;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
