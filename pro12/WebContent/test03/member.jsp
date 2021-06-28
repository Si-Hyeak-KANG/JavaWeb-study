<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="sec01.ex02.*"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<style>
h1 {
	text-align : center;
}

h2 {
	text-align : center;
	margin-top : 10px;
}
</style>
<meta charset="UTF-8">
<title>회원 정보 출력</title>
</head>
<body>
	<h1>회원 정보 출력</h1>
	
	<%
	request.setCharacterEncoding("utf-8");
	String _name = request.getParameter("name");
	MemberVO memberVO = new MemberVO();
	memberVO.setName(_name);
	
	MemberDAO dao = new MemberDAO();
	
	List ListMembers = dao.ListMembers(memberVO);
	%>	
	


	
	<%
		if(ListMembers.size()!=0) {
	%>		
			<table border='1' width='800' align='center'>
			<tr align='center' bgcolor='#FFFF66'>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>이메일</td>
				<td>가입날짜</td>	
			</tr>
	<% 
			for(int i=0; i<ListMembers.size(); i++) {
				
				MemberVO vo = (MemberVO) ListMembers.get(i);
				String id = vo.getId();
				String pwd = vo.getPwd();
				String name = vo.getName();
				String email = vo.getEmail();
				Date joinDate = vo.getJoinDate();
	%>
	
		<tr align='center'>
			<td><%=id %></td>
			<td><%=pwd %></td>
			<td><%=name %></td>
			<td><%=email %></td>
			<td><%=joinDate %></td>
		</tr>
			
	<%
			}
		} else {
	%>
		<h2>회원 정보가 조회되지 않습니다.</h2>
	<% 	
		}
	%>	
		

	</table>
</body>
</html>