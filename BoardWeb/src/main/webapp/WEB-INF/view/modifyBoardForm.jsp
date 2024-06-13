<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../public/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h3>수정화면(modifyBoardForm.jsp)</h3>
<form name = "myFrm" action="modifyBoard.do">
	<input type="hidden" value="${board.boardNo }" name="bno">
	<table class="table">
		<tr>
			<th class="col-sm-1">글번호</th>
			<td class="col-sm-3"><c:out value="${board.boardNo }"/></td>
			<th class="col-sm-1">조회수</th>
			<td class="col-sm-2"><c:out value="${board.clickCnt }"/></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input type="text" value = "${board.title }" name = "title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea class="form-control" name = "content">
			<c:out value="${board.content }"/>
			</textarea>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3"><input type="text" readonly value = "${board.writer }" name="writer"></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.createDate }"/></td>
		</tr>
		<tr align="right">
			<td colspan="4">
				<button type="submit" class="btn btn-warning">수정처리</button>
			</td>
		</tr>

	</table>
</form>
<a href="boardList.do?page=${page }">목록으로 이동하기</a>
<jsp:include page="../public/footer.jsp" />