<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	int score = Integer.parseInt(request.getParameter("score")); //입력창에 숫자를 입력해도 문자열로 전송 -> parse 를 이용해 변환
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점 출력창</title>
</head>
<body>
	<h1>시험 점수 <%= score %>점</h1>
<%
	if(score >= 90) {
%>
		<h1> A학점입니다.</h1>
<%
	}else if(score >= 80 && score < 90) {
%>
		<h1> B학점입니다. </h1>
<%
	}else if(score >= 70 && score < 70) {
%>
		<h1> C학점입니다.</h1>
<%
	}else {
%>
		<h1> F학점입니다.</h1>
<%
	}
%>
	<br>
	<a href='scoreTest.html'>다시 입력하기</a>
</body>
</html>