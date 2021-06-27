
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="jakarta.servlet.RequestDispatcher"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name","이순신");
	request.setAttribute("address","서울시 강남구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 내장 객체 1</title>
</head>
<body>

	<% 
		RequestDispatcher dispatch = request.getRequestDispatcher("request2.jsp");
		dispatch.forward(request, response);
	%>
</body>
</html>