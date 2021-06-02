<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 헤더 불러오기 -->
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/inc/menu.jsp"%>

<div class="login-box">
	<h1>로그인</h1>
	<div class="login">
		<input type="text" placeholder="아이디">
		<input type="password"  placeholder="비밀번호">
		<button>로그인</button>
	</div>
	<a href="<c:url value='/member/join.do'/>">회원가입</a>
</div>

	<!-- 하단 헤더 불러오기 -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>