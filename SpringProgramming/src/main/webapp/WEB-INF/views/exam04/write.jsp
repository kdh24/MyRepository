<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		게시물 쓰기
		<hr/>
		<form method="post" action="/myapp/exam04/write">
			제목: <input type="text"  /><br />
			내용: <textarea row="5" cols="20" name="bcountent"'wk)><br />
			<input type="submit"  value="글쓰기"/> <br />
		</form>
	</body>
</html>