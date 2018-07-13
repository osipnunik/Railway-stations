<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="bootstrap/bootstrap.min.css" type="text/css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
</head>
<body>
	<script type="text/javascript">
	$(document).ready(function(){
				
		$("input").focus(function(){
		    $(this).css("background-color", "yellow");
		});
	});
	
	
	</script>
	<div class="px-2 bg-success">
		<form action="login" method="post" onmouseover='dos()'>
		<div class="form-group">
			<label for="login">Enter login :</label> 
			<input type="text" name="login" placeholder="login" required id="login" class="form-control">
		</div>
		<div class="form-group">
			<label for="pass">Enter password :</label> 
			<input type="text"
				name="password" placeholder="password" required id="pass" class="form-control">
		</div>
		<input type="submit" class="btn btn-primary" value="Log In">
		<br>
		<a href="register.jsp">register</a>
	</form>
	<br>
	<p>ivan : admin</p>
	<p>igor : user</p>
</div>

</body>
</html>