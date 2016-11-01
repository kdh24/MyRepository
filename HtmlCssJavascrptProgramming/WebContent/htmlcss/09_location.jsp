<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
			#div1 {
				position:absolute;
				left:100px;
				top: 200px;
				width: 100px;
				height: 100px;
				background-color: red;
			}
			
			#div2{
				width: 100px;
				height: 100px;
				background-color: blue;
			}
			#div3{
				position:fixed;
				left:300px;
				top:200px;
				width: 100px;
				height: 100px;
				background-color: red;
			}
			#div4 {
				position:relative;
				left:500px;
				top:100px;
				width: 300px;
				height: 300px;
				border:1px solid black;
			}
			#div5 {
				position:absolute;
				left:150px;
				top:150px;
				width: 50px;
				height: 50px;
				background-color: green;
			}
		</style>
	</head>
	<body>
<!-- 		location 관련  css 속성 -->
<!-- 		<hr /> -->
		<div id="div1"></div>
		<div id="div2"></div>
		<div id="div3"></div>
		
		<div id="div4">
			<div id="div5"></div>
		</div>
		<%for(int i=0; i<30; i++) {%>
			<br />
		<%} %>
	</body>
</html>