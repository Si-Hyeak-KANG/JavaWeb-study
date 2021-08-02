<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드창</title>
</head>
<body>
	<form action="${contextPath }/upload2.do" method="post" enctype="multipart/form-data">
		
		파일1: <input type="file" name="file1"><br>
		파일2: <input type="file" name="file2"><br>
		매개변수1: <input type="text" name="param1"><br>
		매개변수2: <input type="text" name="param2"><br>
		매개변수3: <input type="text" name="param3"><br>
	<input type="submit" value="업로드">
	</form>
</body>
</html>