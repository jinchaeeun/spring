<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 게시판 서브메뉴 -->
<div class="snb-wrap">
	<div>
		<ul>
			<li class="on"><a href="<c:url value='/bbs/notice_list.do'/>"><span>공지사항</span></a></li>
			<li><a href="<c:url value='/bbs/free_list.do'/>"><span>자유게시판</span></a></li>
			<li><a href="<c:url value='/bbs/gallery_list.do'/>"><span>갤러리</span></a></li>
		</ul>
	</div>
</div>