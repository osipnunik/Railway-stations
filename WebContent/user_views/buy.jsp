<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../css/table.css" type="text/css" rel="stylesheet">
<link href="../bootstrap/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
<h1>Buying page</h1>

<p>reqscope:  ${sessionScope.tr_id }</p>
<div class="px-3">
<table class="table"><!-- table-bordered -->
<c:forEach items="${requestScope.carriages}" var="element">
    <tr>
       <th>Carriage number</th>
       <th>type</th>
       <th>seats available</th>
       <th></th>
		</tr>
    <tr>
       <td>${element.id}</td>
       <td>${element.type}</td>
       <td>${element.free_seats}</td>
      <form action="buy_ticket" method="post">
			<td><input type="hidden" name="car_id" value="${element.id}">
			<input type="submit" class="btn btn-warning" onClick=" return confirm('are you sure?')" value="buy"></td>
			<td><input type="text" name="card number" placeholder="card number"></td>
			
			</form>
       
		</tr>
		</c:forEach>
		</table>
</body>
</html>