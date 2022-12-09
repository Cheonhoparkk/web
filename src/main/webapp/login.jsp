<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
</head>
<body>
<form method="POST" action="/login_ok.jsp">
	<input type="text" name="uiId" placeholder="ID를 입력해주세요">
	<input type="password" name="uiPwd" placeholder="비밀번호를 입력해주세요">
	<button>LogIn</button>
</form>

</body>
</html>