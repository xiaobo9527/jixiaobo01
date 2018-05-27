package org.lanqiao.service2;

import java.util.List;

import org.lanqiao.enity2.Student;

public interface IStudentService {
	
	 // 获取“数据总数”
	 public int getTotalCount();
	    //获取当前页面中全部学生信息的集合
	 public List<Student> getStudentsListForCurrentPage(int currentPage, int pageSize);
	 
}
