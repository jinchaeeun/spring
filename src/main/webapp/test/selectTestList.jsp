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
<form method="get" id="searchForm" name="searchForm" action="">
	<input type="hidden" id="pageIndex" name="pageIndex" value="${searchVO.pageIndex }"/>
	<select id="searchCondition" name="searchCondition">
		<option value="te_name" <c:if test="${searchVO.searchCondition eq 'te_name' }">selected='selected'</c:if>>
			이름
		</option>
		<option value="te_content" <c:if test="${searchVO.searchCondition eq 'te_content' }">selected='selected'</c:if>>
			내용
		</option>
		<option value="all" <c:if test="${searchVO.searchCondition eq 'all' }">selected='selected'</c:if>>
			이름 + 내용
		</option>
	</select>
	
	<input type="text" id="searchKeyword" name="searchKeyword" value="${searchVO.searchKeyword }" />
	<input type="button" value="검색" onclick="fn_search();return false;" />
</form>
<script>
function fn_search(){
	$('#searchForm').submit();
}
</script>

	<table border="1">
		<tr>
			<td>ID</td>
			<td>name</td>
			<td>content</td>
			<td>date</td>
		</tr>
		
		<c:forEach var="result" items="${resultList}" varStatus="status">
		<tr>
		<!--
		번호를 뿌리려면 
		전체 갯수 - ((현재 페이지 -1) * row수) - status.index
		1페이지 일 때 : 14- ((1-1)*10) - (id: 0~9)
		2페이지 일 때 : 14- ((2-1)*10) - (id: 0~9) 
		 --> 
			<td>${totCnt - ((searchVO.pageIndex - 1) * searchVO.pageUnit) - status.index }</td>
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
		<ul>
			${paginationInfo }
		</ul>
	</div>
	
	<div>
		<a href="insertTestForm.do">글쓰기</a>
	</div>
</body>
</html>

<script>
function fn_paging(pageIndex){
	$('pageIndex').val(pageIndex);
	$('searchForm').submit();
	
	location.href="selectTestList.do?pageIndex="+pageIndex+"&aa=1";
}
</script>