<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.web.DBCon"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String uiNum = (String) session.getAttribute("uiNum");
if(uiNum==null){
	response.sendRedirect("/");
	return;
}
Connection con =DBCon.getConnection();
String sql = "SELECT * FROM USER_INFO WHERE UI_NUM=?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1,uiNum);
ResultSet rs = pstmt.executeQuery();
rs.next();


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
</head>
<body>
	<form method="POST" action="/update-ok.jsp">
		<input type="hidden" name="uiNum" value="<%=uiNum%>"> 
		<input type="text" name="uiName" placeholder="이름" value="<%=rs.getString("UI_NAME") %>"><br> 
		<input type="text" name="uiId" placeholder="아이디" value="<%=rs.getString("UI_ID") %>" readonly><br>
		<input type="password" name="uiPwd" placeholder="비밀번호" value="<%=rs.getString("UI_PWD") %>"><br>
		<input type="text" name="uiAddr" placeholder="주소" value="<%=rs.getString("UI_ADDR") %>"><br> 
		<input type="email" name="uiEmail" placeholder="이메일" value="<%=rs.getString("UI_EMAIL") %>"><br>
		<button>수정완료하기</button>
	</form>
</body>
</html>