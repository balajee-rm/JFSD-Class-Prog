<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding = "UTF-8" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "core" %>

command: ${command[0].name}
<table border = "2">
	<tr>
		<th>Name</th>
		<th>Email</th>
	</tr>
	<core:forEach var = "user" items = "${command}">
		<tr>
			<td> ${user.name} </td>
			<td> ${user.email} </td>
		<tr>
	</core:forEach>
</table>