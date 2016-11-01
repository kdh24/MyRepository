<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>	
		  <!-- 부트스트랩 css 추가 -->
		  <link href="../common/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
		  <script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
		    <!-- 부트스트랩 jquery추가하기 -->
	  	  <script type="text/javascript" src="../common/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>  
		  <style type="text/css">
	  	  	#header, #footer{
	  	  		background-color: black;
	  	  		color: white;
	  	  	}
	  	  	#content #menu {
				background-color:orange;
				padding:1em;
			}
			#content #menu  ul {
				list-style-type: none;
				padding:0;
			}
			#content #center {
				flex:1;
				padding:1em;
			}
			#container{
				height:96vh;
			}
	  	  </style>
	</head>
	<body>
		<div id="container" class="container-fluid">
			<div id="header" class="row">
				<h1>City Gallery</h1>
			  <div class="col-md-12"></div>
			</div>
			<div id="content" class="row">
			  <div id="menu" class="col-xs-12 col-md-3">
			  	<ul>
				    <li><a href="#">London</a></li>
				    <li><a href="#">Paris</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				    <li><a href="#">Tokyo</a></li>
				</ul>
			  </div>
			  <div id="center"  class="col-xs-12 col-md-9">
				<h1>London</h1>
				<p>London is the capital city of England. It is the most populous city in the  United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>
				<p>Standing on the River Thames, London has been a major settlement for two millennia, its history going back to its founding by the Romans, who named it Londinium.</p>
			  </div>
			</div>
			<div id="footer" class="row">
			  <div class="col-md-12">
			  	Copyright © W3Schools.com
			  </div>
			</div>
		</div>
	</body>
</html>