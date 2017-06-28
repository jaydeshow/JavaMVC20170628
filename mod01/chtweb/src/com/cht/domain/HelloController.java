package com.cht.domain;

import com.opensymphony.xwork2.ActionSupport;

// POJO(Plain Old Java Object) 不見得要繼承 ActionSupport
public class HelloController extends ActionSupport {

	/**
	 * default method--action不指定method name預設這一個 參考 struts.xml設定
	 * 
	 * @return 旗標
	 */
	public String execute() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
}