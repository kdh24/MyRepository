<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
	</head>
	<body>
		String 객체의 메소드
		<hr />
		<script type="text/javascript">
			var v1 = "abc";
			console.log(v1.length);
			
			var v2 = "JavaScript is easy";
			console.log(v2.indexOf("easy"));
			console.log(v2.indexOf("spring"));
			console.log(v2.search("easy"));
			
			var v3 = "123456-9876543";
			console.log(v3.substring(7,14));
			console.log(v3.substr(7,7));
			console.log(v3.charAt(7));
			
			var v4 = "Please visit Microsoft!";
			var v5 = v4.replace("Microsoft", "W3Schools");
			console.log("v5: " + v5);
			
			var v6 = "10:20:30";
			var v7 = v6.split(":");
			console.log(v7[0]);
			console.log(v7[1]);
			console.log(v7[2]);
		</script>
	</body>
</html>