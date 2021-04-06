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

	// Ŀ�ģ�������ֻ����һ�Σ�ʹ�þ�̬��
	// ��̬����ص㣺����ִ�в���ִֻ��һ��`1l
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleConnection");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ���巽����ȡ���ݿ�����
	// ��static��Ŀ����Ϊ�˿���ֱ��ͨ���������ô˷���
	public static Connection getconnection() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// ���巽���ر�jdbc��صĶ�����Դ��
	public static void closeAll(Connection conn, PreparedStatement pstm, ResultSet rs) {

		try {
			// �ر�resultset?
			if (rs != null) {
				rs.close();
			}
			// �ر�sql������
			if (pstm != null) {
				pstm.close();
			}
			// �ر����ݿ����
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
