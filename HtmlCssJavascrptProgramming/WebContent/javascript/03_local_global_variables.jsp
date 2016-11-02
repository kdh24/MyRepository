<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			var v1 = "A";
			
			function fun1() {8
				var v2 = "B";
				v3 = "C";
				console.log("v1: " + v1);
				console.log("v2: " + v2);
			}
			
			function fun2() {
				console.log("v1: " + v1);
				console.log("v3: " + v3);
				console.log("v2: " + v2);
			}
			function fun3() {
				if(true) {
					var v4 = "D";					
				}
				console.log("v4: " + v4);
			}
			
		</script>
	</head>
	<body>
		지역변수와 전역변수
		<hr />
		<script type="text/javascript">
			fun1();
			console.log("-----------------");
			//fun2();
			fun3();
		</script>
	</body>
</html>