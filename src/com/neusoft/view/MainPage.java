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

	// Scanner ��Ļ����
	Scanner scanner = new Scanner(System.in);
	
	// ������һ��adminDao�Ķ���
	AdminDao adminDao = new AdminDaoImpl();
	
	//����һ�� empDao �Ķ��� 
	EmpDao empDao = new EmpDaoImpl();
	/**
	 * ��д����
	 */
	public void start() {
		System.out.println("*****************��ӭ����Ա������ϵͳ********************");
		System.out.println("1.ע��");
		System.out.println("2.��¼");
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
			System.err.print("��������,��������");
			start();
			break;
		}
		} catch (Exception e) { 
			System.out.println("�������ʹ���,������ѡ��");
			start();
		}
		
	}
	
/*
 * ����Ա��ҳ
 * 
 * 
 */
	
	private void index() {
		System.out.println("*****************��ӭ����Ա������ϵͳ********************");
		System.out.println("1.���Ա����Ϣ");
		System.out.println("2.ɾ��Ա����Ϣ");
		System.out.println("3.�޸�Ա����Ϣ");
		System.out.println("4.��ѯԱ����Ϣ");
		System.out.println("5.�˳�ϵͳ");
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
			System.out.println("��ѡ����ʲôҪ����");
			selindex();
			break;
		case 5:
			System.out.println("�����˳���ϵͳ���ټ�");
			System.exit(0);
			break;
		default:
			System.err.println("�����������������˵���ţ�");
			index();
			break;
		} 
		}
		catch (Exception e) { 
			System.out.println("�������ʹ���,������ѡ��");
			index();
		}
		
		
	}
	private void updateindex() {  //�޸Ľ���
		System.out.println("*****************��ӭ����Ա������ϵͳ********************");
		System.out.println("1.�޸�ȫ����Ϣ");
		System.out.println("2.�޸�������Ϣ");
		System.out.println("3.�޸Ĳ�����Ϣ");
		System.out.println("4.�޸��Ա���Ϣ");
		System.out.println("5.�޸���ϵ��ʽ��Ϣ");
		System.out.println("6.������һ��");
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
			System.err.print("��������,��������");
			updateindex();
			break;
		}
		} catch (Exception e) { 
			System.out.println("�������ʹ���,������ѡ��");
			updateindex();
		}
		
	}
	
	private void selindex() {  //��ѯ����
		System.out.println("*****************��ӭ����Ա������ϵͳ********************");
		System.out.println("1.����Ա��id��ѯ��Ϣ");
		System.out.println("2.����Ա��������ѯ��Ϣ");
		System.out.println("3.���ղ��Ų�ѯ��Ϣ");
		System.out.println("4.����Ա���Ա��ѯ��Ϣ");
		System.out.println("5.���յ绰�����ѯ��Ϣ");
		System.out.println("6.������һ��");
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
			System.err.print("��������,��������");
			selindex();
			break;
		}
		} catch (Exception e) { 
			System.out.println("�������ʹ���,������ѡ��");
			selindex();
		}
	}
	
	private void selEmp() {
		System.out.println("��������Ҫ��ѯ��Ա��������֧��ģ����ѯ��:");
		String name = scanner.next();
		List<Emp> selectByName = empDao.selectByName(name);
		System.out.println(selectByName);
		selindex();
		
	}
	private void selid() {
		System.out.println("��������Ҫ��ѯ��Ա������:");
		int id = scanner.nextInt();
		List<Emp> selectByID = empDao.selectByID(id);
		System.out.println(selectByID);
		selindex();
		
	}
	private void seldeptname() {
		System.out.println("��������Ҫ��ѯ�Ĳ��ţ�֧��ģ����ѯ��:");
		String name = scanner.next();
		List<Emp> selectByName = empDao.selectBydeptnameName(name);
		System.out.println(selectByName);
		selindex();
		
	}
	
	private void selsex() {
		System.out.println("��������Ҫ��ѯ���Ա�:");
		
		Scanner s=new Scanner(System.in);
		char b =s.next().charAt(0);
		List<Emp> selectByName = empDao.selectBysex(b);
		System.out.println(selectByName);
		selindex();
		
	}
	private void seltel() {
		System.out.println("��������Ҫ��ѯ�ĵ绰���루֧��ģ����ѯ��:");
		String name = scanner.next();
		List<Emp> selectByName = empDao.selectBytel(name);
		System.out.println(selectByName + "\n");
		selindex();
		
	}

	private void updateEmp() {
		System.out.println("������Ҫ�޸ĵ�Ա��ID:");
		int id = scanner.nextInt();
		System.out.println("�������޸ĺ�Ա������:");
		String name = scanner.next();
		System.out.println("�������޸ĺ�������:");
		String deptname = scanner.next();
		System.out.println("�������޸ĺ�Ա���Ա�:");
		String sex = scanner.next();
		System.out.println("�������޸ĺ�Ա������ϵ��ʽ:");
		String tel = scanner.next();
		//ִ���޸Ĳ���
		boolean result = empDao.updateEmp(new Emp(id,name,deptname,sex.charAt(0),tel));
		if( result ) {
			System.out.println("���Ա����Ϣ�ɹ�");
			//�����ϼ�
			updateindex();	
		}else {
			System.err.println("�޸���Ϣ���󡪡������������޸�");
			updateEmp();
		}
		
	}
	
	private void updatename() {
		System.out.println("������Ҫ�޸ĵ�Ա��ID:");
		int id = scanner.nextInt();
		System.out.println("�������޸ĺ�Ա������:");
		String name = scanner.next();
		//ִ���޸Ĳ���
		boolean result = empDao.updatename1(new Emp(id,name));
		if( result ) {
			System.out.println("�޸�Ա����Ϣ�ɹ�");
			//�����ϼ�
			updateindex();	
		}else {
			System.err.println("�޸���Ϣ���󡪡������������޸�");
			updateEmp();
		}
		
	}
	private void updatedeptname() {
		System.out.println("������Ҫ�޸ĵ�Ա��ID:");
		int id = scanner.nextInt();
		System.out.println("�������޸ĺ�Ա������:");
		String name = scanner.next();
		//ִ���޸Ĳ���
		boolean result = empDao.updatedeptname(new Emp(id,name));
		if( result ) {
			System.out.println("�޸�Ա����Ϣ�ɹ�");
			//�����ϼ�
			updateindex();	
		}else {
			System.err.println("�޸���Ϣ���󡪡������������޸�");
			updateEmp();
		}
		
	}
	private void updatesex() {
		System.out.println("������Ҫ�޸ĵ�Ա��ID:");
		int id = scanner.nextInt();
		System.out.println("������Ҫ�޸�Ϊ��/Ů:");
		Scanner s=new Scanner(System.in);
		char b =s.next().charAt(0);
		//ִ���޸Ĳ���
		boolean result = empDao.updatesex(new Emp(id,b));
		if( result ) {
			System.out.println("�޸�Ա����Ϣ�ɹ�");
			//�����ϼ�
			updateindex();	
		}else {
			System.err.println("�޸���Ϣ���󡪡������������޸�");
			updateEmp();
		}
		
	}
	
	
	private void updatetel() {
		System.out.println("������Ҫ�޸ĵ�Ա��ID:");
		int id = scanner.nextInt();
		System.out.println("�������޸ĺ�Ա���绰(11λ):");
		String name = scanner.next();
		
		/**
		  * ��֤�绰����
		  * whileѭ������ֱ������Ϸ�Ϊֹ
		  */
		 while(!checktel(name)) {
		  System.out.println("�绰���벻�Ϸ������������룺");
		 name = scanner.next();
		 }
		
		
		
		//ִ���޸Ĳ���
		boolean result = empDao.updatetel(new Emp(id,name));
		if( result ) {
			System.out.println("�޸�Ա����Ϣ�ɹ�");
			//�����ϼ�
			updateindex();	
		}else {
			System.err.println("�޸���Ϣ���󡪡������������޸�");
			updateEmp();
		}
		
	}

	private void delEmp() {
		System.out.println("�Ƿ�ȷ��ִ��ɾ�������������棡������:");
		System.out.println("1.�˳�����ɾ��");
		System.out.println("2.����ִ��ɾ������");
		int cheak = scanner.nextInt();
		
		switch(cheak) {
		case 1:
			index();
			break;
		case 2:
			System.out.println("������Ա��ID:");
			int id = scanner.nextInt();
			//ִ��ɾ������
			
			boolean result = empDao.delEmp(id);
			
			if( result ) {
				System.out.println("ɾ��Ա����Ϣ�ɹ�");
				//�ɼ�����ӻ��߷����ϼ�
				index();	
			}else {
				System.err.println("ɾ����Ϣ���󡪡���������������Ա��ID");
				delEmp();
			}
			break;
		}
//		System.out.println("������Ա��ID:");
//		int id = scanner.nextInt();
//		//ִ��ɾ������
//		
//		boolean result = empDao.delEmp(id);
//		
//		if( result ) {
//			System.out.println("ɾ��Ա����Ϣ�ɹ�");
//			//�ɼ�����ӻ��߷����ϼ�
//			index();	
//		}else {
//			System.err.println("ɾ����Ϣ���󡪡���������������Ա��ID");
//			delEmp();
//		}
	
}

	/*
	 * ���Ա����Ϣҳ��
	 * 
	 */
	private void addEmp() {
		System.out.println("������Ա������:");
		String name = scanner.next();
		System.out.println("�����벿������:");
		String deptname = scanner.next();
		System.out.println("������Ա���Ա�:");
		String sex = scanner.next();
		System.out.println("������Ա������ϵ��ʽ��11λ�ĺϷ��绰���룩:");
		String tel = scanner.next();
		/**
		  * ��֤�绰����
		  * whileѭ������ֱ������Ϸ�Ϊֹ
		  */
		 while(!checktel(tel)) {
		  System.out.println("�绰���벻�Ϸ������������룺");
		 name = scanner.next();
		 }
		
		//ִ����Ӳ���
		boolean result = empDao.addEmp(new Emp(null,name,deptname,sex.charAt(0),tel));
		if( result ) {
			System.out.println("���Ա����Ϣ�ɹ�");
			//�ɼ�����ӻ��߷����ϼ�
			index();	
		}else {
			System.err.println("�����Ϣ���󡪡��������������");
			addEmp();
		}
		
		
	}
	
	
	
	
	
	
	/**
	 * ��¼ҳ��
	 */
	private void loginPage() {
		System.out.println("�������û�����������6-10λ��ĸ�����֡��»�����������Ҳ������ֿ�ͷ��:");
		String name = scanner.next();
		 /**
		  * ��֤�û���
		  * whileѭ������ֱ������Ϸ�Ϊֹ
		  */
		 while(!checkName(name)) {
		  System.out.println("�û������Ϸ������������룺");
		 name = scanner.next();
		 }
		 
		System.out.println("���������루������6-20λ����ĸ�����֡��»���������ϣ�:");
		String psw = scanner.next();
		while(!checkPwd(psw)) {
			  System.out.println("���벻�Ϸ������������룺");
			  psw = scanner.next();
			 }
		
		Admin admin = new Admin(null,name,psw);
		Admin addOneAdmin = adminDao.selectOneAdmin(admin);
		if(addOneAdmin != null) {
			System.out.println("��¼�ɹ�");
			index();
		}else {
			System.out.println("��¼ʧ��,�����µ�¼");
			loginPage();
		}
	}

	/**
	 * ע��
	 */
	public void registerPage() {
		System.out.println("�������û�����������6-10λ��ĸ�����֡��»�����������Ҳ������ֿ�ͷ��:");
		String name = scanner.next();
		 /**
		  * ��֤�û���
		  * whileѭ������ֱ������Ϸ�Ϊֹ
		  */
		 while(!checkName(name)) {
		  System.out.println("�û������Ϸ������������룺");
		 name = scanner.next();
		 }
		 
		System.out.println("���������루������6-20λ����ĸ�����֡��»���������ϣ�:");
		String psw = scanner.next();
		while(!checkPwd(psw)) {
			  System.out.println("���벻�Ϸ������������룺");
			  psw = scanner.next();
			 }
		
		Admin admin = new Admin(null,name,psw);
		
		boolean addOneAdmin = adminDao.addOneAdmin(admin);
		if(addOneAdmin) {
			System.out.println("ע��ɹ�");
			start();
		}else {
			System.out.println("ע��ʧ��,������ע��");
			registerPage();
		}
	}
	
	
	 /**
	 * �û�����֤
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
	  * ������֤
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
		  * ������֤
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