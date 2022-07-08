<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ask-view JSP</title>
</head>
<body>

	<h3>Enter new employee details:</h3>

	<form:form action="saveNewEmployee" modelAttribute="newEmpAttr">
	
	Name<form:input path="name"/><br><br>
	surname<form:input path="surname"/><br><br>
	department<form:input path="department"/><br><br>
	salary<form:input path="salary"/><br><br>
	
	<input type="submit" value = "save to database">
	
	</form:form>



</body>
</html>