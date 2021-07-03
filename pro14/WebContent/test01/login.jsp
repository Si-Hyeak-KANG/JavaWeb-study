<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
</head>
<body>
	<form action="result.jsp">
		아이디 : <input type="text" size=20 /><br>
		비밀번호 : <input type="password" size=20 /><br>
		<input type="submit" value="로그인"/>
		<input type="reset" value="다시입력" >
	</form>
	<br><br>
	
	<!-- 직접 컨텍스트 이름을 입력해 요청 -->
	<!-- <a href="http://localhost:8091/pro14/test01/memberForm.jsp">회원가입하기</a> --> 
	
	<!-- request의 getContextPath() 메서드를 이용해 -->
	<%-- 
	<a href="<%= request.getContextPath() %>/text01/memberForm.jsp">회원가입하기</a> --%>
	
	<a href="${pageContext.request.contextPath}/test01/memberForm.jsp">회원가입하기</a>
	
</body>
</html>