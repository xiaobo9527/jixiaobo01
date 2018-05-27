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
		doPost(request, response);	//���ִ���ʽ�໥����
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	//�����ַ������ʽ
		//������Ҫ�޸�ѧ������Ϣ
		int studentNo = Integer.parseInt(request.getParameter("sno"));
		String studentName = request.getParameter("sname");
		int studentAge = Integer.parseInt(request.getParameter("sage"));
		String gradeName = request.getParameter("gname");
		
		//��ѧ����Ϣ��װ��JavaBean��ʵ������
		Student student = new Student(studentNo,studentName,studentAge,gradeName);
		
		// ����ҵ���߼�����룬ʵ���޸�
		StudentService stuService = new StudentService();
		boolean result = stuService.updateStudent(student, studentNo);
		
		//�ж��޸��Ƿ�ɹ�
		if(result == false) {
			System.out.println("UpdateStudentServlet:�޸�ʧ��");
			request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
		}
		System.out.println("UpdateStudentServlet:�޸ĳɹ�");
		response.sendRedirect("updateSuccess.jsp");
	}

}
