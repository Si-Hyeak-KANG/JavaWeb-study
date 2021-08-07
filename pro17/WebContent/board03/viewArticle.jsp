<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 보기</title>
</head>
<body>
	<form name="frmViewArticle" method="post" enctype="multipart/form-data">
		<table border="0" align="center">
		
			<tr>
				<td width="150" align="center" bgcolor="#FF9933">
					글번호
				</td>
				<td>
					<input type="text" value="${article.articleNO}" disabled />
					<input type="hidden" name="articleNO" value="${article.articleNO }"/>
				</td>	
			</tr>
			
			<tr>
				<td width="150" align="center" bgcolo="#FF9933">
					작성자 아이디
				</td>
				<td>
					<input type="text" value="${article.id}" name="id" disabled />
				</td>
			</tr>
			
			<tr>
				<td width="150" align="center" bgcolor="#FF9933">
					제목
				</td>
				<td>
					<input type="text" value="${article.title}" name="title" id="i_title" disabled />
				</td>
			</tr>
			
			<tr>
				<td width="150" align="center" bgcolor="#FF9933">
					내용
				</td>
				<td>
					<textarea rows="20" cols="60" name="content" id="i_content" disabled>${article.content}</textarea>
				</td>
			</tr>
			
			<c:if test="${not empty article.imageFileName && article.imageFileName!='null' }">
				<tr>
					<td width="20%" align="center" bgcolor="#FF9933" rowspan="2" >
						이미지
					</td>
					<td>
						<input type="hidden" name="originalFileName" value="${article.imageFileName}" />
						<img src="${contextPath}/download.do?imageFileName=${article.imageFileName}&articleNO=${article.articleNO}" id="preview" /><br>
					</td>
				</tr>
				<tr>
					<td>
						<input type="file" name="imageFileName" id="i_imageFileName" disabled onchange="readURL(this);"/>
					
					</td>
				</tr>
			</c:if>
			
			<tr>
				<td width="20%" align="center" bgcolor="#FF9933">
					등록일자
				</td>
				<td>
					<input type="text" value="<fmt:formatDate value="${article.writeDate}"/>" disabled />
				</td>
			</tr>
			
			<tr id="tr_btn_modify">
				<td colsapn="2" align="center">
					<input type="button" value="수정하기" onClick="fn_modify_article(frmViewArticle)"/>
					<input type="button" value="취소" onClick="backToList(frmViewArticle)"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>