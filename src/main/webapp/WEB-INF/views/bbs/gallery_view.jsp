<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 헤더 불러오기 -->
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/inc/menu.jsp"%>
	<%@ include file="/WEB-INF/views/bbs/gallery_submenu.jsp"%>
<div class="contents">

  <div class="notice-wrap">
		<div class="notice-box">
			<div class="bbs-view">
				<div class="view-hd">
					<span class="bbs-view-date"><c:out value='${galleryVO.date}'/></span>
					<h2><c:out value='${galleryVO.subject}'/></h2>			
					<span>글쓴이: <b>${galleryVO.writer}</b></span>
				</div>
				<div class="view-cont">
					<div class="view-thum">
						<img src="<c:url value='/bbs/gallery_image.do'/>?seq=${galleryVO.seq}">
					</div>
					<p><c:out value='${galleryVO.contents}'/>
					</p>
				</div>
				
				<c:if test= "${not empty galleryVO.oriFilename}">
					<div class="view-file">
						<a href="<c:url value='/bbs/gallery_downloadFile.do'/>?seq=${galleryVO.seq}"><i class="fa fa-download" aria-hidden="true"></i>${galleryVO.oriFilename}</a>
						<!-- <a href=""><i class="fa fa-download" aria-hidden="true"></i> 첨부파일명.jpg</a> -->
					</div>
				</c:if>
			</div>
			<div class="table-btn">
				<a href="<c:url value='/bbs/gallery_modify.do'/>?seq=${galleryVO.seq}" class="mod">수정</a>
				<a href="#" class="del" onclick="javascript:confirmDelete();">삭제</a>
				<a href="<c:url value='/bbs/gallery_list.do'/>">목록으로</a>
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
		location.href = '<c:url value="/bbs/gallery_delete.do"/>?seq=${galleryVO.seq}';
	}
}
</script>
