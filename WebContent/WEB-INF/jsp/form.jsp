<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::New Student::</title>

<style>
.body {
	margin-top: 30px;
}
</style>

</head>
<body>

	<div class="container">
		<div class="row">
			<form:form method="POST" action="${not empty op ? '../edit' : 'addstudent'}"
				modelAttribute="studentForm">
				<form:hidden path="id"/>
				<table>
					<tr>
						<td><form:label path="firstName">Name</form:label></td>
						<td><form:input path="firstName"></form:input></td>
					</tr>
					<tr>
						<td><form:label path="lastName">Last Name</form:label></td>
						<td><form:input path="lastName"></form:input></td>
					</tr>
					<tr>
						<td><input type="submit" value="Submit" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>

</body>
</html>