<%@page import="org.lanqiao.enity2.Student"%>
<%@page import="java.util.List"%>
<%@page import="org.lanqiao.util.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息</title>

<style type="text/css">
body {
	width: 400px;
	margin: 250px auto;
	background-size:100%;
	background: url(photo/3.jpg)no-repeat;
    height:40%;
    background-size:100% 100%;
	background-repeat: no-repeat;
}

</style>

<style type="text/css">
table {
	background-color: #87CEEB;
}
</style>
</head>
<body>



	<table border="1" width="150%" align="center">
		<caption>学生信息表</caption>
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>年级</th>

		</tr>

		<%
			//获取带数据的分页帮助类对象
			Page pages = (Page) request.getAttribute("pages");
			//获取页面大小
			int pageSize = pages.getPageSize();
			//总页数
			int totalpages = pages.getTotalPage();
			//当前页的页码
			int pageIndex = pages.getCurrentPage();
			//获取当前页中的学生数据集合

			List<Student> students = pages.getStudents();
			if (students != null) {

				for (Student stu : students) {
		%>
		<tr>
			<td style="text-align:center;vertical-align:middle;"><%= stu.getStudentNo()%></td>
			<td style="text-align:center;vertical-align:middle;"><%= stu.getStudentName()%></td>
			<td style="text-align:center;vertical-align:middle;"><%= stu.getStudentAge()%></td>
			<td style="text-align:center;vertical-align:middle;"><%= stu.getGradeName()%></td>

		</tr>
		<%
			}
			}
		%>
	</table>
	<br> 当前页数：[<%=pageIndex%>/<%=totalpages%>]
	<%
		//只要不是首页，则都可以点击“首页”和“上一页”
		if (pageIndex > 1) {
	%>
	<%-- 通过用户点击超链接，将页码传递给Servlet --%>
	<a href="QueryAllStudentsServlet?currentPage=1&&pageSize=<%=pageSize%>">首页</a>&nbsp;
	<a href="QueryAllStudentsServlet?currentPage=<%=pageIndex - 1%>&&pageSize=<%=pageSize%>">上一页</a>
	<%
		}
		//只要不是末页，则都可以点击“下一步”和“末页”
		if (pageIndex < totalpages) {
	%>
	<%-- 通过用户点击超链接，将页码传递给Servlet --%>
	<a href="QueryAllStudentsServlet?currentPage=<%=pageIndex + 1%>&&pageSize=<%=pageSize%>">下一页</a>
	<a href="QueryAllStudentsServlet?currentPage=<%=totalpages%>&&pageSize=<%=pageSize%>">末页</a>
	<%
		}
	%>

	<form action="QueryAllStudentsServlet" method="post">
		每页显示数据条数：<input type="text" name="pageSize"value="<%out.print(pageSize);%>"> 
		<input type="submit"value="确定">
	</form>

	<br>
	<a href="addStudent.jsp">增加</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="queryStudentByNo.jsp">查询</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="deleteStudentByNo.jsp">删除</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="updateStudent.jsp">修改</a>
	<br>
</body>
</html>