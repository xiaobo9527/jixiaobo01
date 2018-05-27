package org.lanqiao.servlet2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.enity2.Student;
import org.lanqiao.service2.StudentService;

public class QueryStudentByNoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response); // 相互调用
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 接收需要显示学生的学号
		int studentNo = Integer.parseInt(request.getParameter("stuNo"));
		// 调用业务逻辑层代码
		StudentService stuService = new StudentService();
		Student stu = stuService.queryStudengByNo(studentNo);

		// 将查到的学生信息放入request作用域中
		request.setAttribute("stu", stu);
		request.getRequestDispatcher("queryStudentByNoSuccess.jsp").forward(request, response);
	}
}
