package com.neusoft.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ��ȡ���ӵķ���
	 */
	public static Connection getConnection() {
		Connection conn = null;
		if(conn == null) {
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees?characterEncoding=utf-8&useSSL=false", "root", "root");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return conn;
	}

	
	/**
	 * �ر�����
	 * Connection
	 * Preparedstatement 
	 * ResultSet
	 * �ر�
	 */
	public static void closeResource(Connection conn,PreparedStatement ps,ResultSet rs) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
