<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- publicData.jsp -->
<h3>공공데이터 연습(publicData)</h3>

<!--  검색조건 입력하고 목록에서 출력 -->
<p>sido 정보에서 중복된 값을 제거해서 아래 option태그를 생성하고 검색하기</p>
<p>시도 검색: <select id="changeSido"></select></p>

<input type="text" id="search" class="col-sm-4"
	placeholder="ex)'동구' 입력하고 검색하면 동구를 포함한 목록이 출력 ">
<button id="findBtn">검색</button>

<button id="centerDB">센터DB생성</button>


<table class="table">
	<thead>
		<tr>
			<th>센터id</th>
			<th>센터명</th>
			<th>연락처</th>
			<th>주소</th>
		</tr>
	</thead>
	<tbody id="centerList" >
</table>

<script src="js/public.js"></script>