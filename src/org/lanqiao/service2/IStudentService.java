package org.lanqiao.service2;

import java.util.List;

import org.lanqiao.enity2.Student;

public interface IStudentService {
	
	 // ��ȡ������������
	 public int getTotalCount();
	    //��ȡ��ǰҳ����ȫ��ѧ����Ϣ�ļ���
	 public List<Student> getStudentsListForCurrentPage(int currentPage, int pageSize);
	 
}
