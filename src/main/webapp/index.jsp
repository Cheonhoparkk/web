<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String uiName = (String) session.getAttribute("uiName");
if(uiName == null) {
%>
<h1>안녕하세요.</h1>
<a href="/login.jsp">로그인</a>
<a href="/sign-up.jsp">회원가입</a>
<% 
}else{
%>
<h1><%=uiName%>님, 안녕하세요.</h1>
<a href="/user-info/update">정보수정</a>
<a href="/user-info/delete">회원탈퇴</a>
<a href="/user-info/logout">로그아웃</a>

<%
}
%>
</body>
</html>