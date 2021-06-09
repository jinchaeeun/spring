<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 헤더 불러오기 -->
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/inc/menu.jsp"%>
	<%@ include file="/WEB-INF/views/bbs/gallery_submenu.jsp"%>
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
<form method="POST" name="frm" action="<c:url value='/bbs/gallery_write_action.do'/>" enctype="multipart/form-data"> 
<c:if test="${mode =='modify'}">
	<input type="hidden" name="seq" value="${galleryVO.seq}">	
</c:if>
<input type="hidden" name="mode" value="${mode}">

	<div class="notice-wrap">
		<div class="notice-box">
			<h1>갤러리 글쓰기</h1>
			<div class="bbs-write">
				<ul>
					<li>
						<label for="">제목</label>
						<input type="text" name="subject" value="<c:out value='${galleryVO.subject}'/>" placeholder="제목을 입력해주세요.">
					</li>
					<li>
						<label for="">내용</label>
						<textarea name="contents" id="" placeholder="내용을 입력해주세요."><c:out value='${galleryVO.contents}'/></textarea>
					</li>
					<!-- 첨부파일 없을 때 -->
					<c:if test="${empty galleryVO.oriFilename}">
					<li class="attachment">
						<label for="">첨부파일 #01</label>
						<input type="file" name="uploadFile">
					</li>
					</c:if>
					<!-- 첨부파일 있을 때 -->
					<c:if test="${not empty galleryVO.oriFilename}">
					<li>
						<label for="">${galleryVO.oriFilename} <a href="#" onclick="javascript:confirmDeleteFile();">[삭제]</a></label>
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
				<a href="<c:url value='/bbs/gallery_list.do'/>">이전</a>
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
				url: '<c:url value="/bbs/gallery_deleteFile.do"/>',
				dataType: 'JSON',
				data: {"seq": ${galleryVO.seq}},
				success: function(data){
					if(data.success == "true"){
						location.reload("/bbs/gallery_deleteFile.do");
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