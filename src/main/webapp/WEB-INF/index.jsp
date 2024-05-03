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
<title>Game Workshop</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<h1 class="text-center">Welcome to the Game Workshop!</h1>
	<div class="container-lg">
		<h1>Register</h1>
		<form:form action="/registration" method="post" modelAttribute="user">
			<form:errors path="userName" />
			<div>
				<form:label path="userName"> User Name: </form:label>
				<form:input path="userName" />
			</div>
			<form:errors path="email" />
			<div>
				<form:label path="email">Email</form:label>
				<form:input path="email" />
			</div>
			<form:errors path="password" />
			<div>
				<form:label path="password">Password</form:label>
				<form:input path="password" type="password" />
			</div>
			<form:errors path="confirmPw" />
			<div>
				<form:label path="confirmPw">Confirm Password</form:label>
				<form:input path="confirmPw" type="password" />
			</div>
			<button>Register</button>
		</form:form>
	</div>

	<div class="container-lg">
		<h1>Login</h1>
		<form:form action="/login" method="post" modelAttribute="newLogin">
			<form:errors path="*" />
			<div>
				<form:label path="email">Email</form:label>
				<form:input path="email" />
			</div>
			<div>
				<form:label path="password">Password</form:label>
				<form:input path="password" type="password" />
			</div>
			<button>Login</button>
		</form:form>
	</div>
</body>
</html>