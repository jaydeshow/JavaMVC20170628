package com.cht.domain;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cht.entity.Country;
import com.cht.entity.CountryDao;
import com.cht.entity.IDao;
import com.opensymphony.xwork2.ActionSupport;

public class CountryController extends ActionSupport {

	private String msg;
	// 借助 ServletActionContext類別static method 參考出底層的環境
	private HttpServletRequest request = ServletActionContext.getRequest();

	List<Country> data = new ArrayList<>();
	//定義spring bean factory使用xml規範 整合應用系統資源
	private ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");

	/**
	 * @return
	 */
	public String execute() {
		// 1.存取資料庫 JDBC->DataSource架構
		BasicDataSource datasource = new BasicDataSource();
		// 2.配置資料庫屬性(Driver Class載入/設定連接字串描述/登入名稱與密碼)
		// DataSource 使用屬性注入(Property - setter and getter)
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/sakila");
		datasource.setUsername("root");
		datasource.setPassword("1111");
		// // 借助 datasource配置連接物件
		// try {
		// Connection conn = datasource.getConnection();
		// // 判斷
		// if (!conn.isClosed()) {
		// msg = "連接成功!!";
		// }
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// StringWriter errors = new StringWriter();
		// e.printStackTrace(new PrintWriter(errors));
		// msg = "連接失敗!!" + errors.toString();
		// }
		//

		// 建構DAO物件 介面操作
		IDao dao = new CountryDao();
		// 注入資料來源物件 (property injection)
		dao.setDataSource(datasource);
		try {
			ResultSet rs = dao.select("select * from country");
			// rs.next();// fetch 保持線上
			// msg = rs.getString("country");
			// 走訪ResultSet 逐筆處理
			while (rs.next()) {
				// 建構Country物件
				Country country = new Country();
				country.setCountry_id(rs.getShort("country_id"));
				country.setCountry(rs.getString("country"));
				//country.setLast_update(rs.getDate("last_update"));
				country.setLast_update(rs.getDate("last_update").toLocaleString());
				data.add(country);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			msg = e.getMessage();
		}

		// request.setAttribute("msg", msg);
		//request.setAttribute("data", data);
		return SUCCESS;
	}

	// sttter and getter(Property)

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Country> getData() {
		return data;
	}

	public void setData(List<Country> data) {
		this.data = data;
	}
	
	//菜用SpringFramework進行資料查詢
	public String countrySelect(){
		//透過bean factory要一個data source物件
		//這邊變數請使用interface
		DataSource dataSource = factory.getBean("dataSource", DataSource.class);
		try {
			if(!dataSource.getConnection().isClosed()){
				msg="資料庫連接成功!!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			msg = e.getMessage();
		}
		
		return "ok";
	}
}