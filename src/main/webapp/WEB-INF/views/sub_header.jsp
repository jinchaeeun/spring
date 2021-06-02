<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <!-- 반응형 (기기 해상도별)-->
  <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0,maximum-scale=1.0, user-scalable=yes">

  <title>jinchaeeun</title>


<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>

<script src="${pageContext.request.contextPath}/js/swiper.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/swiper.min.css">

<script src="${pageContext.request.contextPath}/js/autofix.js"></script> <!-- jquery를 먼저 불러와야한다. -->

<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<!--fullpage-->
<script src="${pageContext.request.contextPath}/js/fullpage.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/fullpage.min.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

<!-- 모바일 -->
<link rel="stylesheet" media="screen and (max-width: 480px)" href="${pageContext.request.contextPath}/css/480.css">

<!-- 태블릿 세로--> 
<link rel="stylesheet" media="screen and (min-width: 481px) and (max-width: 720px)" href="${pageContext.request.contextPath}/css/720.css">

<!-- 태블릿 가로-->
<link rel="stylesheet" media="screen and (min-width: 721px) and (max-width: 1024px)" href="${pageContext.request.contextPath}/css/1024.css">
<!-- PC -->
<link rel="stylesheet" media="screen and (min-width: 1025px)" href="${pageContext.request.contextPath}/css/pc.css">

</head>

<body>
	<!-- 콘텐츠 시작 -->
	<div class="header">
		<!--로고, 메뉴-->
		<div class="header-box"> <!--스타일을 입힐 수 있는 여지를 줌-->
			<h1><a href="<c:url value='/index.do'/>"><img src="https://www.yuhan-kimberly.co.kr/Images/main2020/common/logo_scroll.png" alt="YUHAN"></a></h1>
			<div class="tnb">
				<ul class="tnb"> <!--tnb-->
					<li><a href="<c:url value='/member/login.do'/>">로그인</a></li>
					<li><a href="<c:url value='/member/join.do'/>">회원가입</a></li>
					<!-- 					
					<li><a href="#none">로그아웃</a></li>
					<li><a href="#none">정보수정</a></li>
					 -->				
				</ul>
			</div>
			<div class="gnb"> <!--general navigation bar-->
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
	  $(document).ready( function() {
	     $(".header").autofix_anything();
	  });
		
	</script>