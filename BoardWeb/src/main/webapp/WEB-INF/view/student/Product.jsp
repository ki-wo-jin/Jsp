<%@page import="co.yedam.vo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <!-- webapp/WEB-INF/view/product.jsp -->
  <h3>Product 페이지</h3>
  <table border = "2">
  	<tr>
  		<th>학생번호</th><td><c:out value = "${student.StdNo }"/></td>
  	</tr>
  	<tr>
  		<th>학생이름</th><td><c:out value = "${student.StdName }"/></td>
  	</tr>
  	 <tr>
  		<th>연락처</th><td><c:out value = "${student.Phone }"/></td>
  	</tr>
  	 <tr>
  		<th>혈액형</th><td><c:out value = "${student.bldType }"/></td>
  	</tr>
  	
  	<a href="main.do">목록보기</a>
  </table>
</body>
</html>