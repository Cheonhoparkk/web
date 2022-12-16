<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.web.DBCon"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
<form method="POST" action="/user-info/update">
	<input type="hidden" name="uiNum" value="${userInfo.UI_NUM}">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="uiId" value="${userInfo.UI_ID}" readonly></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="uiPwd"  value="${userInfo.UI_PWD}"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="uiName"  value="${userInfo.UI_NAME}"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="uiAddr"  value="${userInfo.UI_ADDR}"></td>
		</tr>
		<tr>
			<td>이메일주소</td>
			<td><input type="email" name="uiEmail"  value="${userInfo.UI_EMAIL}"></td>
		</tr>
		<tr>
			<td colspan="2"><button>회원수정</button></td>
		</tr>
	</table>
</form>
</body>
</html>