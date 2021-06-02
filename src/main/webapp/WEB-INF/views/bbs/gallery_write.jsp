<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- 상단 헤더 불러오기 -->
 <jsp:include page="../sub_header.jsp"></jsp:include>


<style>
	/*갤러리 글쓰기*/
	.notice-box {max-width: 880px; margin: 0 auto; }

	.bbs-write{max-width: 1200px; margin: 0 auto;}
	.bbs-write > div{margin-bottom: 15px;}

	.bbs-write li label{color: #666; margin-bottom: 5px; display: block;} 
	.bbs-write li input[type="text"]{ border: 1px solid #ccc; width: 100%; height: 30px; padding: 5px;}
	.bbs-write li textarea{width: 100%; height: 40px; padding: 5px; border: 1px solid #ccc; }

	.bbs-write li.checkbox-wrap{background: #fff; padding: 10px; }
	.bbs-write li.checkbox-wrap label{display: inline-block;}

</style>
<div class="snb-wrap">
	<div>
		<ul>
			<li><a href="<c:url value='/bbs/notice_list.do'/>"><span>공지사항</span></a></li>
			<li><a href="<c:url value='/bbs/free_list.do'/>"><span>자유게시판</span></a></li>
			<li class="on"><a href="<c:url value='/bbs/gallery_list.do'/>"><span>갤러리</span></a></li>
		</ul>
	</div>
</div>

<div class="notice-wrap">
	<div class="notice-box">
		<h1>갤러리 글쓰기</h1>
		<div class="bbs-write">
			<ul>
				<li>
					<label for="">제목</label>
					<input type="text" placeholder="제목을 입력해주세요.">
				</li>
				<li>
					<label for="">내용</label>
					<textarea name="" id=""></textarea>
				</li>
				<li class="attachment">
					<label for="">첨부파일 #01</label>
					<input type="file">
				</li>
				<li class="attachment">
					<label for="">첨부파일 #02</label>
					<input type="file">
				</li>
				<li class="checkbox-wrap">
					<label for="">공지 선택 &nbsp</label>
					<input type="checkbox" id="chk-notice">
					<label for="chk-notice" class="check-txt"> &nbsp선택 시 공지사항</label>
				</li>

			</ul>
		</div>
		<div class="table-btn">
			<a href="<c:url value='/bbs/gallery_list.do'/>">이전</a>
			<a href="<c:url value='/bbs/gallery_list.do'/>">저장</a>
		</div>
	</div>
</div>

<!-- 하단 헤더 불러오기 -->
 <jsp:include page="../sub_footer.jsp"></jsp:include>