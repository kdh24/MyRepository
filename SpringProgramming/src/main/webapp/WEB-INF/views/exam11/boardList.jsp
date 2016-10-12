<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		게시물 목록
		<hr />
		[컬렉션 이용하기]<br />
 		
 		<table style="border-collapse: collapse; border:1px solid black; width:600px">
 			<tr style="background-color:#ffcc00">
 				<td style="border:1px solid black;">제목</td>
 				<td style="border:1px solid black;">내용</td>
 				<td style="border:1px solid black;">글쓴이</td>
 			</tr>
 			
 			<%-- 
 			<%List<Board> list = (List<Board>)request.getAttribute("boardlist"); %>
 			<%if(list != null) {%>
 	 		<%for(Board b : list) {%>
	 	 		<tr>
		 			<td style="border:1px solid black;"> <%=b.getBno() %></td>
		 	 		<td style="border:1px solid black;"> <%=b.getTitle() %></td>
		 	 		<td style="border:1px solid black;"> <%=b.getContent() %></td>
		 	 		<td style="border:1px solid black;"> <%=b.getHitcount() %></td>
	 	 		</tr>
 			<%}
 	 		}%>  --%>
 			
 			 <c:forEach var="board" items="${boardlist}">
 			 	<tr>
		 	 		<td style="border:1px solid black;">${board.btitle}</td>
		 	 		<td style="border:1px solid black;">${board.bcontent}</td>
		 	 		<td style="border:1px solid black;">${board.bwriter}</td>
	 	 		</tr>
 			 </c:forEach>
 		</table>
 		<br/>
	</body>
</html>