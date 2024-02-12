<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style><%@include file="/WEB-INF/css/login.css"%>
</style>
<title>Login page</title>
</head>
<body>
	<br>
	<h1>Welcome to FriendsHub</h1>
	<h1>Connect with good friends world around </h1>
	<div id="form">
		<form:form action="userPage" modelAttribute="login" method="post">
			<br>
			<h2>FriendsHub</h2><br><br>
			<label class="form">Email</label><br>
			<form:input class="form" path="email" placeholder="Email" />
			<br><label class="form">Password</label><br>
			<form:input class="form" path="password" type="password" placeholder="Password" />
			<br>
			<form:button class="form" id="button" target="_self" value="submit">Login</form:button>
			<br>
			<form:button class="signup" id="button" value="submit">
				<a href="/user/adduser" target="_self">SignUp</a>
			</form:button>
		</form:form>
	</div>
</body>
</html>
