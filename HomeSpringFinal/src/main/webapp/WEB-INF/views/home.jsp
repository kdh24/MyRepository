<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Home</title>
		<meta charset="UTF-8">
		<style type="text/css">
			#header{margin:auto; border:1px solid red;}
		</style>
	</head>
	<body>
		<div id="header">
			<h1><a href="index">kosa</a></h1>
			<ul>
				<li>1.
					<c:if test="${login == null}">	
						<a href="<%=pageContext.getServletContext().getContextPath()%>/member/login">로그인</a>
					</c:if>
					<c:if test="${login != null}">
						<a href="<%=pageContext.getServletContext().getContextPath()%>/member/logout">로그아웃</a>
					</c:if></li>
				<li>2. <a href="${pageContext.servletContext.contextPath}/photoboard/list">포토 게시판</a></li>
			</ul>
		</div>
	</body>
</html>
