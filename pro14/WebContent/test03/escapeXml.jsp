<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*"
    isELIgnored="false"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<html>
<head>
<meta charset="UTF-8">
<title>escapeXml 실습하기</title>
</head>
<body>
<h2>escapeXml 변환하기</h2>

<pre>
	<c:out value="&lt;" escapeXml="true" /> <!--&lt; 그대로 화면 출력  -->
	<c:out value="&lt;" escapeXml="false"/> <!-- 특수 문자로 변환되어 화면 출력 -->
	
	<c:out value="&gt;" escapeXml="true" />
	<c:out value="&gt" escapeXml="false"/>
</pre>

</body>
</html>