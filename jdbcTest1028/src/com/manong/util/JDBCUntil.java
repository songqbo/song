package com.manong.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUntil {
	private static String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private static String user = "scott";
	private static String password = "tiger";

	// 目的：让驱动只加载一次，使用静态块
	// 静态块的特点：最先执行并且只执行一次`1l
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleConnection");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 定义方法获取数据库连接
	// 加static的目的是为了可以直接通过类名调用此方法
	public static Connection getconnection() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 定义方法关闭jdbc相关的对象资源，
	public static void closeAll(Connection conn, PreparedStatement pstm, ResultSet rs) {

		try {
			// 关闭resultset?
			if (rs != null) {
				rs.close();
			}
			// 关闭sql语句对象
			if (pstm != null) {
				pstm.close();
			}
			// 关闭数据库对象
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
