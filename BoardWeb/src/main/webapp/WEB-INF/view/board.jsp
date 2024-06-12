<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../public/header.jsp"%>
<%
	BoardVO board = (BoardVO) request.getAttribute("board");
	String paging = (String) request.getAttribute("page");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시mm분 ss초");
	String yyymmdd = sdf.format(board.getCreateDate());
%>

<p><%=board %></p>
<table class="table">
	<tr>
		<th class="col-sm-1">글번호</th>
		<td class="col-sm-3"><%=board.getBoardNo() %></td>
		<th class="col-sm-1">조회수</th>
		<td class="col-sm-2"><%=board.getClickCnt() %></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3"><%=board.getTitle() %></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3"><textarea readonly cols="80 rows="3"><%=board.getContent() %></textarea>
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><%=board.getWriter() %></td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td><%=yyymmdd %></td>
	</tr>

</table>
<a href="boardList.do?page=<%=paging %>">목록으로 이동하기</a>
<%@include file="../public/footer.jsp"%>
