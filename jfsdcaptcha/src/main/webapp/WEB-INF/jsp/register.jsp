<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding = "UTF-8" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<! DOCTYPE html>

<html>
<head>
<title>Captcha Spring Boot </title>
<head>
<body>
	<h1> Register User </h1>
	<form:form action = "save" method = "post">
		Name: <form:input path = "name" /> <br/>
		Email: <form:input path = "email" /> <br/>
		<form:hidden path = "hiddenCaptcha"/>
		Captcha: <img src = "data:real/jpg;base64, ${command.realCaptcha}" /> <br/>
		Captcha Input: <form:input path = "captcha" /> <br/>
		<input type = "submit" value = "register" />
	</form:form>
	${message}
</body>
</html>