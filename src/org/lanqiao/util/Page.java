package org.lanqiao.util;

import java.util.List;

import org.lanqiao.enity2.Student;

public class Page {
	// ��ҳ��
	private int totalPage;
	
	// �������������ж�����������Ҫ��ʾ
	private int totalCount;
	
	// ҳ���С��ÿһҳ��ʾ��������
	private int pageSize;
	
	// ��ǰ��ҳ��
	private int currentPage;
	
	// ʵ���༯��;��List<Student> students���������浱ǰҳ����ȫ��ѧ������Ϣ
	private List<Student> students;

	public int getTotalPage() {
		return totalPage;
	}

	

	public int getTotalCount() {
		return totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> student) {
		this.students = student;
	}

	// ��������ҳ����set��������ҳ���Ǽ�������ģ��С������������͡�ҳ���С������ó�
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		// ������ҳ��
		 totalPage = this.totalCount % pageSize == 0 ? 
				 (this.totalCount / pageSize) : this.totalCount / pageSize + 1;
	System.out.println("��ǰ��ҳ��"+currentPage + "----"+"ҳ���С"+pageSize);
	}
}
