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
					<span class="bbs-view-date">2021-04-16</span>
					<h2>산림청, 산림보호구역 규제 완화⋯ ‘치유의 숲’ 조성 입법예고</h2>			
					<span>글쓴이: <b>관리자</b></span>
				</div>
				<div class="view-cont">
					<p>산림청(청장 박종호)은 산림보호구역에서 ‘치유의 숲’ 조성이 가능하도록 규제를 완화한다고 20일 밝혔다.
						산림보호구역 행위제한 예외사유에 치유의 숲 조성을 추가한 「산림보호법 시행령」일부개정안이 현재 입법예고 중이며, 오는 12월 중 시행될 예정이다.
						이번 시행령이 개정되면 산림청장 또는 시·도지사의 허가를 받고 산림보호구역 안에서「산림문화·휴양에 관한 법률」제2조제5호에 따른 치유의 숲을 조성할 수 있게 된다.
						그동안 숲이 주는 치유 효과를 극대화하기 위해 경관이 잘 보전된 산림보호 구역 안에 치유의 숲을 조성해 달라는 지방자치단체의 건의가 잇따랐다.
						산림청은 이번 개정으로 농∙산촌 주민의 고용창출과 지역관광 활성화 효과를 기대하고 있다.
						산림청 관계자는 “치유의 숲 1개소 조성 시 연간 일자리 94개 창출, 관광객 6,600명 유입의 효과를 볼 수 있다”고 전했다.
						산림청은 또한 산림보호구역에서 치유시설 조성 시 ｢치유의 숲 시설의 설치･운영 및 관리에 관한 규정(산림청훈령 제1228호)｣에 따라 산림훼손을 최소화하고 친환경적인 방법으로 조성하도록 할 예정이다.   
						치유의 숲 주요 건축물인 치유본부는 목구조를 적용하고 황토, 목재 등 천연재료를 이용한 친환경적인 시설로 조성해 도시생활에 지친 국민들에게 각광받는 치유공간으로 재창조할 방침이다.   
						산림청 심상택 산림보호국장은 “이번 개정을 통한 산림규제 완화가 지역경제발전의 초석이 되길 기대한다”고 말했다.

						출처 : 한국건설신문(http://www.conslove.co.kr)
					</p>
				</div>
				
				<div class="view-file">
					<a href=""><i class="fa fa-download" aria-hidden="true"></i> 첨부파일명.jpg</a>
					<a href=""><i class="fa fa-download" aria-hidden="true"></i> 첨부파일명.jpg</a>
				</div>
			</div>
			<div class="table-btn">
				<a href="<c:url value='/bbs/gallery_list.do'/>">목록으로</a>
				<a href="" class="del">삭제</a>
				<a href="" class="mod">수정</a>
			</div>
		</div>
  </div>
</div>
<!--contents 끝-->

	<!-- 하단 헤더 불러오기 -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>