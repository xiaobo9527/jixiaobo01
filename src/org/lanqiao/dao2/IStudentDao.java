package org.lanqiao.dao2;

import java.util.List;

import org.lanqiao.enity2.Student;

public interface  IStudentDao {
	 // ��ȡ������������
	 public int getTotalCount();
	 // ��ȡ����ǰҳ����ȫ��ѧ����Ϣ�ļ��ϡ���������Page�еļ�������students��ֵ;currentPage��ʾ��ǰҳ��ҳ�룬pageSize��ʾҳ���С
	 public List<Student> getStudentsListForCurrentPage(int currentPage, int pageSize);
}
