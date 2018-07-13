<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Insert title here</title>
<link href="../bootstrap/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="px-2 bg-success">
		<form action="user_want_station" method="post">
		<div class="form-group">
			<label for="from">Enter start station :</label>
			<input name="from" placeholder="from">
			</div>
			<div class="form-group">
			<label for="to"> Enter end station :</label>
			<input name="to" placeholder="to">
			</div>
			<input type="submit" class="btn btn-primary" value="see possible trains">
		<br><br>
		</form>
	</div>
</body>
</html>