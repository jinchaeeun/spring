<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 상단 헤더 불러오기 -->
 <jsp:include page="./header.jsp"></jsp:include>

	<div class="contents">
		<!--내용 출력-->
		<div class="main-visual">
			<div>
				<div class="main-bg-box"></div>
			</div>

			<!--메인 비주얼-->
			<h2 data-aos="fade-down" data-aos-delay="300">더 나은 생활을 향한 믿음</h2>
			<p data-aos="fade-up">
				<span data-aos="fade-up" data-aos-delay="1000">우리는 생활-건강-지구환경을 위해 행동합니다.</span>
			</p>
		</div>
<!-- url('https://images.fineartamerica.com/images/artworkimages/mediumlarge/1/hope-bowdler-winter-landscape-nigel-forster.jpg')
url('https://media.nationalgeographic.org/assets/photos/186/480/0e077d4d-9209-40d5-9fd5-4e51aeed7b37.jpg')-->
		<div class="numbers-wrap">
			<div class="numbers">
				<h2>우리강산 푸르게푸르게</h2>
				<p>현황</p>
				<div class="num-data">
					<ul>
						<li>
							<h4>사막화 방지를 위해 심은 나무</h4>
							<p>10,131,600 <i>그루</i> </p>
							<span>1998년부터 동북아 사막화 방지를 위하여 중국, 몽골 지역에 10,131,600 그루의 나무를 심었습니다.</span>
						</li>
						<li>
							<h4>캠페인에 참가한 학생 수</h4>
							<p>4,070<i>명</i> </p>
							<span>1988년 시작된 '숲을 통한 환경체험교육 프로그램'그린 캠프는 그동안 44회 실시하여 4,070명의 여고생이 참여했습니다.</span>
						</li>
						<li>
							<h4>아름다운 숲 선정 캠페인</h4>
							<p>15<i>회</i> 224<i>개소</i> </p>
							<span>2000년부터 아름다운 숲을 발굴, 선정하고 있습니다. 총 15회 아름다운 숲 전국대회 개최, 224개소의 숲을 발굴, 선정했습니다.</span>
						</li>
						<li>
							<h4>자연 친화 학교로 변경한 면적</h4>
							<p>871,782<i>m²</i> </p>
							<span>1995년부터 학교에 숲을 조성, 자연친화적으로 바꾸고 있습니다. 총 735개교, 약 871,782m²면적의 학교 숲을 조성했습니다.</span>
						</li>
					</ul>
				</div>
				
			</div>
		</div>

		<div class="slide-banner">
			
		 <!-- Swiper -->
		  <div class="swiper-container">
			<div class="swiper-wrapper">
        	  <div class="swiper-slide"><img src="./img/mountains.jpg"></div>
			  <div class="swiper-slide"><img src="https://images.unsplash.com/photo-1604223190546-a43e4c7f29d7?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8bW91bnRhaW4lMjBsYW5kc2NhcGV8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80"></div>
			  <div class="swiper-slide"><img src="https://images.fineartamerica.com/images/artworkimages/mediumlarge/1/hope-bowdler-winter-landscape-nigel-forster.jpg"></div>
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
			  autoHeight: true,
			  navigation: {
				nextEl: '.swiper-button-next',
				prevEl: '.swiper-button-prev',
			  },
			
			  autoplay: {
				delay: 2500,
				disableOnInteraction: false,
			  },

			  breakpoints: {
				  480: {
					slidesPerView: 2,
					spaceBetween: 20,
				  },
				  720: {
					slidesPerView: 4,
					spaceBetween: 40,
				  },
				  1024: {
					slidesPerView: 5,
					spaceBetween: 50,
				  },
				  },
			});
		  </script>
		</div>


		<div class="main-gallery-wrap">
			<div class="m-g-box">
				<h2>GALLERY</h2>

				<div class="main-gallery">
					<ul>
						<li>
							<div>
								<div class="thum">
									<a href="#none">
										<img src="./img/forest.jpg" alt="">
									</a>
								</div>
								<div class="info">
									<a href="#none">
										<h3>게시물 제목</h3>
										<p>게시물 내용 출력 부분</p>
										<span>
											<i class="fa fa-tree" aria-hidden="true"></i> <!-- https://fontawesome.com/ -->
											<u>Link</u>
										</span>
									</a>

								</div>
							</div>
						</li>
						<li>
							<div>
								<div class="thum">
									<a href="#none">
										<img src="./img/forest.jpg" alt="">
									</a>
								</div>
								<div class="info">
									<a href="#none">
										<h3>게시물 제목</h3>
										<p>게시물 내용 출력 부분</p>
										<span>
											<i class="fa fa-tree" aria-hidden="true"></i>
											<u>Link</u>
										</span>
									</a>

								</div>
							</div>
						</li>
						<li>
							<div>
								<div class="thum">
									<a href="#none">
										<img src="./img/forest.jpg" alt="">
									</a>
								</div>
								<div class="info">
									<a href="#none">
										<h3>게시물 제목</h3>
										<p>게시물 내용 출력 부분</p>
										<span>
											<i class="fa fa-tree" aria-hidden="true"></i>
											<u>Link</u>
										</span>
									</a>

								</div>
							</div>
						</li>
						<li>
							<div>
								<div class="thum">
									<a href="#none">
										<img src="./img/forest.jpg" alt="">
									</a>
								</div>
								<div class="info">
									<a href="#none">
										<h3>게시물 제목</h3>
										<p>게시물 내용 출력 부분</p>
										<span>
											<i class="fa fa-tree" aria-hidden="true"></i>
											<u>Link</u>
										</span>
									</a>

								</div>
							</div>
						</li>
						<li>
							<div>
								<div class="thum">
									<a href="#none">
										<img src="./img/forest.jpg" alt="">
									</a>
								</div>
								<div class="info">
									<a href="#none">
										<h3>게시물 제목</h3>
										<p>게시물 내용 출력 부분</p>
										<span>
											<i class="fa fa-tree" aria-hidden="true"></i>
											<u>Link</u>
										</span>
									</a>

								</div>
							</div>
						</li>
						<li>
							<div>
								<div class="thum">
									<a href="#none">
										<img src="./img/forest.jpg" alt="">
									</a>
								</div>
								<div class="info">
									<a href="#none">
										<h3>게시물 제목</h3>
										<p>게시물 내용 출력 부분</p>
										<span>
											<i class="fa fa-tree" aria-hidden="true"></i>
											<u>Link</u>
										</span>
									</a>

								</div>
							</div>
						</li>

					</ul>
				</div>
			</div>

		</div>
	</div>
<!-- 하단 헤더 불러오기 -->
 <jsp:include page="./footer.jsp"></jsp:include>
