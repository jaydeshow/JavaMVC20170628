package com.cht.domain;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.struts2.ServletActionContext;

import com.cht.entity.CountryDao;
import com.cht.entity.IDao;
import com.opensymphony.xwork2.ActionSupport;

public class CountryController extends ActionSupport {

	private String msg;
	// 借助 ServletActionContext類別static method 參考出底層的環境
	private HttpServletRequest request = ServletActionContext.getRequest();

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
			rs.next();
			msg = rs.getString("country");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			msg = e.getMessage();
		}

		request.setAttribute("msg", msg);
		return SUCCESS;
	}
}