<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h3>게시판등록</h3>

<form action="boardForm.do">
<table class = "table">
	<tr>
		<th>제목</th><td><input type = "text" name = "title"></td>
	</tr>
	<tr>
		<th>작성자</th><td><input type = "text" name = "writer" value =${logId } readonly></td>
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

