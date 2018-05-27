<%@page import="org.lanqiao.util.Page"%>
<%@page import="org.lanqiao.enity2.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息显示页</title>
</head>
<body>
<% List<Student> stus =(List<Student>) request.getAttribute("stus");%>
<table border="1" width="50%">
		<caption>学生信息表</caption>
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>年级</th>
			<th>操作</th>
		</tr>
		<%
			if (stus != null) {
				for (int i = 0; i < stus.size(); i++) {
					out.print("<tr>");
					out.print("<td>" + stus.get(i).getStudentNo() + "</td>");
					out.print("<td>" + stus.get(i).getStudentName() + "</td>");
					out.print("<td>" + stus.get(i).getStudentAge() + "</td>");
					out.print("<td>" + stus.get(i).getGradeName() + "</td>");
					out.print("<td><a href='DeleteStudentServlet?stuNo=" + stus.get(i).getStudentNo()
							+ "'>删除  </a> <a href='updateStudent.jsp?stuNo=" + stus.get(i).getStudentNo()
							+ "'>修改</a></td>");
					out.print("</tr>");
				}
			}
		%>
	</table>

	<br><br>
	<a href="addStudent.jsp">增加学生</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="queryStudentByNo.jsp">查询学生</a><br>

      
    
</body>
</html>