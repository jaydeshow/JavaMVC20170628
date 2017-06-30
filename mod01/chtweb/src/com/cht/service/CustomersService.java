package com.cht.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cht.entity.Message;
import com.google.gson.Gson;
@Path("customers")
public class CustomersService {
	// 工廠
	private ApplicationContext factory = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	// 判斷客戶編號和理性
	@Path("cidvalid")
	@GET
	@Produces("application/json") // MIME Type
	public String customersIDValid(@QueryParam("cid")String customerid) {
		String cid = null;
		Message message = null;
		// 1.菜用Srpingframe dao
		String sqlString = "select customerid from customers where customerid = ?";
		// 2.單一物件查詢
		JdbcTemplate dao = factory.getBean("jdbcTemplate", JdbcTemplate.class);
		try {
			cid = dao.queryForObject(sqlString, new Object[] { customerid },
			// 匿名類別誤鍵 RowMap
					new RowMapper<String>() {

						@Override
						public String mapRow(ResultSet result, int arg1)
								throws SQLException {
							// 有直接point到第一筆
							String customerid = result.getString("customerid");
							return customerid;
						}

					});
			//正常執行 有找到
			//封裝一個Message 包含 json
			message = new Message();
			message.setStateCode(400);
			message.setMsg("客戶編號重複 不合法!!");
		} catch (Exception e) {
			// TODO: handle exception
			cid = "notfound";
			message = new Message();
			message.setStateCode(400);
			message.setMsg("客戶編號 合法!!");
		}
		//return cid;
		Gson gson = new Gson();
		String msg = gson.toJson(message);
		
		return msg;
		
	}
}
