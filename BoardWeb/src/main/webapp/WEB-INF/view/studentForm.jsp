<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../public/header.jsp" %>
<h3>학생등록화면</h3>
<%
	String msg = (String) request.getAttribute("message");
%>
<%
	if(msg != null){
%>		
	<p><%=msg %></p>
<%} %>

<form action="addStudent.do">
<table class = "table">
	<tr>
		<th>학생번호</th><td><input type = "text" name = "sno"></td>
	</tr>
	<tr>
		<th>학생이름</th><td><input type = "text" name = "sname"></td>
	</tr>
	<tr>
		<th>연락처</th><td><input type = "text" name = "phone"></td>
	</tr>
	<tr>
		<th>혈액형</th><td><input type = "text" name = "btype"></td>
	</tr>
	<tr>
		<td colspan = "2" align="left"><input type = "submit" class= "btn btn-primary" value="저장"></td>
	</tr>
</table>
</form>
<%@include file="../public/footer.jsp" %>