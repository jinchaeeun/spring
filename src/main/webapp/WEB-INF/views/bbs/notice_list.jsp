<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!-- 상단 헤더 불러오기 -->
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/inc/menu.jsp"%>

<div class="snb-wrap">
	<div>
		<ul>
			<li class="on"><a href="<c:url value='/bbs/notice_list.do'/>"><span>공지사항</span></a></li>
			<li><a href="<c:url value='/bbs/free_list.do'/>"><span>자유게시판</span></a></li>
			<li><a href="<c:url value='/bbs/gallery_list.do'/>"><span>갤러리</span></a></li>
		</ul>
	</div>
</div>

<style>

</style>
<div class="notice-wrap">
	<div class="notice-box">
		<div class="search-box">
			<input type="text">
			<button>검색</button>
		</div>

		<ul class="table-hd">
			<li> <!--table-->
				<div class="no">번호</div> <!-- table-cell -->
				<div class="title">제목</div>
				<div class="name">글쓴이</div>
				<div class="date">등록일</div>
			</li>
		</ul>

		<ul class="table-bd">
			<li>
				<div class="no">3</div>
				<div class="title"><a href="<c:url value='/bbs/notice_view.do'/>">크리넥스는 환경을 보호합니다.</a></div>
				<div class="name">크리넥스</div>
				<div class="date">2017.04.03</div>
			</li>
			<li>
				<div class="no">2</div>
				<div class="title"><a href="<c:url value='/bbs/notice_view.do'/>">숲은 마음의 고향입니다</a></div>
				<div class="name">유한</div>
				<div class="date">2017.04.03</div>
			</li>
			<li>
				<div class="no">1</div>
				<div class="title"><a href="<c:url value='/bbs/notice_view.do'/>">숲은 마음의 고향입니다</a></div>
				<div class="name">유한</div>
				<div class="date">2017.04.03</div>
			</li>
		</ul>
	</div>

	<div class="paging">
		<ul>
			<li><a href="#none">처음으로</a></li>
			<li><a href="#none">이전</a></li>
			<li class="on"><a href="#none">1</a></li>
			<li><a href="#none">2</a></li>
			<li><a href="#none">3</a></li>
			<li><a href="#none">다음</a></li>
			<li><a href="#none">마지막</a></li>
		</ul>
	</div>

	<div class="table-btn">
		<a href="<c:url value='/bbs/notice_write.do'/>">글쓰기</a>
	</div>
</div>
	<!-- 하단 헤더 불러오기 -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>