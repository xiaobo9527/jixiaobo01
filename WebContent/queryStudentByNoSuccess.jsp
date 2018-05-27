<%@page import="org.lanqiao.enity2.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询成功</title>
<style type="text/css">
body {
	width: 400px;
	margin: 250px auto;
	background-size:100%;
	background: url(photo/10.jpg)no-repeat;
    height:40%;
    background-size:100% 100%;
	background-repeat: no-repeat;
}
</style>

</head>
<body border="1" width="150%" align="center">
<%
	Student stu = (Student)request.getAttribute("stu");
%>
	  
	<table border="1" width="50%">
	<caption>学生信息表</caption>
	<tr>
	<th>学号</th><th>姓名</th><th>年龄</th><th>年级</th>
	<%
	out.print("<tr>");
	out.print("<td>"+stu.getStudentNo()+"</td>");
	out.print("<td>"+stu.getStudentName()+"</td>");
	out.print("<td>"+stu.getStudentAge()+"</td>");
	out.print("<td>"+stu.getGradeName()+"</td>");
	out.print("</tr>");
	
	%>
	</table>
	
	
	<br>
	<a href="QueryAllStudentsServlet">返回首页</a>
</body>
</html>