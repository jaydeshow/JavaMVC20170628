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
		// 處理產生狀態 如何讓狀態state 持續到派送的View去
		String message = "持續狀態msg";
		return SUCCESS;
	}
	
	// 有狀態管理 hello world
	public String helloState()
	{
		//內部互動產生一些資訊
		//...字串是一個物件
		String mesage = "您好!中華電信!!";
		//偷偷補上底層寫法 接軌到Servlet API???
		//沒辦法跟底層互動(被隔離)
		
		//回一個旗標給Action Result進行判斷
		return "hello";
	}
}