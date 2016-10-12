<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		Write 폼
		<form method="post" action="/myapp/exam05/write">
			게시물 번호: <input type="number" name="bno" value="1"/><br />
			제목: <input type="text" name="btitle" value="제목"/><br />
			내용: <input type="text" name="bcontent" value="글내용"/><br />
			조회수: <input type="number" name="bhitcount" value="5"/><br />	
			<input type="submit" name="submit" value="전송"/> <br />
		</form>
	</body>
</html>