package org.lanqiao.servlet2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.service2.StudentService;

public class DeleteStudentServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	//设置字符编码
		//获取提交表单的数据
		int stuNo = Integer.parseInt(request.getParameter("stuNo"));
		
		StudentService stuService = new StudentService();
		boolean result = stuService.deleteStudentByNo(stuNo);
		
		if(result == false) {
			//result == true表示
			System.out.println("提示---StudentServlet:删除失败");
			
		}else {
			System.out.println("提示---StudentServlet:删除成功");
			request.getRequestDispatcher("deleteSuccess.jsp").forward(request, response);
		}
	}
	
}
