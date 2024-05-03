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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Game</title>
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
	<h1>Edit Game</h1>
	<div class="container-lg"></div>
	<form:form action="/games/${game.id }" method="post"
		modelAttribute="game">
		<input type="hidden" name="_method" value="put" />
		<form:input type="hidden" value="${userId }" path="user"></form:input>
		<form:errors path="*" />
		<div>
			<form:label path="name">Name:</form:label>
			<form:input path="name" />
		</div>
		<div>
			<form:label path="genre">Genre:</form:label>
			<form:input path="genre" />
		</div>
		<div>
			<form:label path="description">Description:</form:label>
			<form:textarea path="description" />
		</div>
		<button>Update Game</button>
	</form:form>
	</div>

</body>
</html>