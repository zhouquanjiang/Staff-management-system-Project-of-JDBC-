package com.neusoft.view;

import java.util.List;
import java.util.Scanner;

import com.neusoft.dao.AdminDao;
import com.neusoft.dao.EmpDao;
import com.neusoft.dao.impl.AdminDaoImpl;
import com.neusoft.dao.impl.EmpDaoImpl;
import com.neusoft.entity.Admin;
import com.neusoft.entity.Emp;

public class MainPage {

	// Scanner 屏幕输入
	Scanner scanner = new Scanner(System.in);
	
	// 创建了一个adminDao的对象
	AdminDao adminDao = new AdminDaoImpl();
	
	//创建一个 empDao 的对象 
	EmpDao empDao = new EmpDaoImpl();
	/**
	 * 编写界面
	 */
	public void start() {
		System.out.println("*****************欢迎来到员工管理系统********************");
		System.out.println("1.注册");
		System.out.println("2.登录");
		System.out.println("*******************************************************");
		//int nextInt = scanner.nextInt();
		Scanner i = new Scanner(System.in);   
		try {    int sc = i.nextInt(); 
		
		switch (sc) { //switch char byte short int String enum
		case 1:
			registerPage();
			break;
		case 2:
			loginPage();
			break;
		default:
			System.err.print("输入有误,重新输入");
			start();
			break;
		}
		} catch (Exception e) { 
			System.out.println("输入类型错误,请重新选择");
			start();
		}
		
	}
	
/*
 * 管理员首页
 * 
 * 
 */
	
	private void index() {
		System.out.println("*****************欢迎来到员工管理系统********************");
		System.out.println("1.添加员工信息");
		System.out.println("2.删除员工信息");
		System.out.println("3.修改员工信息");
		System.out.println("4.查询员工信息");
		System.out.println("5.退出系统");
		System.out.println("*******************************************************");
		Scanner i = new Scanner(System.in);   
		try {    int sc = i.nextInt(); 
		switch(sc) {
		case 1:
			addEmp();
			break;
		case 2:
			delEmp();
			break;
		case 3:
			updateindex();
			break;
		case 4:
			System.out.println("请选择按照什么要查找");
			selindex();
			break;
		case 5:
			System.out.println("宁已退出本系统，再见");
			System.exit(0);
			break;
		default:
			System.err.println("输入有误，请从新输入菜单序号！");
			index();
			break;
		} 
		}
		catch (Exception e) { 
			System.out.println("输入类型错误,请重新选择");
			index();
		}
		
		
	}
	private void updateindex() {  //修改界面
		System.out.println("*****************欢迎来到员工管理系统********************");
		System.out.println("1.修改全部信息");
		System.out.println("2.修改姓名信息");
		System.out.println("3.修改部门信息");
		System.out.println("4.修改性别信息");
		System.out.println("5.修改联系方式信息");
		System.out.println("6.返回上一级");
		System.out.println("*******************************************************");
		Scanner i = new Scanner(System.in);   
		try {    int sc = i.nextInt(); 
		
		switch (sc) { //switch char byte short int String enum
		case 1:
			updateEmp();
			break;
		case 2:
			updatename();
			break;
			
		case 3:
			updatedeptname();
			break;
			
		case 4:
			updatesex();
			break;
		case 5:
			updatetel();
			break;
		case 6:
			index();
			break;
		default:
			System.err.print("输入有误,重新输入");
			updateindex();
			break;
		}
		} catch (Exception e) { 
			System.out.println("输入类型错误,请重新选择");
			updateindex();
		}
		
	}
	
	private void selindex() {  //查询界面
		System.out.println("*****************欢迎来到员工管理系统********************");
		System.out.println("1.按照员工id查询信息");
		System.out.println("2.按照员工姓名查询信息");
		System.out.println("3.按照部门查询信息");
		System.out.println("4.按照员工性别查询信息");
		System.out.println("5.按照电话号码查询信息");
		System.out.println("6.返回上一级");
		System.out.println("*******************************************************");
		Scanner i = new Scanner(System.in);   
		try {    int sc = i.nextInt(); 
		
		switch (sc) { //switch char byte short int String enum
		case 1:
			selid();
			break;
		case 2:
			selEmp();
			break;
			
		case 3:
			seldeptname();
			break;
			
		case 4:
			selsex();
			break;
		case 5:
			seltel();
			break;
		case 6:
			index();
			break;
		default:
			System.err.print("输入有误,重新输入");
			selindex();
			break;
		}
		} catch (Exception e) { 
			System.out.println("输入类型错误,请重新选择");
			selindex();
		}
	}
	
