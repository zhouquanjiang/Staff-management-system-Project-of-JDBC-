package com.neusoft.dao;

import com.neusoft.entity.Admin;

/**
 * ��̬
 * @author Neuedu
 * ������
 * ������д����ķ���
 * ��������ָ�������ʵ��
 * List<String> arrs = new ArrayList<String>();
 */
public interface AdminDao {

	// ��ӹ���Ա
	boolean addOneAdmin(Admin admin);
	
	// ��ѯ����Ա
	Admin selectOneAdmin(Admin admin);
	
	// �жϹ���Ա
	boolean judgeAdmin(Admin admin);
	
}