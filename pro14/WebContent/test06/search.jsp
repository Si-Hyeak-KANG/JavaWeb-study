<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,sec02.ex01.*"
    isELIgnored="false"
    %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<c:set var="contextName" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 검색창</title>
</head>
<body>
	<form method="post" action="member_action.jsp">
		<input type="hidden" name="command" value="search"/>
		이름:<input type="text" name="name"><br>
		<input type="submit" value="조회하기">
	</form>
	<a href="${contextName}/test06/memberForm.jsp">회원가입</a>
</body>
</html>