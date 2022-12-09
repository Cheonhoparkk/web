<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.web.DBCon"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("UTF-8");
String uiId = request.getParameter("uiId");
String uiPwd = request.getParameter("uiPwd");
String sql = "SELECT * FROM USER_INFO WHERE UI_ID=? AND UI_PWD=?";
Connection con = DBCon.getConnection();
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, uiId);
pstmt.setString(2, uiPwd);
ResultSet rs = pstmt.executeQuery();
if(rs.next()) {
	session.setAttribute("uiName", rs.getString("UI_NAME"));
	session.setAttribute("uiNum", rs.getString("UI_NUM"));
	session.setAttribute("uiAddr", rs.getString("UI_ADDR"));
%>
<script>
	alert('로그인 완료');
	location.href='/';
</script>
<%
}else{
%>
<script>
	alert('아이디나 비밀번호가 잘못되었습니다.')
	location.href='/login.jsp';
</script>

<% 
}
%>
<%=uiId%><br>
<%=uiPwd%><br>
