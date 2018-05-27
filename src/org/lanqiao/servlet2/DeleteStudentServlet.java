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
		request.setCharacterEncoding("UTF-8");	//�����ַ�����
		//��ȡ�ύ��������
		int stuNo = Integer.parseInt(request.getParameter("stuNo"));
		
		StudentService stuService = new StudentService();
		boolean result = stuService.deleteStudentByNo(stuNo);
		
		if(result == false) {
			//result == true��ʾ
			System.out.println("��ʾ---StudentServlet:ɾ��ʧ��");
			
		}else {
			System.out.println("��ʾ---StudentServlet:ɾ���ɹ�");
			request.getRequestDispatcher("deleteSuccess.jsp").forward(request, response);
		}
	}
	
}
