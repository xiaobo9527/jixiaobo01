package org.lanqiao.servlet2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.enity2.User;
import org.lanqiao.service2.UserService;

public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");

		User user = new User(uname, upwd);

		UserService service = new UserService();
		// ͨ��username ȥ����user����
		User user2 = service.findUserByUsername(uname);
		System.out.println("loginSerrvlet����");
		if (user2 != null) {
			if (user2.getPassword().equals(upwd)) {
				// ��¼�ɹ�
				// ��ʾȫ��ѧ����Ϣ
				request.getRequestDispatcher("QueryAllStudentsServlet").forward(request, response);
			}
		} else {
			// ��¼ʧ�ܣ��������ص���¼����
			response.sendRedirect("login.jsp");
		}
	}

}
