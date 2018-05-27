<%@page import="org.lanqiao.enity2.Student"%>
<%@page import="com.sun.xml.internal.ws.client.Stub"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除学生页</title>
<style type="text/css">
body {
	width: 400px;
	margin: 250px auto;
	background-size:100%;
	background: url(photo/8.jpg)no-repeat;
    height:40%;
    background-size:100% 100%;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
		<form action=DeleteStudentServlet method="post">
		删除学生的学号：<input type="text" name="stuNo"><br>
		<input type="submit" value="删除">
		</form>
		<a href="QueryAllStudentsServlet">返回首页</a>
</body>
</html>