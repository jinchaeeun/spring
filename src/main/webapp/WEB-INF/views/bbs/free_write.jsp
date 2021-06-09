<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 헤더 불러오기 -->
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<body>
	<%@ include file="/WEB-INF/views/inc/menu.jsp"%>
	<%@ include file="/WEB-INF/views/bbs/free_submenu.jsp"%>
	
<form method="POST" name="frm" action="<c:url value='/bbs/free_write_action.do'/>" enctype="multipart/form-data"> 
<c:if test="${mode =='modify'}">
	<input type="hidden" name="seq" value="${freeVO.seq}">	
</c:if>

<input type="hidden" name="mode" value="${mode}">
<div class="notice-wrap">
	<div class="notice-box">
		<h1>자유게시판 글쓰기</h1>
		<div class="bbs-write">
			<ul>
				<li>
					<label for="">제목</label>
					<input type="text" name="subject" value="<c:out value='${freeVO.subject}'/>" placeholder="제목을 입력해주세요.">
				</li>
				<li>
					<label for="">내용</label>
					<textarea name="contents" id="" placeholder="내용을 입력해주세요."><c:out value='${freeVO.contents}'/></textarea>
				</li>
				<c:if test="${empty freeVO.filename}">
					<li class="attachment">
						<label for="">첨부파일 #01</label>
						<input type="file" name="uploadFile">
					</li>
				</c:if>
				<c:if test="${not empty freeVO.filename}">
				<li class="attachment">
					<label for="">${freeVO.oriFilename} <a href="#" onclick="javascript:confirmDeleteFile();">[삭제]</a></label>
				</li>
				</c:if>
				<!-- <li class="attachment">
					<label for="">첨부파일 #02</label>
					<input type="file">
				</li>  -->

			</ul>
		</div>
		<div class="table-btn">
			<a href="<c:url value='/bbs/free_list.do'/>">이전</a>
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
			url: '<c:url value="/bbs/free_deleteFile.do"/>',
			dataType: 'JSON',
			data: {"seq": ${freeVO.seq}},
			success: function(data){
				if(data.success == "true"){
					location.reload("/bbs/free_deleteFile.do");
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
