<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>

 <style type="text/css">
    body{ 
    width:300px;
	margin:300px auto;
	
background:url(photo/login.jpg); 

background-repeat:no-repeat; 
background-size:100%;
} 
  </style>

</head>
<body>


<form action="LoginServlet" method="post">
用户名：<input type="text" name="uname"><br>
密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="upwd"><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" value="登录"></form>

</body>
</html>