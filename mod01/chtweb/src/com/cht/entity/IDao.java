package com.cht.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public interface IDao {
	public ResultSet select(String sqlString, Object... args)
			throws SQLException;

	// 強制注入屬性 存取封裝藍為
	public void setDataSource(DataSource datasource);
}
