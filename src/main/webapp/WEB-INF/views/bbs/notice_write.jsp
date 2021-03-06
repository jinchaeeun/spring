<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 헤더 불러오기 -->
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/inc/menu.jsp"%>
	<%@ include file="/WEB-INF/views/bbs/notice_submenu.jsp"%>

<form method="POST" name="frm" action="<c:url value='/bbs/notice_write_action.do'/>" enctype="multipart/form-data"> 
<c:if test="${mode =='modify'}">
	<input type="hidden" name="seq" value="${noticeVO.seq}">	
</c:if>
<input type="hidden" name="mode" value="${mode}">

	<div class="notice-wrap">
		<div class="notice-box">
			<h1>공지사항 글쓰기</h1>
			<div class="bbs-write">
				<ul>
					<li>
						<label for="">제목</label>
						<input type="text" name="subject" value="<c:out value='${noticeVO.subject}'/>" placeholder="제목을 입력해주세요.">
					</li>
					<li>
						<label for="">내용</label>
						<textarea name="contents" id="" placeholder="내용을 입력해주세요."><c:out value='${noticeVO.contents}'/></textarea>
					</li>
					<c:if test="${empty noticeVO.filename}">
					<li class="attachment">
						<label for="">첨부파일 #01</label>
						<input type="file" name="uploadFile">
					</li>
					</c:if>
					<c:if test="${not empty noticeVO.filename}">
					<li>
						<label for="">${noticeVO.oriFilename} <a href="#" onclick="javascript:confirmDeleteFile();">[삭제]</a></label>
					</li>
					</c:if>
					<!-- 
					<li class="attachment">
						<label for="">첨부파일 #02</label>
						<input type="file">
					</li>
					 -->
					<li class="checkbox-wrap">
						<label for="">공지 선택 &nbsp</label>
						<input type="checkbox" id="chk-notice">
						<label for="chk-notice" class="check-txt"> &nbsp선택 시 공지사항</label>
					</li>
	
				</ul>
			</div>
			<div class="table-btn">
				<a href="<c:url value='/bbs/notice_list.do'/>">이전</a>
				<a href="#" onclick="javascript:document.frm.submit();">저장</a>
			</div>
		</div>
	</div>
</form>
	<!-- 하단 헤더 불러오기 -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
	
	<script>
	function confirmDeleteFile(){
		if(confirm('삭제하시겠습니까?') == true){
			//ajax로 처리하기
			$.ajax({
				type: 'POST',
				url: '<c:url value="/bbs/notice_deleteFile.do"/>',
				dataType: 'JSON',
				data: {"seq": ${noticeVO.seq}},
				success: function(data){
					if(data.success == "true"){
						location.reload("/bbs/notice_deleteFile.do");
					}else{
						alert('파일 삭제에 실패하였습니다.');
					}
				},
				error: function(jqXHR, textStatus, errorThrown){
					console.log(textStatus);
				}
				
			});
			
		}
	}
	</script>