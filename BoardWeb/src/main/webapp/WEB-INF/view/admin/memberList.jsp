<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  memberList.jsp -->
<h3>회원목록(관리자용)</h3>

<table class= "table">
	<!-- 회원아이디/ 이름/ 비밀번호/ 이미지 -->
	<tr>
		<th>회원아이디</th>
		<th>이름</th>
		<th>비밀번호</th>
		<th>이미지</th>
	</tr>
 	<c:forEach var="member" items="${memberList }">
		<tr>
			<td>${member.userId }</td>
			<td>${memeber.userName }</td>
			<td>${member.userPw }</td>
			<td><img width='200px'src="${empty member.image ? '' : 'images/'.concat(member.image) }"></td>
		</tr>
	</c:forEach>
			
		
<%-- 			<c:choose>
				<c:when test="${empty member.image }">
					<img src="">
				</c:when>
				<c:otherwise>
					<img src="images/${member.image }">
				</c:otherwise>
			</c:choose>  --%>

</table>
