<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 상단 헤더 불러오기 -->
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/inc/menu.jsp"%>

<style>
.booking-view {
	max-width: 1200px;
	overflow: hidden;
	margin: 20px auto;
}

.booking-box .calendar-wrap {
	float: left;
	width: 50%;
	height: 422px;
	padding: 5px;
}

.booking-box .calendar-box {
	float: right;
	width: 50%;
	height: 310px;
	padding: 5px;
}

.booking-box h2 {
	text-align: center;
	font-size: 36px;
}

.booking-box>div {
	overflow: hidden;
	margin-top: 20px;
}

.cal-hd {
	text-align: center;
}

.cal-hd span {
	margin: 10px;
	display: inline-block;
	padding: 10px;
}

.cal-bd {
	border: 1px solid #e1e1e1;
}

.cal-bd ul {
	overflow: hidden;
}

.cal-bd ul li {
	float: left;
	width: 14.28%;
	border: 0px solid blue;
	text-align: center;
}

.cal-bd ul li a {
	display: block;
	padding: 10px;
}

.cal-bd ul li:first-child a {
	color: #ff4b4b;
}

.cal-bd ul li:last-child a {
	color: #1689ff;
}

.cal-bd ul li.today a span {
	background: #726642;
	width: 30px;
	height: 30px;
	display: block;
	line-height: 30px;
	margin: 0 auto;
	border-radius: 50%;
}

.cal-bd ul li.off a {
	color: #ccc;
}

.cal-bd ul li a span {
	width: 30px;
	height: 30px;
	display: block;
	line-height: 30px;
	margin: 0 auto;
}

.cal-bd ul li.selected a span {
	background: #abc095;
	width: 30px;
	height: 30px;
	display: block;
	line-height: 30px;
	margin: 0 auto;
	border-radius: 50%;
}

.cal-bd ul li:hover a span {
	background: #abc095;
	width: 30px;
	height: 30px;
	display: block;
	line-height: 30px;
	margin: 0 auto;
	border-radius: 50%;
}

.view-btn {
	text-align: right;
	padding: 5px;
	margin-top: 10px;
}

.view-btn a {
	display: inline-block;
	padding: 5px 10px;
	background: #5b593f;
	color: #fff;
	transition: all 0.3s;
}

