package org.lanqiao.servlet2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.enity2.Student;
import org.lanqiao.service2.StudentService;

public class UpdateStudentServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	//两种处理方式相互调用
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	//设置字符编码格式
		//接受需要修改学生的信息
		int studentNo = Integer.parseInt(request.getParameter("sno"));
		String studentName = request.getParameter("sname");
		int studentAge = Integer.parseInt(request.getParameter("sage"));
		String gradeName = request.getParameter("gname");
		
		//将学生信息封装到JavaBean的实体类中
		Student student = new Student(studentNo,studentName,studentAge,gradeName);
		
		// 调用业务逻辑层代码，实现修改
		StudentService stuService = new StudentService();
		boolean result = stuService.updateStudent(student, studentNo);
		
		//判断修改是否成功
		if(result == false) {
			System.out.println("UpdateStudentServlet:修改失败");
			request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
		}
		System.out.println("UpdateStudentServlet:修改成功");
		response.sendRedirect("updateSuccess.jsp");
	}

}
