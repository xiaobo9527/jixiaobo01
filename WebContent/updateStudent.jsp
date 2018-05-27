<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改学生信息</title>
<style type="text/css">
body {
	width: 400px;
	margin: 250px auto;
	background: url(photo/11.jpg)no-repeat;
    height:40%;
    background-size:100% 100%;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<h3>学生的学号不可修改</h3>
	<form action="UpdateStudentServlet" method="post">
	
	需要修改学生的学号：<input type="text" name="sno"><br>
	将学生的姓名修改为：<input type="text" name="sname"><br>
	将学生的年龄修改为：<input type="text" name="sage"><br>
	将学生的年级修改为：<input type="text" name="gname"><br>
	<input type="submit" value="提交修改">
	</form>
</body>
</html>