<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your details:</title>
</head>
<body>

	<h2>Your details alala:</h2>
	<br>
	<br>
	<br>
	<p> Your name: ${param.employeeName} </p>
	<p> Your name: ${nameAttr} </p>
	
	<p> Your name: ${employeeAttribute.name} </p>
	<br>
	<p> Your surname: ${employeeAttribute.surname} </p>
	<br>
	<p> Your salary: ${employeeAttribute.salary} </p>
	<br>
		<p> Your department: ${employeeAttribute.department} </p>
	<br>
			<p> Your level: ${employeeAttribute.level} </p>
	<br>
	Your language(s): 
		<ul>
			<c:forEach var="langTempVar" items="${employeeAttribute.languages }">
				<li>  List item... ${ langTempVar}</li>
			</c:forEach>
		</ul>
		 
					<p> Your phone: ${employeeAttribute.phoneNumber} </p>
	<br>

	<br>

</body>
</html>