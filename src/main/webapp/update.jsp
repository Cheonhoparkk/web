<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String uiNum = (String) session.getAttribute("uiNum");
if(uiNum==null){
	response.sendRedirect("/");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
</head>
<body>
	<form method="POST" action="/sign-up_ok.jsp">
		<input type="hidden" name="uiNum" value="<%=uiNum%>"> 
		<input type="text" name="uiName" placeholder="이름" value=""><br> 
		<input type="text" name="uiId" placeholder="아이디" value="" readonly><br>
		<input type="password" name="uiPwd" placeholder="비밀번호"><br>
		<input type="text" name="uiAddr" placeholder="주소"><br> 
		<input type="email" name="uiEmail" placeholder="이메일"><br>
		<button>수정완료하기</button>
	</form>
</body>
</html>