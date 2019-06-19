<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::List::</title>

<style>
.body {
	margin-top: 30px;
}

h2 {
	margin-left: 30px;
	color: red;
}

table {
	margin-left: 30px;
	border: 1px solid black;
}

</style>

</head>
<body>
	<h2>Students List</h2>
	<div class="container">
		<div class="row">
			<div class="span">
				<form method="get" action="find" class="form-inline">
					<input name="first_name" type="text" placeholder="Name"> <input
						name="last_name" type="text" placeholder="Last Name">
					<button type="submit" class="btn">Search</button>
				</form>
			</div>
		</div>
		
		<br>
		<br>

		<div class="row">
			<table
				class="table table-bordered table-striped table-hover table-condensed table-responsive">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Last Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listStudents}" var="student">
						<tr>
							<td>${student.id}</td>
							<td>${student.firstName}</td>
							<td>${student.lastName}</td>
							<td>
							<a href="./delete/${student.id}" class="btn" role="button">Delete student</a>
							<a href="./edit/${student.id}" class="btn" role="button">Edit student</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
				<a href="./newstudent">Add new student</a>
	</div>


</body>
</html>