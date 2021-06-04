<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="session" value="${sessionScope.login}" scope="application"/>

<!-- 콘텐츠 시작 -->
<div class="header">
	<!--로고, 메뉴-->
	<div class="header-box">
		<!--스타일을 입힐 수 있는 여지를 줌-->
		<h1>
			<a href="<c:url value='/index.do'/>"><img
				src="https://www.yuhan-kimberly.co.kr/Images/main2020/common/logo_scroll.png"
				alt="YUHAN"></a>
		</h1>
		<div class="tnb">
			<ul class="tnb">
				<!--tnb-->
				<li><a href="#"><c:out value="${session.name}"/></a></li>
				<!-- 로그인이 된 경우 -->
				<c:if test="${not empty session}">
					<li><a href="<c:url value='/member/login.do'/>">로그아웃</a></li>
				</c:if>
				<!-- 로그인이 안된 경우 -->
				<c:if test="${empty session}">
					<li><a href="<c:url value='/member/login.do'/>">로그인</a></li>
				</c:if>
				<li><a href="<c:url value='/member/join.do'/>">회원가입</a></li>
				<!-- 					
				<li><a href="#none">로그아웃</a></li>
				<li><a href="#none">정보수정</a></li>
				 -->
			</ul>
		</div>
		<div class="gnb">
			<!--general navigation bar-->
			<ul>
				<li><a href="<c:url value='/page/intro.do'/>">회사소개</a></li>
				<li><a href="<c:url value='/bbs/notice_list.do'/>">고객센터</a></li>
				<li><a href="<c:url value='/booking/list.do'/>">숲 체험 예약</a></li>
				<li><a href="<c:url value='/booking/mypage.do'/>">예약 확인</a></li>
			</ul>
		</div>

	</div>
</div>

<!--autofix 스크롤 시 fixed 클래스 추가-->
<script>
	$(document).ready(function() {
		$(".header").autofix_anything();
	});
</script>