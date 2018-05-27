package org.lanqiao.dao2;

import java.util.List;

import org.lanqiao.enity2.Student;

public interface  IStudentDao {
	 // 获取“数据总数”
	 public int getTotalCount();
	 // 获取“当前页面中全部学生信息的集合”，用来给Page中的集合属性students赋值;currentPage表示当前页的页码，pageSize表示页面大小
	 public List<Student> getStudentsListForCurrentPage(int currentPage, int pageSize);
}
