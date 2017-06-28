package com.cht.domain;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class CustomersController extends ActionSupport {
	private String customerid;
	private String companyname;
	private String address;
	private String phone;

	// 借助 ServletActionContext類別static method 參考出底層的環境
	private HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public String customersSave() {
		// 進行驗證...
		// 進行新增作業
		// request狀態管理
		request.setAttribute("customerid", customerid);
		request.setAttribute("companyname", companyname);
		request.setAttribute("address", address);
		request.setAttribute("phone", phone);
		return "ok";
	}

	// property injection(屬性注入)
	// settter and getter
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