<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<a href="deleteTest.do">삭제</a>
	</div>
</body>
</html>