.view-detail {
	background: #fff;
	border: 1px solid #ccc;
	margin: 10px 5px;
	padding: 20px;
	min-height: 200px;
}
</style>
<form method="post" name="frm" action="<c:url value='/booking/booking.do'/>">
<input type="hidden" name="location" value="<c:out value='${location}'/>">
	<div class="booking-view">
		<div class="booking-box">
			<h2><c:out value='${location}'/> 상세보기</h2>
			<div>
				<div class="calendar-wrap">
					<div class="view-photo">
						<!-- banner -->
						<!-- Swiper -->
						<div class="swiper-container">
							<div class="swiper-wrapper">
								<div class="swiper-slide">
									<img
										src="http://m.yeyakwang.co.kr/_upload/pension/140819001/151119292_432x290.jpg">
								</div>
								<div class="swiper-slide">
									<img
										src="http://m.yeyakwang.co.kr/_upload/pension/150706001/150706117_900x500.jpg">
								</div>
							</div>
							<!-- Add Pagination -->
							<div class="swiper-pagination swiper-pagination-white"></div>
							<!-- Add Arrows -->
							<div class="swiper-button-next swiper-button-white"></div>
							<div class="swiper-button-prev swiper-button-white"></div>
						</div>

						<!-- Initialize Swiper -->
						<script>
							var swiper = new Swiper('.swiper-container', {
								autoHeight : true,
								navigation : {
									nextEl : '.swiper-button-next',
									prevEl : '.swiper-button-prev',
								},

								autoplay : {
									delay : 2500,
									disableOnInteraction : false,
								},
							});
						</script>
					</div>
				</div>

				<div class="calendar-box">
					<!-- 달력 -->
					<div class="cal-hd">
						<span><a href="#none">이전달</a></span> <span><h4>2021.05</h4></span>
						<span><a href="#none">다음달</a></span>
					</div>


					<div class="cal-bd">
						<ul>
							<li><a href="#none"><span>일</span></a></li>
							<li><a href="#none"><span>월</span></a></li>
							<li><a href="#none"><span>화</span></a></li>
							<li><a href="#none"><span>수</span></a></li>
							<li><a href="#none"><span>목</span></a></li>
							<li><a href="#none"><span>금</span></a></li>
							<li><a href="#none"><span>토</span></a></li>
						</ul>
						<ul>
							<li class="off"><a href="#none"><span>25</span></a></li>
							<li class="off"><a href="#none"><span>26</span></a></li>
							<li class="off"><a href="#none"><span>27</span></a></li>
							<li class="off"><a href="#none"><span>28</span></a></li>
							<li class="off"><a href="#none"><span>29</span></a></li>
							<li class="off"><a href="#none"><span>30</span></a></li>
							<li class="on"><a href="#none"><span>1</span></a></li>
						</ul>
						<ul>
							<!-- if문 -->
							<li class="on today"><a href="#none"><span>2</span></a></li>
							<li class="on"><a href="#none"><span>3</span></a></li>
							<li class="on"><a href="#none"><span>4</span></a></li>
							<li class="on selected"><a href="#none"><span>5</span></a></li>
							<li class="on"><a href="#none"><span>6</span></a></li>
							<li class="on"><a href="#none"><span>7</span></a></li>
							<li class="on"><a href="#none"><span>8</span></a></li>
						</ul>
						<ul>
							<li class="on"><a href="#none"><span>9</span></a></li>
							<li class="on"><a href="#none"><span>10</span></a></li>
							<li class="on"><a href="#none"><span>11</span></a></li>
							<li class="on"><a href="#none"><span>12</span></a></li>
							<li class="on"><a href="#none"><span>13</span></a></li>
							<li class="on"><a href="#none"><span>14</span></a></li>
							<li class="on"><a href="#none"><span>15</span></a></li>
						</ul>
						<ul>
							<li class="on"><a href="#none"><span>16</span></a></li>
							<li class="on"><a href="#none"><span>17</span></a></li>
							<li class="on"><a href="#none"><span>18</span></a></li>
							<li class="on"><a href="#none"><span>19</span></a></li>
							<li class="on"><a href="#none"><span>20</span></a></li>
							<li class="on"><a href="#none"><span>21</span></a></li>
							<li class="on"><a href="#none"><span>22</span></a></li>
						</ul>
						<ul>
							<li class="on"><a href="#none"><span>23</span></a></li>
							<li class="on"><a href="#none"><span>24</span></a></li>
							<li class="on"><a href="#none"><span>25</span></a></li>
							<li class="on"><a href="#none"><span>26</span></a></li>
							<li class="on"><a href="#none"><span>27</span></a></li>
							<li class="on"><a href="#none"><span>28</span></a></li>
							<li class="on"><a href="#none"><span>29</span></a></li>
						</ul>
						<ul>
							<li class="on"><a href="#none"><span>30</span></a></li>
							<li class="on"><a href="#none"><span>31</span></a></li>
							<li class="off"><a href="#none"><span>1</span></a></li>
							<li class="off"><a href="#none"><span>2</span></a></li>
							<li class="off"><a href="#none"><span>3</span></a></li>
							<li class="off"><a href="#none"><span>4</span></a></li>
							<li class="off"><a href="#none"><span>5</span></a></li>
						</ul>
					</div>

				</div>
			</div>
		</div>

		<div class="view-btn">
			<a href="">이전</a> 
			<input type="text" name="booking_date" size="8" id="booking_date"> <!-- 예약 날짜 -->
			<a href="#" onclick="document.frm.submit();">예약하기</a>
		</div>

		<div class="view-detail">
			<p>상세 설명입니다.</p>
		</div>
	</div>
</form>
	<!-- 하단 헤더 불러오기 -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
	
	<script>
	$(".calendar-box .on").click(function() {
		//console.log("select = " + $(this).text());
		
		$(".calendar-box .on").removeClass("selected");
		$(this).addClass("selected");
		
		var year = "2021";
		var month = "05";
		var day = $(this).text() < 10 ? "0" + $(this).text() : $(this).text(); //날짜가 한자리 수면 두 글자로 만들어 줌
		console.log(year +"-"+ month +"-"+ day);
		
		$("#booking_date").val(year +"-"+ month +"-"+ day);
	});
	</script>