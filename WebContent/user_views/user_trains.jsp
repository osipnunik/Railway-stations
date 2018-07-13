<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../bootstrap/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>
<body>
	<p>some text from user_trains.jsp</p>
		
	<div class="px-3">
<table class="table"><!-- table-bordered -->

<tr>

<!-- <th>route id</th> -->
<th>train number</th>
<th>time of departure</th>
<th>date of departure</th>
<th>departure sation</th>
<th>way time</th>
<th>time of arrival</th>
<th>date of arrival</th>
<th>arrival station</th>
<th>Available compartment seats</th>
<th>Available communal seats</th>
<th>Available seating carriage</th>
<th>cost</th>

</tr>
	<c:forEach items="${trains}" var="element">
    <tr>
       <%--  <td><fmt:formatNumber value="${queryResult.itemId}" minFractionDigits="2"/></td> --%>
       <%-- <td>${element.route.id}</td> it work! --%>
      
       <td>${element.number}</td>
       <td>${element.route.departure}</td>
       <td>${element.departure}</td>
       <td>${element.route.initialStation}</td>
       <td>${element.travel_time}</td>
       <td>${element.route.arrival}</td>
       <td>${element.arrival}</td>
       <td>${element.route.endStation}</td>
       <td>${element.free_coupes}</td>
       <td>${element.free_plats}</td>
       <td>${element.free_general}</td>
       <td>${element.cost}</td>
       <td>
       <a href="see_route?id=${element.route.id}&tr_id=${element.id}">more</a>
         </td>
       
       </tr>
       
       </c:forEach>
       </table>
       </div>
</body>
</html>