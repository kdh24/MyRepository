<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		Exam03
		<hr/>
		회원가입 폼<br />
		<form>
			아이디: <input type="text" name="mid" value="id" /> <br />
			이름 : <input type="text" name="mname" value="한그루" /><br />
			비밀번호: <input type="password" name="mpassword" /> <br />
			이메일 : <input type="email" name="memail" /><br />
			전화번호: <input type="tel" name="mtel" /><br />
			직업 : 	<input type="radio" name="job" value="학생" />학생
					<input type="radio" name="job" value="회사원" />회사원
					<input type="radio" name="job" value="공무원" />공무원<br />
			개발분야: 
				<input type="checkbox" name="mskill" value="web" />웹개발
				<input type="checkbox" name="mskill" value="system" checked />시스템개발
				<input type="checkbox" name="mskill" value="bigdata" />빅데이터개발
				<input type="checkbox" name="mskill" value="iot" checked />IoT 개발<br />
			주소:
				<select name="maddress1">
					<option>서울특별시</option>
					<option>경기도</option>
					<option selected>대구광역시</option>
					<option>부산광역시</option>
					<option>제주특별자치도</option>
				</select name="maddress2"> 
				<select>
					<option>인천시</option>
					<option>수원시</option>
					<option>용인시</option>
					<option>부천시</option>
					<option>의왕시</option>
				</select> <br />
				
				생년월일: <input type="date" name="mbirth" value="2016-09-28" />
				
		</form>
		
	</body>
</html>