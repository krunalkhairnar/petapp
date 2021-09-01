<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<link
	href="http://localhost:8080/webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="http://localhost:8080/webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="http://localhost:8080/webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<spring:url value="/user/save" var="saveURL" />
		<h2>User</h2>
		<form:form modelAttribute="userForm" method="post"
			action="${saveURL }" cssClass="form">
			<form:hidden path="userId" />
			<div class="form-group">
				<lable for="userFirstName">First Name</lable>
				<form:input path="userFirstName" cssClass="form-control"
					id="userFirstName" />
			</div>
			<div class="form-group">
				<lable for="userLastName">Last Name</lable>
				<form:input path="userLastName" cssClass="form-control"
					id="userLastName" />
			</div>
			<div class="form-group">
				<lable for="userName">User Name</lable>
				<form:input path="userName" cssClass="form-control" id="userName" />
			</div>
			<div class="form-group">
				<lable for="userPassword">User Password</lable>
				<form:input path="userPassword" cssClass="form-control"
					id="userPassword" />
			</div>

			<button type="submit" class="btn btn-primary">Save</button>
		</form:form>
	</div>
</body>
</html>