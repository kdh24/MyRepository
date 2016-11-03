<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			function changeImg1 () {
				var img1 = document.querySelector("#img1");
				img1.src = "../common/image/photo1.jpg";
			}
			
			function changeImg2() {
				var img2 = document.querySelector("#img2");
				img2.src = "../common/image/photo2.jpg";
			}
			
			function changeImg3() {
				var img3 = document.querySelector("#img3");
				img3.src = "../common/image/photo3.jpg";
			}
			
			window.onload = function() {
				var btn2 = document.querySelector("#btn2");
				btn2.onclick = changeImg2;
				
				var btn3 = document.querySelector("#btn3");
				/* btn3.addEventListener("click", function() {
					var img3 = document.querySelector("#img3");
					img3.src = "../common/image/photo3.jpg";
				}); */
				btn3.addEventListener("click", changeImg3);
			};
			
		</script>
	</head>
	<body>
		Event 처리
		<hr />
		<h3>[how1]</h3>
		<button onclick="changeImg1()">버튼1</button>
		<img id="img1" src="" width="100px" />
		
		<h3>[how2]</h3>
		<button id="btn2">버튼2</button>
		<img id="img2" src="" width="100px" />
		
		<h3>[how3]</h3>
		<button id="btn3">버튼3</button>
		<img id="img3" src="" width="100px" />
		
	</body>
</html>