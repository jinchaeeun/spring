<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 헤더 불러오기 -->
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/inc/menu.jsp"%>
<style>
	.booking-all{max-width: 1200px; margin: 20px auto;}
	
	.booking-content h1{font-size:36px; text-align: center;}

	.booking-content .search-box {text-align: right; padding-right: 10px;} /*요소들을 정리할 때는 text-align*/
	.booking-content .search-box input{width:100px; border: 1px solid #ccc; height: 30px;}
	.booking-content .search-box button{border: 1px solid #90a17e; height: 30px; padding: 0 20px; background: #90a17e; color: #fff;}

	/*table로 글자 중앙 정렬*/
/* 	.booking-wrap ul li .booking-box{display: table; width: 100%;}
	.booking-wrap ul li .booking-box > div{display: table-cell; vertical-align:middle;} 
	.booking-wrap ul li .booking-box > div.thum{width: 30%;}
	.booking-wrap ul li .booking-box > div.info{width: 70%;} */

	.booking-wrap ul li{ padding: 10px; }
	.booking-wrap ul li .booking-box {overflow: hidden; border: 1px solid #ccc; background: #fff;}
	.booking-wrap ul li .booking-box > div{float: left; padding: 10px;}
	

	.booking-wrap ul li .booking-box > div.thum{width: 30%;}
	.booking-wrap ul li .booking-box > div.info{width: 70%;}

	.booking-wrap ul li .booking-box > div.info h3{font-size:25px;}
	.booking-wrap ul li .booking-box > div.info p{font-size:15px; color: #666; margin-top: 10px;}
	.booking-wrap ul li .booking-box > div.info i{font-style: normal; display: block; margin-top: 10px;}
	
	.table-btn{text-align: right; padding-right: 10px;}
	.table-btn a{display: inline-block; background: #5b593f; color: #fff; padding: 5px 10px;}
</style>

<div class="booking-all">
	<div class="booking-content">
		<h1>장소 예약 리스트</h1>
		
		<div class="search-box">
			<input type="text">
			<button>검색</button>
		</div>	

		<div class="booking-wrap">
			<ul>
			<!--if-->
				<li>
					<div class="booking-box">
						<div class="thum">
							<a href="<c:url value='/booking/view.do'/>?location=숲으로 가자 캠페인1"><img src="../img/forest.jpg" alt=""></a>	
						</div>

						<div class="info">
							<h3><a href="<c:url value='/booking/view.do'/>?location=숲으로 가자 캠페인1">숲으로 가자 캠페인1</a></h3>
							<p>‘숲으로 가자 캠페인’ 은 숲교육의 긍정적인 효과를 적용해 학교폭력, 인터넷 중독, 왕따 등 사회문제를 해결하기 위한 범국민 프로젝트입니다.
							학교폭력, 학업스트레스 등으로 인해 정서적으로 불안한 우리 아이들, 숲교육을 통해 자연과 친해지고 심리적 안정을 얻을 수 있습니다. 숲을 가까이하고 다양한 활동을 하는 것은 아이들이 건강하고 행복한 인격체로 성장하는 데 중요합니다. 산림청의 숲으로가자 캠페인은 다각적 차원에서 산림을 교육에 접목시키고 있습니다.</p>
							<i>2021-05-03</i>
						</div>
					</div>
				</li>
				<li>
					<div class="booking-box">
						<div class="thum">
							<a href="<c:url value='/booking/view.do'/>?location=숲으로 가자 캠페인3"><img src="../img/forest.jpg" alt=""></a>	
						</div>

						<div class="info">
							<h3><a href="<c:url value='/booking/view.do'/>?location=숲으로 가자 캠페인2">숲으로 가자 캠페인2</a></h3>
							<p>‘숲으로 가자 캠페인’ 은 숲교육의 긍정적인 효과를 적용해 학교폭력, 인터넷 중독, 왕따 등 사회문제를 해결하기 위한 범국민 프로젝트입니다.
							학교폭력, 학업스트레스 등으로 인해 정서적으로 불안한 우리 아이들, 숲교육을 통해 자연과 친해지고 심리적 안정을 얻을 수 있습니다. 숲을 가까이하고 다양한 활동을 하는 것은 아이들이 건강하고 행복한 인격체로 성장하는 데 중요합니다. 산림청의 숲으로가자 캠페인은 다각적 차원에서 산림을 교육에 접목시키고 있습니다.</p>
							<i>2021-05-03</i>
						</div>
					</div>
				</li>
				<li>
					<div class="booking-box">
						<div class="thum">
							<a href="<c:url value='/booking/view.do'/>?location=숲으로 가자 캠페인3"><img src="../img/forest.jpg" alt=""></a>	
						</div>

						<div class="info">
							<h3><a href="<c:url value='/booking/view.do'/>?location=숲으로 가자 캠페인3">숲으로 가자 캠페인3</a></h3>
							<p>‘숲으로 가자 캠페인’ 은 숲교육의 긍정적인 효과를 적용해 학교폭력, 인터넷 중독, 왕따 등 사회문제를 해결하기 위한 범국민 프로젝트입니다.
							학교폭력, 학업스트레스 등으로 인해 정서적으로 불안한 우리 아이들, 숲교육을 통해 자연과 친해지고 심리적 안정을 얻을 수 있습니다. 숲을 가까이하고 다양한 활동을 하는 것은 아이들이 건강하고 행복한 인격체로 성장하는 데 중요합니다. 산림청의 숲으로가자 캠페인은 다각적 차원에서 산림을 교육에 접목시키고 있습니다.</p>
							<i>2021-05-03</i>
						</div>
					</div>
				</li>
				<!-- if end -->
			</ul>
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

	<div class="table-btn">
		<a href="<c:url value='/booking/list_write.do'/>">장소 등록</a>
	</div>
</div>
	<!-- 하단 헤더 불러오기 -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>