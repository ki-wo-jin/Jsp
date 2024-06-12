<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../public/header.jsp" %>

<h3>게시판등록</h3>
<%
	String msg = (String) request.getAttribute("message");
%>
<%
	if(msg != null){
%>		
	<p><%=msg %></p>
<%} %>

<form action="boardForm.do">
<table class = "table">
	<tr>
		<th>제목</th><td><input type = "text" name = "title"></td>
	</tr>
	<tr>
		<th>작성자</th><td><input type = "text" name = "writer"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><input type = "text" name = "content"></td>
	</tr>
	<tr>
		<td colspan = "2" align="left"><input type = "submit" class= "btn btn-primary" value="등록"></td>
	</tr>
</table>
</form>

<%@include file="../public/footer.jsp" %>