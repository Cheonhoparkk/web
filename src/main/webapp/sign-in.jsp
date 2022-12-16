<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
</head>
<body>
<form method="POST" action="/user-info/sign-in">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="uiId"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="uiPwd"></td>
		</tr>
		<tr>
			<td colspan="2"><button>로그인</button></td>
		</tr>
	</table>
</form>
</body>
</html>