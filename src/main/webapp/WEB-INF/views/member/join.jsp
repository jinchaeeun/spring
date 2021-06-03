<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 헤더 불러오기 -->
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/inc/menu.jsp"%>
	
<div class="join-box">
	<h1>회원가입</h1>
	
    <form method="post" name="frm" action="<c:url value='/member/joinInsert.do'/>">
		<div class="join">
			<span>아이디</span>
			<input type="text" name="id" placeholder="아이디"><a href="javascript:checkId();">중복확인</a>
			
			<span>비밀번호</span>
			<input type="password" name="password" placeholder="비밀번호">
			
			<span>비밀번호 확인</span>
			<input type="password"  placeholder="비밀번호 확인">
			
			<span>이름</span>
			<input type="text" name="name" placeholder="이름">
	
			<span>연락처</span>
			<input type="text" name="phone" placeholder="연락처">
	
			<span>생년월일</span>						
			<input type="text" placeholder="생년월일">
			
			<span>성별</span>
			<div class="gender">
				<label for>남</label>
				<input type="radio" name="chk_gender" value="M">
				<label for>여</label>
				<input type="radio" name="chk_gender" value="W">
			</div>
			
			<span>직업</span>
			<select name id>
				<option value>학생</option>
				<option value>회사원</option>
				<option value>기타</option>
			</select>
			
			<span>주소</span>
			<div class="addr">
				<input type="text">
				<button>검색</button>
			</div>
			<input type="text" placeholder="기본주소">
			<input type="text" placeholder="상세주소">
		</div>
		
		<div class="button">
			<a href="<c:url value='/index.do'/>">이전</a>
			<a href="#" onclick="document.frm.submit();">가입완료</a>
		</div>
	</form>
	</div>

<script>
var msg = '<c:out value="${msg}"/>';
if (msg != ''){
	alert(msg);
}

function checkId(){
	var id = document.frm.id.value;
	
	$.ajax({
		type: "POST",
		url: "<c:url value='/member/checkId.do'/>",
		dataType: "JSON",
		data: {"id": id},
		success : function(data){
			console.log(data);
			if(data.duplicate == true){
				alert("이미 가입된 ID입니다.");
			}else{
				alert("가입 가능한 ID입니다.");
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