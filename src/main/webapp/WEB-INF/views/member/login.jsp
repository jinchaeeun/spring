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
			<button type="button" onclick="actionLoginAsync();">로그인</button>
		</div>
		<a href="<c:url value='/member/join.do'/>">회원가입</a>
	</form>
</div>
<script>

var msg = '<c:out value="${msg}"/>';
if (msg != ''){
	alert(msg);
}

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
	
	function actionLoginAsync(){
		var id = document.frm.id.value;
		var password = document.frm.password.value;
		
		console.log("id = " + id + ", password = " + password);
		
		//join.jsp의 checkID()를 참고하여 ajax로 로그인 처리
		//성공하면 href.location = '<c:out value="index.do"/>';
		//실패하면 alert('로그인에 실패하였습니다.');
		
		$.ajax({
			type: "POST",
			url: "<c:url value='/member/actionLoginAsync.do'/>",
			dataType: "JSON",
			data: {"id": id, "password": password},
			success : function(data){
				console.log(data);
				if(data.login == true){
					location.href = "<c:url value='/index.do'/>";
				}else{
					alert('로그인에 실패하였습니다.');
				}
			},
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
			}
			
		})
		
	}
</script>
	<!-- 하단 헤더 불러오기 -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>