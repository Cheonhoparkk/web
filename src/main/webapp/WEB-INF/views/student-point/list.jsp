<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>영어점수</th>
		<th>한국어점수</th>
		<th>수학점수</th>
		<th>개인정보</th>
	</tr>
	<c:forEach items="${list}" var="sp">
	<tr>
		<td>${sp.SP_NUM}</td>
		<td>${sp.SP_NAME}</td>
		<td>${sp.SP_ENG_POINT}</td>
		<td>${sp.SP_KOR_POINT}</td>
		<td>${sp.SP_MATH_POINT}</td>
		<td>${sp.SP_PROFILE}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>