<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 table로 표시</title>
</head>
<body>
	<%!public String  SelectJob(int jobs) {
		String jobName = "";
		
		switch(jobs) {
		case 1:
			jobName = "선생님";
			break;
		case 2:
			jobName = "학생";
			break;
		case 3:
			jobName = "학부모";
			break;
		}
		
		return jobName;
	}
	
	public String CheckGender(int gender){
		String genderch ="";
		
		 switch (gender) {
	        case 0:
	            genderch = "남자";
	            break;
	        case 1:
	            genderch = "여자";
	            break;
	        }
	 
	        return genderch;
	}
	%>
	<%
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        int job = Integer.parseInt(request.getParameter("job"));
        String pw = request.getParameter("pass");
        int gender = Integer.parseInt(request.getParameter("gender"));
	
        out.print("<tr>");
        out.print("<th>" + "이름" + "</th>");
        out.print("<th>" + "ID" + "</th>");
        out.print("<th>" + "PW" + "</th>");
        out.print("<th>" + "성별" + "</th>");
        out.print("<th>" + "직업" + "</th>");
        out.print("</tr>");
 
        out.println("<td>" + name + "</td>");
        out.println("<td>" + id + "</td>");
        out.println("<td>" + pw + "</td>");
        out.println("<td>" + CheckGender(gender) + "</td>");
        out.println("<td>" + SelectJob(job) + "</td>");
    %>
</body>
</html>