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

//查询全部学生
public class QueryAllStudentsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8"); //设置字符编码

			// 获取前台传来的当前页码，即currentPage值
			String curPage = request.getParameter("currentPage");
			System.out.println("QueryAllStudentsServlet:curPage-----"+curPage);
			String pageSize = request.getParameter("pageSize");
			System.out.println("QueryAllStudentsServlet:pageSize-----"+pageSize);
			// 如果curPage值为null，说明是第一次进入此Servlet，则将curPage设为第1页
			if (curPage == null) {
				curPage = "1";
			}
			int currentPageNo = Integer.parseInt(curPage);
			// 调用业务逻辑层代码
			IStudentService stuService = new StudentServiceImpl();
			// 获得总记录数
			int totalCount = stuService.getTotalCount();
			// 获取分页帮助类
			Page pages = new Page();
			// 设置页面大小，即每页显示的条数
			if (pageSize!=null) {
				pages.setPageSize(Integer.parseInt(pageSize));
			}else {
				pages.setPageSize(3);
			}
			
			
			// 设置总记录数
			pages.setTotalCount(totalCount);
			// 获取总页数
			int totalpages = pages.getTotalPage();
			// 对首页与末页进行控制：页数不能小于1，也不能大于最后一页的页数
			if (currentPageNo < 1) {
				currentPageNo = 1;
			} else if (currentPageNo > pages.getTotalPage()) {
				currentPageNo = totalpages;
			}
			// 设置当前页的页码
			pages.setCurrentPage(currentPageNo);
			// 调用业务逻辑层的方法，来获取当前页面中全部学生信息的集合
			List<Student> students = stuService.getStudentsListForCurrentPage(pages.getCurrentPage(), pages.getPageSize());
			// 设置每页显示的集合
			pages.setStudents(students);
			// 将存放当前页全部数据的对象pages，放入request作用域中。即采用分页后，数据是通过分页帮助类Page的对象来传递的。
			request.setAttribute("pages", pages);
			// 跳转到首页（学生列表页）
			request.getRequestDispatcher("index.jsp").forward(request, response);
			System.out.println("总记录数:"+totalCount);
	}
}
