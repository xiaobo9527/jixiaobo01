<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>根据学号查询某一学生</title>
<style type="text/css">
body {
	width: 400px;
	margin: 250px auto;
	background-size:100%;
	background: url(photo/9.jpg)no-repeat;
    height:40%;
    background-size:100% 100%;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
<form action="QueryStudentByNoServlet" method="post">
	查询学生的学号：<input type="text" name="stuNo"><br>
	<input type="submit" value="查询">


</form>
</body>
</html>