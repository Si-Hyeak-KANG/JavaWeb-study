<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String name = "듀크";
	public String getName() { return name;}
%>
<% String age = request.getParameter("age"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현식 실습</title>
</head>
<body>
	<h1>안녕하세요 <%= name %></h1>
	<h1>나이는 <%= age %>살 입니다.</h1>
	<h1>키는 <%= 180 %> cm입니다.</h1>
	<h1>나이 + 10 은 <%= Integer.parseInt(age) + 10 %>살입니다.</h1>
</body>
</html>