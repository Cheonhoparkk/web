<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 입력폼</title>
</head>
<body>
	<h2>회원정보 입력하기</h2>
	<table>
		<form action="/userInfoTable.jsp" method="post">
			<tr>
				<td>이름:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>PW:</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td>성별:</td>
				<td><input type="radio" name="gender" value="0" checked>남자
                    <input type="radio" name="gender" value="1">여자</td>
			</tr>
			<tr>
				<td>직업:</td>
				<td align="center" colspan=1><select name="job">
                        <option value="1">선생님</option>
                        <option value="2">학생</option>
                        <option value="3">학부모</option>
                </select></td>
			</tr>
			<tr>
                <td align="center" colspan=2><input type="submit" value="입력">
                    <input type="reset" value="취소"></td>
		</form>
	</table>
</body>
</html>