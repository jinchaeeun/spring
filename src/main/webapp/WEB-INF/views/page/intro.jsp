<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 헤더 불러오기 -->
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/inc/menu.jsp"%>

<div id="fullpage">
	<div class="section " id="section0">
		<div class="section01-box">
			<h2>작은 숲에서<br/>작은 용기가</h2>
			<p>유한킴벌리는 유일한 박사의 "국민이 건강해야 나라를 되찾을 수 있다"는 정신으로 시작되었습니다.</p>
		</div>
		<div class="layer1">
		</div>
	</div>

	<div class="section" id="section1">
		<div class="section01-box">
			<h2>작은 숲에는<br/>더 큰 공존이</h2>
			<p>유한킴벌리는 사람과 숲과의 공존을 추구하고 있습니다. <br/>우리강산 푸르게푸르게 캠페인에 적극 참여하며 나무를 심고 숲을 가꾸는 사회적 책임을 실천해왔습니다.</p>
		</div>
		<div class="layer2">
		</div>
	</div>

	<div class="section" id="section2">
		<div class="section01-box">
			<h2>작은 숲 모여<br/>더 큰 숲으로</h2>
			<p>국내 1등을 넘어 글로벌 제약사로서의 길, 인류 건강을 위한 그 길을 유한킴벌리는 큰 꿈을 갖고 나아가고 있습니다.</p>
		</div>
		<div class="layer3">
		</div>
	</div>
</div>

<script type="text/javascript">
    var myFullpage = new fullpage('#fullpage', {
        anchors: ['page01', 'page02', 'page03', 'page04'],
        //sectionsColor: ['#C63D0F', '#1BBC9B', '#7E8F7C'],
        scrollBar: true
    });
	//achors 스크롤마다 페이지 뒤에 #하고 이름이 붙음. url로 이용할 수도 있다.
</script>

	<!-- 하단 헤더 불러오기 -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>