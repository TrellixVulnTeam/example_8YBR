<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bootstrap Navbar</title>
<link rel="stylesheet"
	href="/html-example/javascript/bootstrap-3.3.2-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/html-example/javascript/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css">
<script src="/html-example/javascript/jquery-2.1.4/jquery-2.1.4.min.js"></script>
<script
	src="/html-example/javascript/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<nav role="navigation" class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-header">
			<p class="navbar-text navbar-left">Text</p>
		</div>
	</nav>
	<c:forEach var="i" begin="0" end="100">
		<c:out value="${i}" />
		<br />
	</c:forEach>
</body>
</html>