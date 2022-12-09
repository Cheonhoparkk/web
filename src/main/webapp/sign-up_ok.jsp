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

out.println("<br>uiName :" + uiName);
out.println("<br>uiId :" + uiId);
out.println("<br>uiPwd :" + uiPwd);
out.println("<br>uiAddr :" + uiAddr);
out.println("<br>uiEmail :" + uiEmail);

String sql = "INSERT INTO USER_INFO(UI_NAME, UI_ID, UI_PWD, UI_ADDR, UI_EMAIL)";
sql += " VALUES(?,?,?,?,?)";

Connection con = DBCon.getConnection();
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, uiName);
pstmt.setString(2, uiId);
pstmt.setString(3, uiPwd);
pstmt.setString(4, uiAddr);
pstmt.setString(5, uiEmail);
int result = pstmt.executeUpdate();
if(result==1){
%>

<script>
	alert('<%=uiName%>님 정상적으로 회원가입이 되었습니다.\r\n 로그인 페이지로 이동합니다.');
	location.href='/login.jsp';
</script>
<%
}

%>
