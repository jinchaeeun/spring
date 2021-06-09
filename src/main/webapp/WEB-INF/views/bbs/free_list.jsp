<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- 상단 헤더 불러오기 -->
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/inc/menu.jsp"%>
	<%@ include file="/WEB-INF/views/bbs/free_submenu.jsp"%>
	
<form method="get" name="frm" action="<c:url value='/bbs/free_list.do'/>">
<div class="notice-wrap">
	<div class="notice-box">
		<div class="search-box">
			<input type="text" name="searchKeyword" value="${searchVO.searchKeyword}">
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
		<c:forEach var="freeVO" items="${freeVOList}" varStatus="status"> <!-- varStatus는 현재 몇개 값인지 -->
			<ul class="table-bd">
				<li>
					<div class="no"><c:out value="${paginationInfo.totalRecordCount - ((paginationInfo.currentPageNo-1) * paginationInfo.recordCountPerPage + status.index)}"/></div>
					<div class="subject"><a href="<c:url value='/bbs/free_view.do'/>?seq=${freeVO.seq}"><c:out value="${freeVO.subject}"/></a></div>
					<div class="name"><c:out value="${freeVO.writer}"/></div>
					<div class="date"><c:out value="${freeVO.date}"/></div>
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
		<a href="<c:url value='/bbs/free_write.do'/>">글쓰기</a>
	</div>
</div>
</form>
	<!-- 하단 헤더 불러오기 -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
	
<script>
	function fn_requestList(pageNo){
		console.log(pageNo);
		document.frm.pageIndex.value = pageNo;
		document.frm.submit();
	}
</script>
