<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h3>상세화면(board.jsp)</h3>
<form name = "myFrm" action="removeForm.do">
	<input type="hidden" value="${board.boardNo }" name="bno">
	<input type="hidden" value="${page }" name="page">
	<input type="hidden" value="${searchCondition }" name="searchCondition">
	<input type="hidden" value="${keyword }" name="keyword">
	<table class="table">
		<tr>
			<th class="col-sm-1">글번호</th>
			<td class="col-sm-3"><c:out value="${board.boardNo }" /></td>
			<th class="col-sm-1">조회수</th>
			<td class="col-sm-2"><c:out value="${board.clickCnt }" /></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><c:out value="${board.title }" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea readonly cols="80" rows="3" >${board.content }</textarea>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><c:out value="${board.writer }"/></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.createDate }"/></td>
		</tr>
		<tr align="right">
			<td colspan="3">
				<c:choose>
					<c:when test="${!empty logId && logId == board.writer}">
						<button type="button" class="btn btn-warning">수정 페이지</button>
						<button type="submit" class="btn btn-danger">삭제 페이지</button>
					</c:when>
					<c:otherwise>
						<button type="button" disabled class="btn btn-warning">수정 페이지</button>
						<button type="submit" disabled class="btn btn-danger">삭제 페이지</button>
					</c:otherwise>
				</c:choose>
				<buntton type="button" class="btn btn-primary" 
				onclick="location.href='boardList.do?page=${page}&searchCondition=${searchCondition}&keyword=${keyword}'">목록 이동</buntton>
			</td>
		</tr>

	</table>
</form>
<script>
	document.querySelector('button.btn-warning').addEventListener('click', function(e){
		// 삭제화면이동일 경우에는 removeForm.do
		// 수정화면이동일 경우에는 action="modifyForm.do";
		document.forms.myFrm.action = "modifyForm.do";
		document.forms.myFrm.submit();
	});
	// 삭제화면이동일 경우에는 removeForm.do
	// 수정화면이동일 경우에는 action="modifyForm.do";
	// document.forms.myFrm.action = "modifyForm.do";
	// document.forms.myFrm.submit();
</script>
