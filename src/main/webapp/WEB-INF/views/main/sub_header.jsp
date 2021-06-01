<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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


<script src="../js/jquery-1.12.4.min.js"></script>
<script src="../js/jquery-ui.min.js"></script>

<script src="../js/swiper.min.js"></script>
<link rel="stylesheet" href="../js/swiper.min.css">

<link rel="stylesheet" href="">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- 스크롤시 fixed -->
<script src="../js/autofix.js"></script> <!-- jquery를 먼저 불러와야한다. -->

<!-- fullfage -->
<script src="../js/fullpage.min.js"></script>
<link rel="stylesheet" href="../js/fullpage.min.css">

<link rel="stylesheet" href="../css/style.css">

<!-- 모바일 -->
<link rel="stylesheet" media="screen and (max-width: 480px)" href="../css/480.css">

<!-- 태블릿 세로--> 
<link rel="stylesheet" media="screen and (min-width: 481px) and (max-width: 720px)" href="../css/720.css">

<!-- 태블릿 가로-->
<link rel="stylesheet" media="screen and (min-width: 721px) and (max-width: 1024px)" href="../css/1024.css">
<!-- PC -->
<link rel="stylesheet" media="screen and (min-width: 1025px)" href="../css/pc.css">

</head>

<body>
	<!-- 콘텐츠 시작 -->
	<div class="header">
		<!--로고, 메뉴-->
		<div class="header-box"> <!--스타일을 입힐 수 있는 여지를 줌-->
			<h1><a href="../index.html"><img src="https://www.yuhan-kimberly.co.kr/Images/main2020/common/logo_scroll.png" alt="JinChaeEun"></a></h1>
			<div class="tnb">
				<ul class="tnb"> <!--tnb-->
					<li><a href="../member/login.html">로그인</a></li>
					<li><a href="../member/join.html">회원가입</a></li>
					<!-- 					
					<li><a href="#none">로그아웃</a></li>
					<li><a href="#none">정보수정</a></li>
					 -->				
				</ul>
			</div>
			<div class="gnb"> <!--general navigation bar-->
				<ul>
					<li><a href="../page/intro.html">회사소개</a></li>
					<li><a href="../bbs/notice_list.html">고객센터</a></li>
					<li><a href="../booking/list.html">숲 체험 예약</a></li>
					<li><a href="../booking/mypage.html">예약확인</a></li>
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