	private void selEmp() {
		System.out.println("请输入需要查询的员工姓名（支持模糊查询）:");
		String name = scanner.next();
		List<Emp> selectByName = empDao.selectByName(name);
		System.out.println(selectByName);
		selindex();
		
	}
	private void selid() {
		System.out.println("请输入需要查询的员工工号:");
		int id = scanner.nextInt();
		List<Emp> selectByID = empDao.selectByID(id);
		System.out.println(selectByID);
		selindex();
		
	}
	private void seldeptname() {
		System.out.println("请输入需要查询的部门（支持模糊查询）:");
		String name = scanner.next();
		List<Emp> selectByName = empDao.selectBydeptnameName(name);
		System.out.println(selectByName);
		selindex();
		
	}
	
	private void selsex() {
		System.out.println("请输入需要查询的性别:");
		
		Scanner s=new Scanner(System.in);
		char b =s.next().charAt(0);
		List<Emp> selectByName = empDao.selectBysex(b);
		System.out.println(selectByName);
		selindex();
		
	}
	private void seltel() {
		System.out.println("请输入需要查询的电话号码（支持模糊查询）:");
		String name = scanner.next();
		List<Emp> selectByName = empDao.selectBytel(name);
		System.out.println(selectByName + "\n");
		selindex();
		
	}

	private void updateEmp() {
		System.out.println("请输入要修改的员工ID:");
		int id = scanner.nextInt();
		System.out.println("请输入修改后员工姓名:");
		String name = scanner.next();
		System.out.println("请输入修改后部门名称:");
		String deptname = scanner.next();
		System.out.println("请输入修改后员工性别:");
		String sex = scanner.next();
		System.out.println("请输入修改后员工的联系方式:");
		String tel = scanner.next();
		//执行修改操作
		boolean result = empDao.updateEmp(new Emp(id,name,deptname,sex.charAt(0),tel));
		if( result ) {
			System.out.println("添加员工信息成功");
			//返回上级
			updateindex();	
		}else {
			System.err.println("修改信息有误————请重新修改");
			updateEmp();
		}
		
	}
	
	private void updatename() {
		System.out.println("请输入要修改的员工ID:");
		int id = scanner.nextInt();
		System.out.println("请输入修改后员工姓名:");
		String name = scanner.next();
		//执行修改操作
		boolean result = empDao.updatename1(new Emp(id,name));
		if( result ) {
			System.out.println("修改员工信息成功");
			//返回上级
			updateindex();	
		}else {
			System.err.println("修改信息有误————请重新修改");
			updateEmp();
		}
		
	}
	private void updatedeptname() {
		System.out.println("请输入要修改的员工ID:");
		int id = scanner.nextInt();
		System.out.println("请输入修改后员工部门:");
		String name = scanner.next();
		//执行修改操作
		boolean result = empDao.updatedeptname(new Emp(id,name));
		if( result ) {
			System.out.println("修改员工信息成功");
			//返回上级
			updateindex();	
		}else {
			System.err.println("修改信息有误————请重新修改");
			updateEmp();
		}
		
	}
	private void updatesex() {
		System.out.println("请输入要修改的员工ID:");
		int id = scanner.nextInt();
		System.out.println("请输入要修改为男/女:");
		Scanner s=new Scanner(System.in);
		char b =s.next().charAt(0);
		//执行修改操作
		boolean result = empDao.updatesex(new Emp(id,b));
		if( result ) {
			System.out.println("修改员工信息成功");
			//返回上级
			updateindex();	
		}else {
			System.err.println("修改信息有误————请重新修改");
			updateEmp();
		}
		
	}
	
	
	private void updatetel() {
		System.out.println("请输入要修改的员工ID:");
		int id = scanner.nextInt();
		System.out.println("请输入修改后员工电话(11位):");
		String name = scanner.next();
		
		/**
		  * 验证电话号码
		  * while循环控制直到输入合法为止
		  */
		 while(!checktel(name)) {
		  System.out.println("电话号码不合法，请重新输入：");
		 name = scanner.next();
		 }
		
		
		
		//执行修改操作
		boolean result = empDao.updatetel(new Emp(id,name));
		if( result ) {
			System.out.println("修改员工信息成功");
			//返回上级
			updateindex();	
		}else {
			System.err.println("修改信息有误————请重新修改");
			updateEmp();
		}
		
	}

