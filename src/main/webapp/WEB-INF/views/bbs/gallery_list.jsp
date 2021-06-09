<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 헤더 불러오기 -->
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/inc/menu.jsp"%>
	<%@ include file="/WEB-INF/views/bbs/gallery_submenu.jsp"%>

	<div class="gallery-box-wrap">
		<div class="gallery-header">
			<h2>보도자료</h2>
			<span>새소식</span>
		</div>
	</div>
	<div class="gallery-box">
		<ul>
			<c:forEach var="galleryVO" items="${galleryVOList}" varStatus="status">
				<li>
					<div>
						<div class="thum">
							<%-- <a href="<c:url value='/bbs/gallery_view.do'/>?seq=${galleryVO.seq}"><img src="../img/forest.jpg" alt="숲"></a> --%>
							<a href="<c:url value='/bbs/gallery_view.do'/>?seq=${galleryVO.seq}"><img src="<c:url value='/bbs/gallery_image.do'/>?seq=${galleryVO.seq}"></a>
						</div> 
						<div class="info">
							<h3><a href="<c:url value='/bbs/gallery_view.do'/>?seq=${galleryVO.seq}"></a></h3>
							<p><c:out value='${galleryVO.contents}'/>
							</p>
							<i> <c:out value='${galleryVO.date}'/></i>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>

	</div>
	<div class="table-btn">
		<a href="<c:url value='/bbs/gallery_write.do'/>">글쓰기</a>
	</div>
	<style>
		.table-btn{max-width: 1200px;}
	</style>
	
	<!-- 하단 헤더 불러오기 -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
