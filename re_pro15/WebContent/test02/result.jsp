<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="file1" value="${fileList[0]}"/>
<c:set var="file2" value="${fileList[1]}"/>

<title>이미지 파일 출력하기</title>
</head>
<body>
	매개변수 1:
	<c:out value="${file1 }"/><br>
	매개변수 2:
	<c:out value="${file2 }" /><br>
	
	<c:if test="${not empty file1 }">
		<img src="${contextPath }/download2.do?fileName=${file1}" width=300 height=300/> <br>
	</c:if>
	<br>
	<c:if test="${not empty file2 }">
		<img src="${contextPath}/download2.do?fileName=${file2}" width=300 height=300 /> <br>
	</c:if>
	파일 내려받기 : <br>
	<a href="${contextPath }/download2.do?fileName=${file2}">
	   파일 내려받기</a><br>
</body>
</html>