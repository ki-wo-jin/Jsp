<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>회원가입화면(SignUpForm.jsp)</h3>
<myTag:line/>
<!--  JSP standard tag library -->

<form action="signUp.do" style="width:350px">
	<table class="table" border="1">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="pw"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr style="text-align: center;">
			<td colspan="2"><input type="submit" value="가입하기"></td>
		</tr>
	</table>
</form>

