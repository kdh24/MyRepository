<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<style>
		#table1 {
/* 		    border-collapse: collapse; */
		    width: 100%;
		}
		
 		#table1 th, #table1 td { 
/*  			border: 1px solid black; */
 			text-align: center;
 		}
 		
 		#table1 th{
 			background-color:#4caf50;
 			color:#ffffff;
 		}
 		
 		#table1 tr:nth-child(even){
 			background-color: #a2a2a2;
 		}
		</style>
	</head>
	<body>
		table 관련  css 속성
		<hr />
		<table id="table1">
		  <tr>
		    <th>First Name</th>
		    <th>Last Name</th>
		    <th>Savings</th>
		  </tr>
		  <tr>
		    <td>Peter</td>
		    <td>Griffin</td>
		    <td>$100</td>
		  </tr>
		  <tr>
		    <td>Lois</td>
		    <td>Griffin</td>
		    <td>$150</td>
		  </tr>
		  <tr>
		    <td>Joe</td>
		    <td>Swanson</td>
		    <td>$300</td>
		  </tr>
		  <tr>
		    <td>Cleveland</td>
		    <td>Brown</td>
		    <td>$250</td>
		  </tr>
		</table>
	</body>
</html>