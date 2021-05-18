<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>${searchVO.te_id }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${resultVO.te_name }</td>
		</tr>		
		<tr>
			<td>내용</td>
			<td>${resultVO.te_content }</td>
		</tr>		
		<tr>
			<td>등록일</td>
			<td>${resultVO.insert_date }</td>
		</tr>		
	</table>
	
	<div>
		<a href="selectTestList.do" onclick="history.back();return false;">뒤로가기</a>
		<a href="insertTestForm.do">글쓰기</a>
		<a href="updateTestForm.do?te_id=${resultVO.te_id }">수정</a>
		<a href="#none;" onclick="fn_delete1(${resultVO.te_id });return false;">삭제1</a>
		<a href="#none;" onclick="fn_delete2(${resultVO.te_id });return false;">삭제2</a>
	</div>
	
	<form method="post" id="deleteForm" action="deleteTest.do">
		<input type="hidden" id="te_id" name="te_id" value="${resultVO.te_id }">
	</form>
</body>
</html>
<script>
function fn_delete1(te_id){
    if(confirm("삭제하시겠습니까?")){
       location.href="deleteTest.do?te_id="+te_id; //뒤에 적을 데이터가 많아질 수 있음
    }
 }

function fn_delete2(te_id){
	if(confirm("삭제하시겠습니까?")){
		$('#te_id').val(te_id);      //이렇게 가져오거나 form 태그에서 하나인경우 세팅 가능
		$('#deleteForm').submit();
	}
}
</script>