<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 헤더 불러오기 -->
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/inc/menu.jsp"%>
	<%@ include file="/WEB-INF/views/bbs/free_submenu.jsp"%>
<div class="contents">

  <div class="notice-wrap">
		<div class="notice-box">
			<div class="bbs-view">
				<div class="view-hd">
					<span class="bbs-view-date"><c:out value='${freeVO.date}'/></span>
					<h2><c:out value='${freeVO.subject}'/></h2>			
					<span>글쓴이: <b><c:out value='${freeVO.writer}'/></b></span>
				</div>
				<div class="view-cont">
					<p><c:out value='${freeVO.contents}'/>
					</p>
				</div>
				
				<c:if test= "${not empty freeVO.oriFilename}">
					<div class="view-file">
						<a href="<c:url value='/bbs/notice_downloadFile.do'/>?seq=${freeVO.seq}"><i class="fa fa-download" aria-hidden="true"></i>${freeVO.oriFilename}</a>
						<!-- 
						<a href=""><i class="fa fa-download" aria-hidden="true"></i> 첨부파일명.jpg</a>
						 -->
					</div>
				</c:if>
			</div>
			<div class="table-btn">
				<a href="<c:url value='/bbs/free_modify.do'/>?seq=${freeVO.seq}" class="mod">수정</a>
				<a href="#" class="del" onclick="javascript:confirmDelete();">삭제</a>
				<a href="<c:url value='/bbs/free_list.do'/>">목록으로</a>
			</div>
		</div>
  </div>
</div>
<!--contents 끝-->

	<!-- 하단 헤더 불러오기 -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
<script>
	function confirmDelete(){
		if(confirm('삭제하시겠습니까?')==true){
			location.href = '<c:url value="/bbs/free_delete.do"/>?seq=${freeVO.seq}';
		}
	}
</script>