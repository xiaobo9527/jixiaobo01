<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加学生</title>
<style type="text/css">
body {
	width: 400px;
	margin: 250px auto;
	background-size:100%;
	background: url(photo/5.jpg) no-repeat;
    height:40%;
    background-size:100% 100%;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	  <form action="AddStudentServlet" method="post">
		   学号：<input type="text" name="sno" /><br/>
		   姓名：<input type="text" name="sname" /><br/>
		   年龄：<input type="text" name="sage" /><br/>
		   年级：<input type="text" name="gname" /><br/>
		   <%--上传文件 --%>
		   上传照片：<input type="file" name="sPictrue" />
		   <input type="submit" value="增加" /><br/>
  </form>
	
	
	
</body>
</html>