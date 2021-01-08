package com.neusoft.dao;

import com.neusoft.entity.Admin;

/**
 * 多态
 * @author Neuedu
 * 父子类
 * 子类重写父类的方法
 * 父类引用指向子类的实例
 * List<String> arrs = new ArrayList<String>();
 */
public interface AdminDao {

	// 添加管理员
	boolean addOneAdmin(Admin admin);
	
	// 查询管理员
	Admin selectOneAdmin(Admin admin);
	
	// 判断管理员
	boolean judgeAdmin(Admin admin);
	
}