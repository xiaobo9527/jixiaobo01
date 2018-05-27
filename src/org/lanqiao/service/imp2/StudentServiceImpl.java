package org.lanqiao.service.imp2;

import java.util.List;

import org.lanqiao.dao.impl2.StudentDaoImpl;
import org.lanqiao.enity2.Student;
import org.lanqiao.service2.IStudentService;

public class StudentServiceImpl implements IStudentService {
	StudentDaoImpl stuDao = new StudentDaoImpl();

	// 获取“数据总数”
	public int getTotalCount() {
		return stuDao.getTotalCount();
	}

	public List<Student> getStudentsListForCurrentPage(int currentPage, int pageSize) {
		return stuDao.getStudentsListForCurrentPage(currentPage, pageSize);
	}
}
