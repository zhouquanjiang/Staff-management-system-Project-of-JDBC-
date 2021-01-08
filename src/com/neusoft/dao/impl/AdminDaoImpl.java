package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.dao.AdminDao;
import com.neusoft.entity.Admin;
import com.neusoft.utils.DBUtils;

public class AdminDaoImpl implements AdminDao{

	@Override
	public boolean addOneAdmin(Admin admin) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("INSERT INTO admin (username,password) VALUES (?,?)");
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			int executeUpdate = ps.executeUpdate();
			return executeUpdate==1?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeResource(connection, ps, null);
		}
		return false;
	}

	@Override
	public Admin selectOneAdmin(Admin admin) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("SELECT username,password FROM admin WHERE username = ? AND password = ?");
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				Admin admin2 = new Admin(null, username, password);
				return admin2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeResource(connection, ps, null);
		}
		return null;
	}
	
	@Override
	public boolean judgeAdmin(Admin admin) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("SELECT username,password FROM admin WHERE username = ? AND password = ?");
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				Admin admin2 = new Admin(null, username, password);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeResource(connection, ps, null);
		}
		return false;
	}
	
}

