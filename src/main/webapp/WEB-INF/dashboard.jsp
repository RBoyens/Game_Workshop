<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Game Workshop Dashboard</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<ul class="nav justify-content-end">
	<li class="nav-item"><a class="nav-link active"
		aria-current="page" href="games/new">Add Game</a></li>
	<li class="nav-item"><a class="nav-link" href="/logout">Logout</a>
	</li>
</ul>
<body>
	<h1>
		Welcome,
		<c:out value="${loggedInUser.userName}" />
		!
	</h1>

	<h2 class="text-center">Current Games</h2>
	<div class="container-lg">
		<h3 class="text-decoration-underline">Games</h3>

		<c:forEach var="games" items="${allGames }">
			<p>
				<a href="/games/${games.id }">${games.name }</a>
			</p>
			<p>Genre: ${games.genre }</p>
		</c:forEach>
	</div>


</body>
</html>