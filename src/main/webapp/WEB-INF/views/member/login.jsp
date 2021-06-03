<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 헤더 불러오기 -->
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/inc/menu.jsp"%>

<div class="login-box">
	<h1>로그인</h1>
	<form method="post" name="frm" action="<c:url value='/member/actionLogin.do'/>">
		<div class="login">
			<input type="text" name="id" placeholder="아이디">
			<input type="password" name="password" placeholder="비밀번호">
			<button type="button" onclick="actionLogin();">로그인</button>
		</div>
		<a href="<c:url value='/member/join.do'/>">회원가입</a>
	</form>
</div>
<script>
	function actionLogin(){
		var frm =document.frm;
		if(frm.id.value == ""){
			alert('ID가 비어있습니다.');
			frm.id.focus();
		}else if(frm.password.value == ""){
			alert('비밀번호가 비어있습니다.');
			frm.password.focus();
		} else{
			frm.submit();
		}
	}
</script>
	<!-- 하단 헤더 불러오기 -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>