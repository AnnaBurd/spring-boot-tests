<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ask-view JSP</title>
</head>
<body>

	<h3>List of employees in database:</h3>
	<table>
		<tr>
			<th>Name</th>
			<th>Surname</th>
			<th>Department</th>
			<th>Salary</th>
		</tr>

		<c:forEach var="tempEmp" items="${allEmpAttr}">
			<tr>
				<td>${tempEmp.name}</td>
				<td>${tempEmp.surname}</td>
				<td>${tempEmp.department}</td>
				<td>${tempEmp.salary}</td>
			</tr>
		</c:forEach>
	</table>

	<br>

	<input type="button" value="Add new Emp"
		onclick="window.location.href='addNewEmployee'">


</body>
</html>