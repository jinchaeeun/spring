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
	<form method="post" id="submitForm" name="submitForm" onsubmit="return fn_submit();" action="${actionUrl}">
		<input type="hidden" name="te_id" value="${resultVO.te_id }" />
		<table border="1">
			<tr>
				<td>이름</td>
				<td>
					<input type="text" id="te_name" name="te_name" value="${resultVO.te_name }" />
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea id="te_content" name="te_content">${resultVO.te_content }</textarea>
				</td>
			</tr>
			<tr>
				<td>공지사항</td>
				<td>
					<input type="checkbox" id="te_is_notice" name="te_is_notice" value="1"<c:if test="${resultVO.te_is_notice eq '1'}"> checked='checked' </c:if>/>
					<label for="te_is_notice">체크 시 공지사항으로 등록</label>
				</td>
			</tr>
			<tr>
				<td>인기글</td>
				<td>
					<input type="checkbox" id="te_is_best" name="te_is_best" value="1"<c:if test="${resultVO.te_is_best eq '1'}"> checked='checked' </c:if>/>
					<label for="te_is_best">체크 시 인기글로 등록</label>
				</td>
			</tr>
		</table>
		<div>
			<a href="#none;" onclick="history.back();return false;">뒤로가기</a>
			<input type="submit" value="저장" />
		</div>
	</form>
</body>
</html>
<script>
function fn_submit(){
	if($('#te_name').val() == ""){
		alert("이름을 입력하세요.");
		return false;
	}else if($('#te_content').val() == ""){
		alert("내용을 입력하세요.");
		return false;
	}
	
	if(confirm("저장하시겠습니까?")){
		return true;
	}else{
		return false;
	}
	
}
</script>