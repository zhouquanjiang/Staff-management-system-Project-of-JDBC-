package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.dao.EmpDao;
import com.neusoft.entity.Emp;
import com.neusoft.utils.DBUtils;

public class EmpDaoImpl implements EmpDao{

	private int id;

	@Override
	public boolean addEmp(Emp emp) {
		// TODO Auto-generated method stub
		Connection connection = DBUtils.getConnection();
		PreparedStatement ps = null;
		
		
		try {
			ps = connection.prepareStatement("INSERT INTO emps(name,deptname,sex,tel) VALUES(?,?,?,?)");
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getDeptname());
			ps.setString(3, String.valueOf(emp.getSex()));
			ps.setString(4, emp.getTel());
			int executeUpdate = ps.executeUpdate();
			return executeUpdate==1?true:false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeResource(connection, ps, null);
		}
		
		return false;
	}

	@Override
	public boolean delEmp(Integer id) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement ps = null;
		
		
		try {
			ps = connection.prepareStatement("DELETE FROM emps WHERE id = ?");
			ps.setInt(1, id);
			int executeUpdate = ps.executeUpdate();
			return executeUpdate==1?true:false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeResource(connection, ps, null);
		}
		
		return false;
	}

	@Override  
	public boolean updateEmp(Emp emp) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement ps = null;
		
		
		try {
			ps = connection.prepareStatement("UPDATE emps SET name = ?,deptname = ?,sex = ?,tel = ? WHERE id = ?");
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getDeptname());
			ps.setString(3, String.valueOf(emp.getSex()));
			ps.setString(4, emp.getTel());
			ps.setInt(5, emp.getId());
			int executeUpdate = ps.executeUpdate();
			return executeUpdate==1?true:false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeResource(connection, ps, null);
		}
		
		return false;
	}

	/*
	 * 修改名字信息
	 */
	@Override
	public boolean updatename1(Emp emp) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement ps = null;
		
		
		try {
			ps = connection.prepareStatement("UPDATE emps SET name = ? WHERE id = ?");
			ps.setInt(2, emp.getId());
			ps.setString(1, emp.getName());
			
			int executeUpdate = ps.executeUpdate();
			return executeUpdate==1?true:false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeResource(connection, ps, null);
		}
		
		return false;
	}

	// 修改部门名字
	@Override
	public boolean updatedeptname(Emp emp) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement ps = null;
		
		
		try {
			ps = connection.prepareStatement("UPDATE emps SET deptname = ? WHERE id = ?");
			ps.setInt(2, emp.getId());
			ps.setString(1, emp.getName());
			
			int executeUpdate = ps.executeUpdate();
			return executeUpdate==1?true:false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeResource(connection, ps, null);
		}
		
		return false;
	}
	
	
	// 修改员工性别
		@Override
		public boolean updatesex(Emp emp) {
			Connection connection = DBUtils.getConnection();
			PreparedStatement ps = null;
			
			
			try {
				ps = connection.prepareStatement("UPDATE emps SET sex = ? WHERE id = ?");
				ps.setInt(2, emp.getId());
				ps.setString(1, String.valueOf(emp.getSex()));
				
				int executeUpdate = ps.executeUpdate();
				return executeUpdate==1?true:false;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtils.closeResource(connection, ps, null);
			}
			
			return false;
		}
	
		
	// 修改员工联系方式
		
		@Override
		public boolean updatetel(Emp emp) {
			Connection connection = DBUtils.getConnection();
			PreparedStatement ps = null;
			
			
			try {
				ps = connection.prepareStatement("UPDATE emps SET tel = ? WHERE id = ?");
				ps.setInt(2, emp.getId());
				ps.setString(1, emp.getName());
				
				int executeUpdate = ps.executeUpdate();
				return executeUpdate==1?true:false;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtils.closeResource(connection, ps, null);
			}
			
			return false;
		}
		
		
	//------------------以下是查询------------------------------------
	/*
	 * 根据姓名查找
	 */
	
	@Override
	public List<Emp> selectByName(String name) {
		// TODO Auto-generated method stub
				Connection connection = DBUtils.getConnection();
				PreparedStatement ps = null;
				ArrayList<Emp> arrayList = new ArrayList<Emp>();
				
				try {
					ps = connection.prepareStatement("SELECT id,name,deptname,sex,tel FROM emps WHERE name LIKE ?");
					ps.setString(1, "%"+name+"%");

					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						int id = rs.getInt("id");
						String name2 = rs.getString("name");
						String deptname = rs.getString("deptname");
						String sex = rs.getString("sex");
						String tel = rs.getString("tel");
						Emp emp = new Emp(id,name2,deptname,sex.charAt(0),tel);
						arrayList.add(emp);
					}	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DBUtils.closeResource(connection, ps, null);
				}
				
				return arrayList;
	}

	/*
	 * 根据ID查找
	 */
	@Override
	public List<Emp> selectByID(int id) {
		// TODO Auto-generated method stub
				Connection connection = DBUtils.getConnection();
				PreparedStatement ps = null;
				ArrayList<Emp> arrayList = new ArrayList<Emp>();
				
				try {
					ps = connection.prepareStatement("SELECT id,name,deptname,sex,tel FROM emps WHERE id= ?");
					ps.setInt(1, id);

					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						int id2 = rs.getInt("id");
						String name2 = rs.getString("name");
						String deptname = rs.getString("deptname");
						String sex = rs.getString("sex");
						String tel = rs.getString("tel");
						Emp emp = new Emp(id,name2,deptname,sex.charAt(0),tel);
						arrayList.add(emp);
					}	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DBUtils.closeResource(connection, ps, null);
				}
				
				return arrayList;
	}

	
	/*
	 * 根据部门吗名查找
	 */
	@Override
	public List<Emp> selectBydeptnameName(String deptname) {
		// TODO Auto-generated method stub
				Connection connection = DBUtils.getConnection();
				PreparedStatement ps = null;
				ArrayList<Emp> arrayList = new ArrayList<Emp>();
				
				try {
					ps = connection.prepareStatement("SELECT id,name,deptname,sex,tel FROM emps WHERE deptname LIKE ?");
					ps.setString(1, "%"+deptname+"%");

					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						int id = rs.getInt("id");
						String name2 = rs.getString("name");
						String deptname2 = rs.getString("deptname");
						String sex = rs.getString("sex");
						String tel = rs.getString("tel");
						Emp emp = new Emp(id,name2,deptname2,sex.charAt(0),tel);
						arrayList.add(emp);
					}	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DBUtils.closeResource(connection, ps, null);
				}
				
				return arrayList;
	}
	
	/*
	 * 根据联系方式tel查找
	 */
	@Override
	public List<Emp> selectBytel(String tel) {
		// TODO Auto-generated method stub
				Connection connection = DBUtils.getConnection();
				PreparedStatement ps = null;
				ArrayList<Emp> arrayList = new ArrayList<Emp>();
				
				try {
					ps = connection.prepareStatement("SELECT id,name,deptname,sex,tel FROM emps WHERE tel LIKE ?");
					ps.setString(1, "%"+tel+"%");

					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						int id = rs.getInt("id");
						String name2 = rs.getString("name");
						String deptname2 = rs.getString("deptname");
						String sex = rs.getString("sex");
						String tel2 = rs.getString("tel");
						Emp emp = new Emp(id,name2,deptname2,sex.charAt(0),tel2);
						arrayList.add(emp);
					}	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DBUtils.closeResource(connection, ps, null);
				}
				
				return arrayList;
	}
	
	/*
	 * 根据性别sex查找
	 */
	@Override
	public List<Emp> selectBysex(char sex) {
		// TODO Auto-generated method stub
				Connection connection = DBUtils.getConnection();
				PreparedStatement ps = null;
				ArrayList<Emp> arrayList = new ArrayList<Emp>();
				
				try {
					ps = connection.prepareStatement("SELECT id,name,deptname,sex,tel FROM emps WHERE sex LIKE ?");
					ps.setString(1, "%"+sex+"%");

					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						int id = rs.getInt("id");
						String name2 = rs.getString("name");
						String deptname2 = rs.getString("deptname");
						String sex2 = rs.getString("sex");
						String tel2 = rs.getString("tel");
						Emp emp = new Emp(id,name2,deptname2,sex2.charAt(0),tel2);
						arrayList.add(emp);
					}	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DBUtils.closeResource(connection, ps, null);
				}
				
				return arrayList;
	}
	
	
	@Override
	public List<Emp> selectall() {
		// TODO Auto-generated method stub
				Connection connection = DBUtils.getConnection();
				PreparedStatement ps = null;
				ArrayList<Emp> arrayList = new ArrayList<Emp>();
				
				try {
					ps = connection.prepareStatement("SELECT id,name,deptname,sex,tel FROM emps");
					

					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						int id = rs.getInt("id");
						String name2 = rs.getString("name");
						String deptname = rs.getString("deptname");
						String sex = rs.getString("sex");
						String tel = rs.getString("tel");
						Emp emp = new Emp(id,name2,deptname,sex.charAt(0),tel);
						arrayList.add(emp);
					}	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DBUtils.closeResource(connection, ps, null);
				}
				
				return arrayList;
	}

	
}


