<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 헤더 불러오기 -->
<jsp:include page="../sub_header.jsp"></jsp:include>

<div class="snb-wrap">
	<div>
		<ul>
			<li class="on"><a href="<c:url value='/bbs/notice_list.do'/>"><span>공지사항</span></a></li>
			<li><a href="<c:url value='/bbs/free_list.do'/>"><span>자유게시판</span></a></li>
			<li><a href="<c:url value='/bbs/gallery_list.do'/>"><span>갤러리</span></a></li>
		</ul>
	</div>
</div>

<div class="notice-wrap">
	<div class="notice-box">
		<h1>공지사항 글쓰기</h1>
		<div class="bbs-write">
			<ul>
				<li>
					<label for="">제목</label>
					<input type="text" placeholder="제목을 입력해주세요.">
				</li>
				<li>
					<label for="">내용</label>
					<textarea name="" id=""></textarea>
				</li>
				<li class="attachment">
					<label for="">첨부파일 #01</label>
					<input type="file">
				</li>
				<li class="attachment">
					<label for="">첨부파일 #02</label>
					<input type="file">
				</li>
				<li class="checkbox-wrap">
					<label for="">공지 선택 &nbsp</label>
					<input type="checkbox" id="chk-notice">
					<label for="chk-notice" class="check-txt"> &nbsp선택 시 공지사항</label>
				</li>

			</ul>
		</div>
		<div class="table-btn">
			<a href="<c:url value='/bbs/notice_list.do'/>">이전</a>
			<a href="<c:url value='/bbs/notice_list.do'/>">저장</a>
		</div>
	</div>
</div>

<!-- 하단 헤더 불러오기 -->
 <jsp:include page="../sub_footer.jsp"></jsp:include>