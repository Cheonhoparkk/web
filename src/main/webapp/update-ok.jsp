<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.web.DBCon"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("UTF-8");
String uiName = request.getParameter("uiName");
String uiId = request.getParameter("uiId");
String uiPwd = request.getParameter("uiPwd");
String uiAddr = request.getParameter("uiAddr");
String uiEmail = request.getParameter("uiEmail");
String uiNum = request.getParameter("uiNum");
String sql = "UPDATE USER_INFO";
sql += " SET UI_PWD=?,";
sql += " UI_NAME=?,";
sql += " UI_ADDR=?,";
sql += " UI_EMAIL=?";
sql += " WHERE UI_NUM=?";

Connection con = DBCon.getConnection();
PreparedStatement pstmt = con.prepareStatement(sql);

pstmt.setString(1,uiPwd);
pstmt.setString(2,uiName);
pstmt.setString(3,uiAddr);
pstmt.setString(4,uiEmail);
pstmt.setString(5,uiNum);
int result = pstmt.executeUpdate();
if(result==1){
	session.setAttribute("uiName", uiName);
	session.setAttribute("uiAddr", uiAddr);
%>
<script>
	alert('정보수정이 완료되었습니다.');
	location.href='/index.jsp';
</script>
<%
}else{
	session.invalidate();
%>
<script>
	alert('탈퇴한 회원입니다.');
	location.href='/';
</script>
<%
}
%>


