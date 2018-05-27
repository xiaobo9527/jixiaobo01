package org.lanqiao.servlet2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.enity2.Student;
import org.lanqiao.service.imp2.StudentServiceImpl;
import org.lanqiao.service2.IStudentService;
import org.lanqiao.util.Page;

//��ѯȫ��ѧ��
public class QueryAllStudentsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8"); //�����ַ�����

			// ��ȡǰ̨�����ĵ�ǰҳ�룬��currentPageֵ
			String curPage = request.getParameter("currentPage");
			System.out.println("QueryAllStudentsServlet:curPage-----"+curPage);
			String pageSize = request.getParameter("pageSize");
			System.out.println("QueryAllStudentsServlet:pageSize-----"+pageSize);
			// ���curPageֵΪnull��˵���ǵ�һ�ν����Servlet����curPage��Ϊ��1ҳ
			if (curPage == null) {
				curPage = "1";
			}
			int currentPageNo = Integer.parseInt(curPage);
			// ����ҵ���߼������
			IStudentService stuService = new StudentServiceImpl();
			// ����ܼ�¼��
			int totalCount = stuService.getTotalCount();
			// ��ȡ��ҳ������
			Page pages = new Page();
			// ����ҳ���С����ÿҳ��ʾ������
			if (pageSize!=null) {
				pages.setPageSize(Integer.parseInt(pageSize));
			}else {
				pages.setPageSize(3);
			}
			
			
			// �����ܼ�¼��
			pages.setTotalCount(totalCount);
			// ��ȡ��ҳ��
			int totalpages = pages.getTotalPage();
			// ����ҳ��ĩҳ���п��ƣ�ҳ������С��1��Ҳ���ܴ������һҳ��ҳ��
			if (currentPageNo < 1) {
				currentPageNo = 1;
			} else if (currentPageNo > pages.getTotalPage()) {
				currentPageNo = totalpages;
			}
			// ���õ�ǰҳ��ҳ��
			pages.setCurrentPage(currentPageNo);
			// ����ҵ���߼���ķ���������ȡ��ǰҳ����ȫ��ѧ����Ϣ�ļ���
			List<Student> students = stuService.getStudentsListForCurrentPage(pages.getCurrentPage(), pages.getPageSize());
			// ����ÿҳ��ʾ�ļ���
			pages.setStudents(students);
			// ����ŵ�ǰҳȫ�����ݵĶ���pages������request�������С������÷�ҳ��������ͨ����ҳ������Page�Ķ��������ݵġ�
			request.setAttribute("pages", pages);
			// ��ת����ҳ��ѧ���б�ҳ��
			request.getRequestDispatcher("index.jsp").forward(request, response);
			System.out.println("�ܼ�¼��:"+totalCount);
	}
}
