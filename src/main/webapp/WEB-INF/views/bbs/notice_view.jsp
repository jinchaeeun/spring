<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 헤더 불러오기 -->
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/inc/menu.jsp"%>
<div class="snb-wrap">
	<div>
		<ul>
			<li class="on"><a href="<c:url value='/bbs/notice_list.do'/>"><span>공지사항</span></a></li>
			<li><a href="<c:url value='/bbs/free_list.do'/>"><span>자유게시판</span></a></li>
			<li><a href="<c:url value='/bbs/gallery_list.do'/>"><span>갤러리</span></a></li>
		</ul>
	</div>
</div>
<div class="contents">

  <div class="notice-wrap">
		<div class="notice-box">
			<div class="bbs-view">
				<div class="view-hd">
					<span class="bbs-view-date">2021-04-16</span>
					<h2>크리넥스는 환경을 보호합니다.</h2>			
					<span>글쓴이: <b>관리자</b></span>
				</div>
				<div class="view-cont">
					<p>크리넥스는 환경 보호 중<br/>열심히 실천 중입니다.</p>
				</div>
				
				<div class="view-file">
					<a href=""><i class="fa fa-download" aria-hidden="true"></i> 첨부파일명.jpg</a>
					<a href=""><i class="fa fa-download" aria-hidden="true"></i> 첨부파일명.jpg</a>
				</div>
			</div>
			<div class="table-btn">
				<a href="<c:url value='/bbs/notice_list.do'/>">목록으로</a>
				<a href="" class="del">삭제</a>
				<a href="" class="mod">수정</a>
			</div>
		</div>
  </div>
</div>
<!--contents 끝-->

	<!-- 하단 헤더 불러오기 -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>