	private void delEmp() {
		System.out.println("是否确定执行删除操作（不可逆！！！）:");
		System.out.println("1.退出，不删除");
		System.out.println("2.继续执行删除操作");
		int cheak = scanner.nextInt();
		
		switch(cheak) {
		case 1:
			index();
			break;
		case 2:
			System.out.println("请输入员工ID:");
			int id = scanner.nextInt();
			//执行删除操作
			
			boolean result = empDao.delEmp(id);
			
			if( result ) {
				System.out.println("删除员工信息成功");
				//可继续添加或者返回上级
				index();	
			}else {
				System.err.println("删除信息有误————请重新输入员工ID");
				delEmp();
			}
			break;
		}
//		System.out.println("请输入员工ID:");
//		int id = scanner.nextInt();
//		//执行删除操作
//		
//		boolean result = empDao.delEmp(id);
//		
//		if( result ) {
//			System.out.println("删除员工信息成功");
//			//可继续添加或者返回上级
//			index();	
//		}else {
//			System.err.println("删除信息有误————请重新输入员工ID");
//			delEmp();
//		}
	
}

	/*
	 * 添加员工信息页面
	 * 
	 */
	private void addEmp() {
		System.out.println("请输入员工姓名:");
		String name = scanner.next();
		System.out.println("请输入部门名称:");
		String deptname = scanner.next();
		System.out.println("请输入员工性别:");
		String sex = scanner.next();
		System.out.println("请输入员工的联系方式（11位的合法电话号码）:");
		String tel = scanner.next();
		/**
		  * 验证电话号码
		  * while循环控制直到输入合法为止
		  */
		 while(!checktel(tel)) {
		  System.out.println("电话号码不合法，请重新输入：");
		 name = scanner.next();
		 }
		
		//执行添加操作
		boolean result = empDao.addEmp(new Emp(null,name,deptname,sex.charAt(0),tel));
		if( result ) {
			System.out.println("添加员工信息成功");
			//可继续添加或者返回上级
			index();	
		}else {
			System.err.println("添加信息有误————请重新添加");
			addEmp();
		}
		
		
	}
	
	
	
	
	
	
	/**
	 * 登录页面
	 */
	private void loginPage() {
		System.out.println("请输入用户名（必须是6-10位字母、数字、下划线任意组合且不能数字开头）:");
		String name = scanner.next();
		 /**
		  * 验证用户名
		  * while循环控制直到输入合法为止
		  */
		 while(!checkName(name)) {
		  System.out.println("用户名不合法，请重新输入：");
		 name = scanner.next();
		 }
		 
		System.out.println("请输入密码（必须是6-20位的字母、数字、下划线任意组合）:");
		String psw = scanner.next();
		while(!checkPwd(psw)) {
			  System.out.println("密码不合法，请重新输入：");
			  psw = scanner.next();
			 }
		
		Admin admin = new Admin(null,name,psw);
		Admin addOneAdmin = adminDao.selectOneAdmin(admin);
		if(addOneAdmin != null) {
			System.out.println("登录成功");
			index();
		}else {
			System.out.println("登录失败,请重新登录");
			loginPage();
		}
	}

	/**
	 * 注册
	 */
	public void registerPage() {
		System.out.println("请输入用户名（必须是6-10位字母、数字、下划线任意组合且不能数字开头）:");
		String name = scanner.next();
		 /**
		  * 验证用户名
		  * while循环控制直到输入合法为止
		  */
		 while(!checkName(name)) {
		  System.out.println("用户名不合法，请重新输入：");
		 name = scanner.next();
		 }
		 
		System.out.println("请输入密码（必须是6-20位的字母、数字、下划线任意组合）:");
		String psw = scanner.next();
		while(!checkPwd(psw)) {
			  System.out.println("密码不合法，请重新输入：");
			  psw = scanner.next();
			 }
		
		Admin admin = new Admin(null,name,psw);
		
		boolean addOneAdmin = adminDao.addOneAdmin(admin);
		if(addOneAdmin) {
			System.out.println("注册成功");
			start();
		}else {
			System.out.println("注册失败,请重新注册");
			registerPage();
		}
	}
	
	
	 /**
	 * 用户名验证
	 * @param name
	 * @return
	 */
	 public static boolean checkName(String name) {
	 String regExp = "^[^0-9][\\w_]{5,9}$";
	 if(name.matches(regExp)) {
	  return true;
	 }else {
	  return false;
	 }
	 }
	
	 /**
	  * 密码验证
	  * @param pwd
	  * @return
	  */
	  public static boolean checkPwd(String pwd) {
	  String regExp = "^[\\w_]{6,20}$";
	  if(pwd.matches(regExp)) {
	   return true;
	  }
	  return false;
	  }
	  
	  
	  /**
		  * 密码验证
		  * @param pwd
		  * @return
		  */
		  public static boolean checktel(String pwd) {
		  String regExp = "^0?1[3|bai4|5|8][0-9]\\d{8}$";
		  if(pwd.matches(regExp)) {
		   return true;
		  }
		  return false;
		  }

}