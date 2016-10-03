<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	[회원 가입 폼]
	<br />
	<hr />
	<form method="post" action="/home/exam04/join">
		아이디: <input type="text" name="mid" value="fall" /> <br /> 이름 : <input
			type="text" name="mname" value="한그루" /><br /> 비밀번호: <input
			type="password" name="mpassword" value="12345" /> <br /> 이메일 : <input
			type="email" name="memail" value="email@naver.com" /><br /> 전화번호: <input
			type="tel" name="mtel" value="123-1234-1234" /><br /> 직업 : <input
			type="radio" name="mjob" value="학생" />학생 <input type="radio"
			name="mjob" checked value="회사원" />회사원 <input type="radio" name="mjob"
			value="공무원" />공무원<br /> 개발분야: <input type="checkbox" name="mskill"
			value="web" />웹개발 <input type="checkbox" name="mskill"
			value="system" checked />시스템개발 <input type="checkbox" name="mskill"
			value="bigdata" />빅데이터개발 <input type="checkbox" name="mskill"
			value="iot" checked />IoT 개발<br /> 주소: <select name="maddress1">
			<option>서울특별시</option>
			<option>경기도</option>
			<option selected>대구광역시</option>
			<option>부산광역시</option>
			<option>제주특별자치도</option>
		</select> - <select name="maddress2">
			<option>인천시</option>
			<option>수원시</option>
			<option selected>용인시</option>
			<option>부천시</option>
			<option>의왕시</option>
		</select> <br /> 생년월일: <input type="date" name="mbirth" value="2016-09-28" /><br />
		<input type="submit" value="submit" />
	</form>
</body>
</html>