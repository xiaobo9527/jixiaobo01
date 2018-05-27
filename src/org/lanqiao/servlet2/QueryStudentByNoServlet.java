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
		doPost(request, response); // �໥����
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// ������Ҫ��ʾѧ����ѧ��
		int studentNo = Integer.parseInt(request.getParameter("stuNo"));
		// ����ҵ���߼������
		StudentService stuService = new StudentService();
		Student stu = stuService.queryStudengByNo(studentNo);

		// ���鵽��ѧ����Ϣ����request��������
		request.setAttribute("stu", stu);
		request.getRequestDispatcher("queryStudentByNoSuccess.jsp").forward(request, response);
	}
}
