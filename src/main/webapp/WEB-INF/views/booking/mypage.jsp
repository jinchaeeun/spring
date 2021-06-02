<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 헤더 불러오기 -->
<jsp:include page="../sub_header.jsp"></jsp:include>

<div class="notice-wrap">
	<div class="notice-box mypage">
		<h2>예약 확인</h2>
		<div class="search-box">
			<input type="text">
			<button>검색</button>
		</div>
		<div class="table-list mypage-list">
			<ul class="table-hd">
				<li> <!--table-->
					<div class="no">번호</div> <!-- table-cell -->
					<div class="title">제목</div>
					<div class="state">상태</div>
					<div class="name">글쓴이</div>
					<div class="date">등록일</div>
				</li>
			</ul>
		
			<ul class="table-bd">
				<li>
					<div class="no">3</div>
					<div class="title"><a href="<c:url value='/bbs/notice_view.do'/>">크리넥스는 환경을 보호합니다.</a></div>
					<div class="state">승인</div>
					<div class="name">크리넥스</div>
					<div class="date">2017.04.03</div>
				</li>
				<li>
					<div class="no">2</div>
					<div class="title"><a href="<c:url value='/bbs/notice_view.do'/>">숲은 마음의 고향입니다</a></div>
					<div class="state">
						<span class="color01">승인</span>
						<!--
						<span class="color02">대기</span>
						<span class="color03">취소</span>
						<span class="color04">반려</span>
						-->
					</div>
					<div class="name">유한</div>
					<div class="date">2017.04.03</div>
				</li>
				<li>
					<div class="no">1</div>
					<div class="title"><a href="<c:url value='/bbs/notice_view.do'/>">숲은 마음의 고향입니다</a></div>
					<div class="state">승인</div>
					<div class="name">유한</div>
					<div class="date">2017.04.03</div>
				</li>
			</ul>
		</div>
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

</div>
<!-- 하단 헤더 불러오기 -->
 <jsp:include page="../sub_footer.jsp"></jsp:include>