<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 헤더 불러오기 -->
<jsp:include page="../sub_header.jsp"></jsp:include>
 
<div class="join-box">
	<h1>회원가입</h1>
	<div class="join">
		<span>아이디</span>
		<input type="text" placeholder="아이디">
		
		<span>비밀번호</span>
		<input type="password"  placeholder="비밀번호">
		
		<span>비밀번호 확인</span>
		<input type="password"  placeholder="비밀번호 확인">
		
		<span>이름</span>
		<input type="text" placeholder="이름">

		<span>연락처</span>
		<input type="text" placeholder="연락처">

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
		<a href="<c:url value='/index.do'/>">가입완료</a>
	</div>
</div>
<!-- 하단 헤더 불러오기 -->
 <jsp:include page="../sub_footer.jsp"></jsp:include>
