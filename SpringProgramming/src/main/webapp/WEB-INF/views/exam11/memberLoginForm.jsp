<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		<hr/>
		[Login 폼]<br />
		<form method="post" action="/myapp/exam11/memberLogin">
			아이디: <input type="text" name="mid" value="fall" /> <br />
			비밀번호: <input type="password" name="mpassword" value="12345" /> <br />
	
			<br />
			<input type="submit" value="로그인" />
		</form>
	</body>
</html>