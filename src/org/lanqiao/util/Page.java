package org.lanqiao.util;

import java.util.List;

import org.lanqiao.enity2.Student;

public class Page {
	// 总页数
	private int totalPage;
	
	// 数据总数，共有多少条数据需要显示
	private int totalCount;
	
	// 页面大小：每一页显示多少数据
	private int pageSize;
	
	// 当前的页码
	private int currentPage;
	
	// 实体类集合;如List<Student> students，用来保存当前页面中全部学生的信息
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

	// 不存在总页数的set方法：总页数是计算出来的，有“数据总数”和“页面大小”计算得出
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		// 计算总页数
		 totalPage = this.totalCount % pageSize == 0 ? 
				 (this.totalCount / pageSize) : this.totalCount / pageSize + 1;
	System.out.println("当前的页码"+currentPage + "----"+"页面大小"+pageSize);
	}
}
