<<<<<<< HEAD
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		게시물 수정
		<hr />
		<form method="post" action="/home/exam11/boardUpdate" >
			글쓴이 : <input type="text" name="bwriter" value="${board.bwriter}" /><br />
			제목 : <input type="text" name="btitle" value="${board.btitle}" /><br />
			내용: <textarea row="5" cols="20" name="bcontent" >${board.bcontent}</textarea><br />
			<input type="submit" value="글수정" /><br />
		</form>
	</body>
=======
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		게시물 수정
		<hr />
		<form method="post" action="/home/exam11/boardUpdate" >
			글쓴이: <input type="type" name="bwriter" value="${board.bwriter}" /><br />
			제목: <input type="type" name="btitle" value="${board.bwriter}" /><br />
			내용: <textarea name="bcontent" >${board.content}</textarea><br />
			<input type="submit" value="글수정" /><br />
		</form>
	</body>
>>>>>>> 6c42b574eb3cd74ec86660ad176da765d24b9e0e
</html>