<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	/* 자바 주석문 처리입니다.
	String name; 
	public String getName() {return name;}
	*/
%>    

<% 
	String age = request.getParameter("age");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주석처리 실습</title>
</head>
<body>
<!-- HTML 주석문 입니다. -->

	<%-- <%= Integer.parseInt(age)+10 %>    JSP 주석문 처리입니다.--%>
</body>
</html>