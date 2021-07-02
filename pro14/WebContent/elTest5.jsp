<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
<jsp:useBean id="m1" class="sec01.ex01.MemberBean" scope="page" />
<jsp:setProperty name="m1" property="name" value="이순신"/>
<jsp:useBean id="m2" class="java.util.ArrayList" scope="page" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empty 연산자</title>
</head>
<body>
	
	empty 연산자

	<h2>
		\${empty m1 } : ${empty m1 } <br>
		\${not empty m1 } : ${not empty m1} <br><br>
		
		\${empty m2 } : ${empty m2 } <br>
		\${not empty m2 } : ${not empty m2 } <br>
		
		\${empty "hello" } : ${empty "hello" }<br>
		\${empty null} : ${empty null } <br>
		\${empty "" } : ${empty "" } <br>	

	</h2>
</body>
</html>