<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
    
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

<style>

</style>
<form method="get" name="frm" action="<c:url value='/bbs/notice_list.do'/>">
<div class="notice-wrap">
	<div class="notice-box">
		<div class="search-box">
			<input type="text" name="searchKeyword" value="${searchVO.searchKeyword}"> <!-- value를 줘서 값을 유지하면서 넘어가게  -->
			<button onclick="javascript:fn_requestList(1);">검색</button>
		</div>

		<ul class="table-hd">
			<li> <!--table-->
				<div class="no">번호</div> <!-- table-cell -->
				<div class="title">제목</div>
				<div class="name">글쓴이</div>
				<div class="date">등록일</div>
			</li>
		</ul>
		<!-- 반복 뿌림 부분 -->
		<c:forEach var="noticeVO" items="${noticeVOList}" varStatus="status"> <!-- varStatus는 현재 몇개 값인지 -->
			<ul class="table-bd">
				<li>
					<div class="no"><c:out value="${paginationInfo.totalRecordCount - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index)}"/></div>
					<div class="title"><a href="<c:url value='/bbs/notice_view.do'/>"><c:out value="${noticeVO.subject}"/></a></div>
					<div class="name"><c:out value="${noticeVO.writer}"/></div>
					<div class="date"><c:out value="${noticeVO.date}"/></div>
				</li>
			</ul>
		</c:forEach>

	</div>
	
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${paginationInfo}" type="myImage" jsFunction="fn_requestList"/>
			<input type="hidden" name="pageIndex" value="<c:url value='${searchVO.pageIndex}'/>"/>
		</ul>
	</div>

	<div class="table-btn">
		<a href="<c:url value='/bbs/notice_write.do'/>">글쓰기</a>
	</div>
</div>
</form>

<script>
	function fn_requestList(pageNo){
		console.log(pageNo);
		document.frm.pageIndex.value = pageNo;
		document.frm.submit();
	}
</script>
	<!-- 하단 헤더 불러오기 -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>