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
		request.setCharacterEncoding("UTF-8"); // �����ַ�����
		// response.setContentType("text/html setchar=utf-8");
		// ��ȡ�ύ��������
		// �ύ����Ϣ������String����ʽ�ύ�ģ���ȡint����������Ҫת��Ϊint��������
		 int studentNo = Integer.parseInt(request.getParameter("sno"));
		 System.out.println(studentNo);
		 String studentName = request.getParameter("sname");
		int studentAge = Integer.parseInt(request.getParameter("sage"));
		String gradeName = request.getParameter("gname");

		// �����ݷ�װ��ʵ������
		Student stu = new Student(studentNo, studentName, studentAge, gradeName);

		// �����߼�����룬ʵ������ѧ���Ĺ���
		StudentService stuService = new StudentService();
		boolean result = stuService.addStudent(stu);

		if (result == false) {
			System.out.println("��ʾ---addStudentServlet:����ʧ��");
			// ����ת����addStudent.jspҳ�棺��Ҫ����request�������е����ݣ�����������ת��
			request.getRequestDispatcher("addStudent.jsp").forward(request, response);
			System.out.println("��ת����ҳ��");
		} else {
			System.out.println("��ʾ---addStudentServlet:���ӳɹ�");
			// �ض���addSuccess.jspҳ��
			response.sendRedirect("addSuccess.jsp");
		}

		
			// �����ݷ�װ��ʵ������
			Student stu1 = new Student(studentNo, studentName, studentAge, gradeName);
			// ����ҵ���߼������
			IStudentService stuService1 = new StudentServiceImpl();
			boolean result1 = stuService.addStudent(stu);

		

	}
}
