<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=cp1251">
<title>Insert title here</title>
<link href="css/table.css" type="text/css" rel="stylesheet">
<link href="bootstrap/bootstrap.min.css" type="text/css" rel="stylesheet">

</head>
<body>
<center><b>Route</b></center>
	<table class="table" border="1px">
		<tr>
			<th>id</th>
			<th>initial Station</th>
			<th>departure</th>
			<th>endStation</th>
			<th>arrival</th>
			<th>остановок</th>
		</tr>
		<tr>
			<td>${requestScope.route.id}</td>
			<td>${requestScope.route.initialStation}</td>
			<td>${requestScope.route.departure}</td>
			<td>${requestScope.route.endStation}</td>
			<td>${requestScope.route.arrival}</td>
			<td>${requestScope.route.generalStation}</td>
			</tr>
			
			<tr>
			<form action="update_route" method="post">
			<td><input type="hidden" name="id" value="${requestScope.route.id}">
			<input type="submit" class="btn btn-warning" value="UPDATE"></td>
			<td><input type="text" name="initial_station" placeholder="above"></td>
			<td><input type="text" name="departure" placeholder="above"></td>
			<td><input type="text" name="finite_station" placeholder="above"></td>
			<td><input type="text" name="arrival" placeholder="above"></td>
			</form>
			</tr>
			
			</table>
			<center><b>Layovers</b></center>
			<table class="table" border="1px">
			<tr class="bottomBorder">
				<th>id</td>
				<th>route_id</th>
				<th>station</th>
				<th>departure</th>
				<th>parking_min</th>
				<th>arrival</th>
				</tr>
			<tr class="bottomBorder">
				<form action="insert_layover_update_redirect" method="post">
				<td>
				<input type="submit" class="btn btn-success btn-sm" value="INSERT">
				<input type="hidden" name="route_id" value="${requestScope.route.id}"></td>
				<td></td>
				<td><input type="text" name="station" placeholder="above"></td>
				<td><input type="text" name="departure" placeholder="above"></td>
				<td><input type="text" name="parking_min" placeholder="above"></td>
				<td><input type="text" name="arrival" placeholder="above"></time></td>
				</form>
			</tr>
			
			<c:forEach items="${requestScope.route.layOvers}" var="element">
				<div>
				<tr>
				<td>${element.layover_id}</td>
				<td>${element.route_id}</td>
				<td>${element.station}</td>
				<td>${element.departure}</td>
				<td>${element.parking_min}</td>
				<td><time>${element.arrivel}</time></td>
				</tr>
				
				<tr class="bottomBorder">
				<form action="update_layover" method="post">
				<td><input type="hidden" name="lo_id" value="${element.layover_id}">
				<input type="hidden" name="route_id" value="${element.route_id}">
			<input type="submit" class="btn btn-warning btn-sm" value="UPDATE"></td>
				<td><a class="btn btn-danger btn-sm bg-dark text-white" onclick="return confirm('Are you really want delete layover?')" href="delete_layover?id=${element.layover_id}&r_id=${element.route_id}" role="button">DELETE</a></td>		<!-- <input type="text" name="route_id" placeholder="above"></td> -->
				<td><input type="text" name="station" placeholder="above"></td>
				<td><input type="text" name="departure" placeholder="above"></td>
				<td><input type="text" name="parking_min" placeholder="above"></td>
				<td><input type="text" name="arrival" placeholder="above"></time></td>
				</form>
				</tr>
				</div>
			</c:forEach>
					
	</table>
	<a href="routes" class="btn btn-info">all routes</a>
</body>
</html>