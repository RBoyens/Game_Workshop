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
<title>Game Details</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<ul class="nav justify-content-end">
	<li class="nav-item"><a class="nav-link active"
		aria-current="page" href="/home">Home</a></li>
	<li class="nav-item"><a class="nav-link" href="/logout">Logout</a>
	</li>
</ul>
<body>
	<div class="card" style="width: 18rem;">
		<div class="card-body">
			<h5 class="card-title">
				<c:out value="${game.name }"></c:out>
			</h5>

			<p class="card-title">
				Name:
				<c:out value="${game.name }" />
			</p>
			<p class="card-title">
				Developer:
				<c:out value="${game.user.userName }" />
			</p>
			<p class="card-title">
				Description:
				<c:out value="${game.description }" />
			</p>


			<c:choose>
				<c:when test="${loggedInUser == game.user.id }">
					<a href="/games/${game.id }/edit">Edit</a>
					<form action="/games/${game.id }" method="post">
						<input type="hidden" name="_method" value="delete" /> <input
							type="submit" value="Delete" />
					</form>
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>