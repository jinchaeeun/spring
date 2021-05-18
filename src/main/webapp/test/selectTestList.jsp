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
<!-- 상단 검색 박스 -->
<form method="get" id="searchForm" name="searchForm" action="">
<input type="hidden" id="pageIndex" name="pageIndex" value="${searchVO.pageIndex }"/>
<input type="checkbox" id="te_is_best" name="te_is_best" value="1" <c:if test="${searchVO.te_is_best eq '1' }">checked='checked'</c:if> />
<label for="te_is_best">인기글</label>
	&nbsp;
	
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

$('#te_is_best').bind('change', function(){
	fn_search();
});

$(document).ready(function(){
	$('#all_check').bind('click', function(){
		if($(this).is(":checked")){
			$('.te_ids').prop('checked', true); 
		}else{
			$('.te_ids').prop('checked', false);
		}
	});
});

</script>

	<form method="post" id="listForm" name="listForm" action="deleteTestAll.do">
		 <input type="hidden" id="te_ids" name="te_ids" value="" /> 
		<table border="1">
			<tr>
				<td><input type="checkbox" class="te_ids" id="all_check" name="all_check" value="1"/></td>
				<td>ID</td>
				<td>name</td>
				<td>nick</td>
				<td>content</td>
				<td>date</td>
				<td>관리</td>
			</tr>
			<!-- 공지 id 설정 -->
			<c:forEach var="result" items="${noticeList}" varStatus="status">
			<tr>
			<td><input type="checkbox" class="te_ids" id="te_id_${result.te_id }" name="te_id" value="${result.te_id }"/></td>
			 <td>공지</td>
				<td>
					<a href="selectTestView.do?te_id=${result.te_id }">
						${result.te_name }
					</a>
				</td>
				<td>${result.te_nick }</td>
				<td>${result.te_content }</td>
				<td>${result.insert_date }</td>
				<td>
					<input type="button" value="수정" onclick="fn_modify(${result.te_id});return false;" />
					<input type="button" value="삭제" onclick="fn_delete(${result.te_id});return false;" />
				</td> 
				</td>
			</tr>
			</c:forEach>
			
			<!-- 인기글 id 설정 -->
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
			<td><input type="checkbox" class="te_ids" id="te_id_${result.te_id }" name="te_id" value="${result.te_id }"/></td>
			 <td>인기</td>
				<td>
					<a href="selectTestView.do?te_id=${result.te_id }">
						${result.te_name }
					</a>
				</td>
				<td>${result.te_nick }</td>
				<td>${result.te_content }</td>
				<td>${result.insert_date }</td>
				<td>
					<input type="button" value="수정" onclick="fn_modify(${result.te_id});return false;" />
					<input type="button" value="삭제" onclick="fn_delete(${result.te_id});return false;" />
				</td> 
			</tr>
			</c:forEach>
			
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
			<!--
			번호를 뿌리려면 
			전체 갯수 - ((현재 페이지 -1) * row수) - status.index
			1페이지 일 때 : 14- ((1-1)*10) - (id: 0~9)
			2페이지 일 때 : 14- ((2-1)*10) - (id: 0~9) 
			 --> 
			 	<td><input type="checkbox" class="te_ids" id="te_id" value="${result.te_id }"/></td>
				<td>${totCnt - ((searchVO.pageIndex - 1) * searchVO.pageUnit) - status.index }</td>
				<td>
					<a href="selectTestView.do?te_id=${result.te_id }">
						${result.te_name }
					</a>
				</td>
				<td>${result.te_nick }</td>
				<td>${result.te_content }</td>
				<td>${result.insert_date }</td>
				<td>
					<input type="button" value="수정" onclick="fn_modify(${result.te_id});return false;" />
					<input type="button" value="삭제" onclick="fn_delete(${result.te_id});return false;" />
				</td>
			</tr>
			</c:forEach>
			<!-- if(test==) 과 같다 -->
			<c:if test="${fn:length(resultList) == 0 }">
			<tr>
				<td colspan="4">데이터가 없습니다.</td>
			</tr>
			</c:if>
		</table>
	</form>
	
	<div>
		<ul>
			${paginationInfo }
		</ul>
	</div>
	
	<div>
		<a href="insertTestForm.do">글쓰기</a>
		<a href="#none;" onclick="fn_deleteAll();return false;">선택삭제</a>
	</div>
</body>
</html>
<script>
function fn_paging(pageIndex){
	$('#pageIndex').val(pageIndex);
	$('#searchForm').submit();	
}

function fn_modify(te_id){
	location.href="updateTestForm.do?te_id=" + te_id;
}

function fn_delete(te_id){
	if(confirm("삭제하시겠습니까?")){
		location.href="deleteTest.do?te_id=" + te_id;	
	}
}

function fn_deleteAll(){
	if($('.te_id:checked').length == 0){
		alert("항목을 하나 이상 선택해주세요.");
		return false;
	}else{
		if(confirm("선택된 항목을 삭제하시겠습니까?")){
			var arr = new Array();
			$('.te_id:checked').each(function(){
				arr.push($(this).val());
			});
			$('#te_ids').val(arr);
			$('#listForm').submit();
		}
		return false;
	}
}
</script>