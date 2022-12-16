<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
</head>
<body>
<form method="POST" action="/sign-up-ok.jsp">
<input type="text" name="uiName" placeholder="이름"><br>
<input type="text" name="uiId" placeholder="아이디"><br>
<input type="password" name="uiPwd" placeholder="비밀번호"><br>
<input type="text" name="uiAddr" placeholder="주소"><br>
<input type="email" name="uiEmail" placeholder="이메일"><br>
<button>회원가입</button>
</form>
</body>
</html>