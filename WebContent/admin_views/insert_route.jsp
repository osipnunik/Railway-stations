<%@ page language="java" contentType="text/html; charset=Cp1251"
    pageEncoding="Cp1251"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../bootstrap/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	
<center><b>Route</b></center>
	<table class="table" border="1px">
	
		<tr>
			<td>id</td>
			<td>initial Station</td>
			<td>departure</td>
			<td>endStation</td>
			<td>arrival</td>
		</tr>
					
			<tr>
			<form action="insert_route" method="post">
			<td><input type="submit" class="btn btn-warning" value="INSERT" onclick="return alert('You can insert layovers to this route in the next page.')"></td>
			<td><input type="text" name="initial_station" placeholder="above"></td>
			<td><input type="text" name="departure" placeholder="above"></td>
			<td><input type="text" name="finite_station" placeholder="above"></td>
			<td><input type="text" name="arrival" placeholder="above"></td>
			<!-- <td><input type="submit"></td> -->
			</form>
			</tr>
			
			<%-- </table>
			<center><b>Layovers</b></center>
			<table class="table" border="1px">
			<tr>
				<td>${requestScope.route_id }</td>
				<!-- <td>route_id</td> -->
				<td>departure</td>
				<td>parking_min</td>
				<td>arrival</td>
				</tr>
												
				<tr>
				<form action="insert_layover_update_redirect" method="post">
				<td>
				<input type="submit" class="btn btn-success btn-sm" value="INSERT">
					<input type="hidden" name="route_id" value="${requestScope.route_id }"></td>
				<td><input type="text" name="departure" placeholder="above"></td>
				<td><input type="text" name="parking_min" placeholder="above"></td>
				<td><input type="text" name="arrival" placeholder="above"></time></td>
				</form>
				</tr> --%>
			
			<!-- <tr>
			<td><a href="login.jsp?" class="btn btn-info" role="button">Update</a></td>
			</tr> -->
	
	</table>
</body>
</html>