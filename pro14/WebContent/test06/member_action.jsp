<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,sec02.ex01.*"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	List membersList = null;
	MemberDAO memberDAO = new MemberDAO();
	String command=(String)request.getParameter("command");

	if(command.equals("addMember")){
		
%>
<jsp:useBean id="m" class="sec02.ex01.MemberBean"/>
<jsp:setProperty name="m" property="*"/>
<%
		memberDAO.addMember(m);
		membersList = memberDAO.listMembers();	
	
	} else if(command.equals("search")) {
		String name = request.getParameter("name");
		MemberBean memberBean = new MemberBean();
		memberBean.setName(name);
		membersList = memberDAO.ListMembers(memberBean);
		
	}

	request.setAttribute("membersList",membersList);
%>	

</head>
<body>
	<!-- member_action.jsp는 화면 기능을 수행하지 않고 데이터베이스 연동 기능만 수행 -->
	
	<jsp:forward page="membersList.jsp"/>
</body>
</html>