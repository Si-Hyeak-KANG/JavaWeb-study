<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharcterEncoding("utf-8");
%>

<html>
<head>
<meta charset="UTF-8">
<title>JSTL 다국어 기능</title>
</head>
<body>
<%-- 
	<fmt:setLocale value="en_US" /> <!-- locale을 영어로 지정 -->
--%>	
	<fmt:setLocale value="ko_KR" /> <!-- locale을 한글로 지정 -->
	
	<h1>
		회원정보 <br><br>
		<fmt:bundle basename="resource.member" > <!-- resource 패키지 아래 member 프로퍼티 파일을 읽어옴 -->
		<!-- <fmt:message 태그의 key 속성에 프로퍼티 파일의 key를 지정하여 값(value)을 출력 -->
		이름 :<fmt:message key="men.name" /><br>
		주소 :<fmt:message key="men.address"/><br>
		직업 :<fmt:message key="men.job" />
		</fmt:bundle>
	</h1>
</body>
</html>