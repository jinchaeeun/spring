<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 헤더 불러오기 -->
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/inc/menu.jsp"%>

<form method="get" name="frm" action="<c:url value='/booking/mypage.do'/>">
<div class="notice-wrap">
	<div class="notice-box mypage">
		<h2>예약 확인</h2>
		<div class="search-box">
			<input type="text" name="searchKeyword" value="${searchVO.searchKeyword}">
			<button onclick="javascript:document.frm.submit();">검색</button>
		</div>
		<div class="table-list mypage-list">
			<ul class="table-hd">
				<li> <!--table-->
					<div class="no">번호</div> <!-- table-cell -->
					<div class="title">장소</div>
					<div class="booking_date">예약일</div>
					<div class="state">상태</div>
					<div class="name">예약자</div>
					<div class="date">등록일</div>
					<c:if test="${session.auth == 'adm'}"> 
						<div class="admin">관리자메뉴</div>
					</c:if>
				</li>
			</ul>
		<c:forEach var="bookingVO" items="${bookingVOList}" varStatus="status">
			<ul class="table-bd">
					<li>
						<div class="no"><c:out value='${bookingVO.seq}'/></div>
						<div class="subject"><a href="<c:url value='/booking/view.do'/>"><c:out value='${bookingVO.location}'/></a></div>
						<div class="booking_date"><c:out value='${bookingVO.booking_date}'/></div>
						<div class="state">
							<c:choose>
								<c:when test="${bookingVO.status == '1'}">
									<sapn class="color01">승인</sapn>
								</c:when>
								<c:when test="${bookingVO.status == '2'}">
									<sapn class="color02">대기</sapn>
								</c:when>
								<c:when test="${bookingVO.status == '3'}">
									<sapn class="color03">취소</sapn>
								</c:when>
								<c:when test="${bookingVO.status == '4'}">
									<sapn class="color04">반려</sapn>
								</c:when>
							</c:choose>
						</div>
						<div class="name"><c:out value='${bookingVO.name}'/></div>
						<div class="date"><c:out value='${bookingVO.date}'/></div>
						<c:if test="${session.auth == 'adm'}"> 
							<div class="admin">
								<a href="javascript:mamage(${bookingVO.seq}, '1');">[승인]</a> 
								<a href="javascript:mamage(${bookingVO.seq}, '2');">[대기]</a>
								<a href="javascript:mamage(${bookingVO.seq}, '3');">[취소]</a> 
								<a href="javascript:mamage(${bookingVO.seq}, '4');">[반려]</a>  
							</div><!-- 관리자 메뉴 -->
						</c:if>
					</li>
				</ul>
			</c:forEach>
		</div>
	</div>

	<div class="paging">
		<ul>
			<li><a href="#none">처음으로</a></li>
			<li><a href="#none">이전</a></li>
			<li class="on"><a href="#none">1</a></li>
			<li><a href="#none">2</a></li>
			<li><a href="#none">3</a></li>
			<li><a href="#none">다음</a></li>
			<li><a href="#none">마지막</a></li>
		</ul>
	</div>

</div>
</form>
	<!-- 하단 헤더 불러오기 -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
	
	
	<script>
	
	var statusText = new Map([
		['1', '승인'],
		['2', '대기'],
		['3', '취소'],
		['4', '반려']
	]);
	function mamage(seq, status){
		
		if(confirm(statusText.get(status) + ' 상태로 변경하시겠습니까?') == true){
			$.ajax({
				type:'POST',
				url:'<c:url value="/booking/modify_status.do"/>',
				dataType: 'JSON',
				data: {'seq' : seq, 'status': status},
				success : function(data){
					if(data.success == "true"){
						location.reload();
					}else{
						alert('상태 변경을 실패했습니다.');
					}
				},
				error: function(jqXHR, textStatus, errorThrown){
					console.log(textStatus);
				}
			});
		}
		
	}
	
	</script>