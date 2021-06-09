<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 헤더 불러오기 -->
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/inc/menu.jsp"%>
	<%@ include file="/WEB-INF/views/bbs/free_submenu.jsp"%>

<div class="notice-wrap">
	<div class="notice-box">
		<h1>자유게시판 글쓰기</h1>
		<div class="bbs-write">
			<ul>
				<li>
					<label for="">제목</label>
					<input type="text" placeholder="제목을 입력해주세요.">
				</li>
				<li>
					<label for="">내용</label>
					<textarea name="" id=""></textarea>
				</li>
				<li class="attachment">
					<label for="">첨부파일 #01</label>
					<input type="file">
				</li>
				<li class="attachment">
					<label for="">첨부파일 #02</label>
					<input type="file">
				</li>

			</ul>
		</div>
		<div class="table-btn">
			<a href="<c:url value='/bbs/free_list.do'/>">이전</a>
			<a href="<c:url value='/bbs/free_list.do'/>">저장</a>
		</div>
	</div>
</div>

	<!-- 하단 헤더 불러오기 -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
