<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="./bootstrap/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="px-3">
<table class="table"><!-- table-bordered -->
<c:forEach items="${routes}" var="element">
    <tr>
       <%--  <td><fmt:formatNumber value="${queryResult.itemId}" minFractionDigits="2"/></td> --%>
       <td>${element.id}</td>
       <td>${element.initialStation}</td>
       <td>${element.departure}</td>
       <td>${element.endStation}</td> 
       <td>${element.arrival}</td>
       <div class="btn-group"> 
       <td><a class="btn btn-primary" href="change_route?id=${element.id}" role="button">CHANGE</a>
       <a class="btn btn-danger" onclick="return confirm('Are you really want delete route?')" href="delete_route_redirect?id=${element.id}" role="button">DELETE</a></td>
      	</div>
       
      </tr><br>
</c:forEach>
</table>
<a class="btn btn-success btn-block" href="admin_views/insert_route.jsp">INSERT</a>
</div>


</body>
</html>