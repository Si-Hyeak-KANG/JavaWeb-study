<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,sec02.ex01.*"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:useBean id="m" class="sec02.ex01.MemberBean"/>
<jsp:setProperty name="m" property="*"/>
<%
	MemberDAO memberDAO = new MemberDAO();
	memberDAO.addMember(m);
	List membersList = memberDAO.listMembers();
	request.setAttribute("membersList",membersList);
%>
</head>
<body>
	<!-- member_action.jsp는 화면 기능을 수행하지 않고 데이터베이스 연동 기능만 수행 -->
	
	<jsp:forward page="membersList.jsp"/>
</body>
</html>