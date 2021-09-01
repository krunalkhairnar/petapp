<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HCL Pet App SignIn</title>
</head>
<body>
	 <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>
        
	<form action="/user/validate" method="post" modelAttribute="uservalidate">
		User Name<input type="text" name="userName"> <br> 
		Password<input type="password" name="userPassword"> <br>
		<input type="submit" value="Login">
	</form>
	
	
</body>
</html>