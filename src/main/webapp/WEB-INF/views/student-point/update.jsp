<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
function check(){
	let spName = document.querySelector('[name="spName"]');
	//alert(spName.trim().length);
	if(spName.trim( ).length<2){
		alert('이름을 확인해주세요.');
		spName.value = '';
		spName.focus();
		return false;
	}
	
	let spKorPoint = document.querySelector('[name="spKorPoint"]');
	if(isNaN((parseInt(spKorPoint.value))){
		alert('국어점수는 숫자만 가능합니다.');
		spKorPoint.value = '';
		spKorPoint.focus();
		return flase;
	}
	
	let spEngPoint = document.querySelector('[name="spEngPoint"]');
	if(isNaN((parseInt(spEngPoint.value))){
		alert('영어점수는 숫자만 가능합니다.');
		spEngPoint.value = '';
		spEngPoint.focus();
		return flase;
	}
	
	let spMathPoint = document.querySelector('[name="spMathPoint"]');
	if(isNaN((parseInt(spMathPoint))){
		alert('수학점수는 숫자만 가능합니다.');
		spMathPoint.value = '';
		spMathPoint.focus();
		return false;
	}

	return false;
}
</script>
<form method="post" action="/student-point/insert" onsubmit="return check()">
<table border="1">
	<tr>
		<th>이름</th>
		<th><input type="text" name="spName"></th>
	</tr>
	<tr>
		<th>국어점수</th>
		<th><input type="text" name="spKorPoint"></th>
	</tr>
	<tr>
		<th>영어점수</th>
		<th><input type="text" name="spEngPoint"></th>
	</tr>
	<tr>
		<th>수학점수</th>
		<th><input type="text" name="spMathPoint"></th>
	</tr>
	<tr>
		<th>특이사항</th>
		<th><input type="text" name="spProfile"></th>
	</tr>
	<tr>
		<th colspan="2"><button>등록</button></th>
	</tr>
	
</table>
</form>
</body>
</html>