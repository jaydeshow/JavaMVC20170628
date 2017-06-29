package com.cht.domain;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

// POJO(Plain Old Java Object) 不見得要繼承 ActionSupport
public class HelloController {
	// 我需要存取request
	// 借助 ServletActionContext類別static method 參考出底層的環境
	private HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * default method--action不指定method name預設這一個 參考 struts.xml設定
	 * 
	 * @return 旗標
	 */
	public String execute() {
		// TODO Auto-generated method stub
		// 處理產生狀態 如何讓狀態state 持續到派送的View去
		String message = "持續狀態msg";
		request.setAttribute("msg", message);
		return "success";
	}

	// 有狀態管理 hello world
	public String helloState() {
		// 內部互動產生一些資訊
		// ...字串是一個物件
		String mesage = "您好!中華電信!!";
		// 偷偷補上底層寫法 接軌到Servlet API???
		// 沒辦法跟底層互動(被隔離)
		request.setAttribute("msg", mesage);
		// request.getRequestDispatcher(arg0) ;丟給dispatcher呼叫
		// 回一個旗標給Action Result進行判斷
		return "hello";
	}
}