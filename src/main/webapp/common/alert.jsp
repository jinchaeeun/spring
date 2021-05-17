<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="egovframework.com.cmm.Globals"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="web_path" value="<%=Globals.WEB_PATH %>"/>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
  	<meta name="robots" content="noindex, nofollow">
</head>
<body>

	<script type="text/javascript">
		<c:if test="${!empty resultMsg}">alert('${resultMsg }');</c:if>		
		<c:choose>
			<c:when test="${!empty returnUrl }">
				location.href="${web_path}${returnUrl}";
			</c:when>
			<c:when test="${close_at }">
				window.close();
				window.opener.location.reload();
			</c:when>
			<c:otherwise>
				history.back();	
			</c:otherwise>
		</c:choose>
	</script>
</body>
</html>

