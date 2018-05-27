package org.lanqiao.servlet2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.lanqiao.enity2.Student;
import org.lanqiao.service.imp2.StudentServiceImpl;
import org.lanqiao.service2.IStudentService;
import org.lanqiao.service2.StudentService;

public class AddStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 设置字符编码
		// response.setContentType("text/html setchar=utf-8");
		// 获取提交表单的数据
		// 提交的信息都是以String的形式提交的，获取int类型数据需要转化为int类型数据
		 int studentNo = Integer.parseInt(request.getParameter("sno"));
		 System.out.println(studentNo);
		 String studentName = request.getParameter("sname");
		int studentAge = Integer.parseInt(request.getParameter("sage"));
		String gradeName = request.getParameter("gname");

		// 将数据封装到实体类中
		Student stu = new Student(studentNo, studentName, studentAge, gradeName);

		// 调用逻辑层代码，实现增加学生的功能
		StudentService stuService = new StudentService();
		boolean result = stuService.addStudent(stu);

		if (result == false) {
			System.out.println("提示---addStudentServlet:增加失败");
			// 请求转发到addStudent.jsp页面：需要传递request作用域中的数据，所以用请求转发
			request.getRequestDispatcher("addStudent.jsp").forward(request, response);
			System.out.println("跳转增加页面");
		} else {
			System.out.println("提示---addStudentServlet:增加成功");
			// 重定向到addSuccess.jsp页面
			response.sendRedirect("addSuccess.jsp");
		}

		
			// 将数据封装到实体类中
			Student stu1 = new Student(studentNo, studentName, studentAge, gradeName);
			// 调用业务逻辑层代码
			IStudentService stuService1 = new StudentServiceImpl();
			boolean result1 = stuService.addStudent(stu);

		

	}
}
