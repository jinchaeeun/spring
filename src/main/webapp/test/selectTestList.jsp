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
			<td>name</td>
			<td>content</td>
			<td>date</td>
		</tr>
		
		<c:forEach var="result" items="${resultList}" varStatus="status">
		<tr>
			<td>${status.index }</td>
			<td>
				<a href="selectTestView.do?te_id=${result.te_id }">
					${result.te_name }
				</a>
			</td>
			<td>${result.te_content }</td>
			<td>${result.insert_date }</td>
		</tr>
		</c:forEach>
		<!-- if(test==) 과 같다 -->
		<c:if test="${fn:length(resultList) == 0 }">
		<tr>
			<td colspan="4">데이터가 없습니다.</td>
		</tr>
		</c:if>
	</table>
	
	<div>
		<a href="insertTestForm.do">글쓰기</a>
	</div>
</body>
</html>