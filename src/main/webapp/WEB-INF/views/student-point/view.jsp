<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>이름</th>
		<th>${sp.SP_NAME}</th>
	</tr>
	<tr>
		<th>국어점수</th>
		<th>${sp.SP_KOR_POINT}</th>
	</tr>
	<tr>
		<th>영어점수</th>
		<th>${sp.SP_ENG_POINT}</th>
	</tr>
	<tr>
		<th>수학점수</th>
		<th>${sp.SP_MATH_POINT}</th>
	</tr>
	<tr>
		<th>특이사항</th>
		<th>${sp.SP_PROFILE}</th>
	</tr>
	<tr>
	<th colspan="2">
		<button onclick="location.href='/student-point/update?spNum=${sp.SP_NUM}'">수정</button>
		<button onclick="history.back();">뒤로가기</button>
	</th>
	</tr>
</table>
</body>
</html>