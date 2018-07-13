<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="bootstrap/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="px-2">
		<form action="register" method="post">
		<div class="form-group">
			<label for="login">Enter login :</label> 
			<input type="text" name="login" placeholder="login" id="login" class="form-control">
		</div>
		<div class="form-group">
			<label for="pass">Enter password :</label> 
			<input type="text"
				name="pass" placeholder="password" id="pass" class="form-control">
		</div>
		<div class="form-group">
			<label for="role">admin :</label> 
			<input type="checkbox" name="role" id="role">
		</div>
		<div class="form-group">
			<label for="name">Enter your name :</label> 
			<input type="text"
				name="name" placeholder="name" id="name" class="form-control">
		</div>
					
		<input type="submit" class="btn btn-primary" value="register">
		<br>
		<a href="login.jsp">go to login page</a>
	</form>
	</div>
</body>
</html>