package com.neusoft.dao;

import java.util.List;


import com.neusoft.entity.Emp;

//对emp的数据访问以及操作

public interface EmpDao {
	boolean addEmp(Emp emp);
		
	boolean delEmp(Integer id);
	
	boolean updateEmp(Emp emp);
	
	List<Emp> selectByName(String name);

	List<Emp> selectByID(int id);

	List<Emp> selectBydeptnameName(String deptname);

	List<Emp> selectBytel(String tel);

	List<Emp> selectBysex(char sex);

	

	boolean updatename1(Emp emp);

	boolean updatedeptname(Emp emp);

	boolean updatesex(Emp emp);

	boolean updatetel(Emp emp);

	List<Emp> selectall();

	



	
	
	

}
