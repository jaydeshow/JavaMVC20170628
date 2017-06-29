package com.cht.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class CountryDao implements IDao {

	private DataSource dataSource;

	@Override
	public ResultSet select(String sqlString, Object... args)
			throws SQLException {
		// 判斷是否注入資料來源物件
		if (dataSource == null) {
			// 擲出力外
			throw new SQLException("資料來源物件未注入!!");
		}
		// 要一個連接配置
		Connection conn = dataSource.getConnection();
		// String sqlString = "select * from country ;";
		// 透過連接物件要Preparestatment
		PreparedStatement st = conn.prepareStatement(sqlString);
		// 執行查詢
		return st.executeQuery();
	}

	@Override
	public void setDataSource(DataSource datasource) {

		this.dataSource = datasource;

	}

}
