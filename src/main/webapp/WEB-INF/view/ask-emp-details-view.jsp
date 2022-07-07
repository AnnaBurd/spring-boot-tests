<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ask-view JSP</title>
</head>
<body>

	<h2>Enter details:</h2>
	
<!-- 	<form action="showDetails" method="get"> -->
<!-- 		<input type = "text" name = "employeeName" -->
<!-- 		placeholder = "Enter name"/> -->
		
<!-- 		<input type = "submit"/> -->
<!-- 	</form> -->

	<form:form action="showDetails" modelAttribute="employeeAttribute">
		
		Name information <form:input path="name"/><form:errors path="name"/><!--  show message from annotation over name field -->
		 
		<br>
		Surname..ala <form:input path="surname"/> <form:errors path="surname"/>
		<br>
		Salary..s <form:input path="salary"/> <form:errors path="salary"/>
		<br>
		
<%-- 		Department <form:select path="department"> --%>
<%-- 				<form:option value = "department 1" label = "D1"/> --%>
<%-- 				<form:option value = "department 2" label = "department 2"/> --%>
<%-- 			</form:select> --%>
			
		Department <form:select path="department">
				<form:options items="${employeeAttribute.departmentOptions}"/>
			</form:select>
		<br>
		<br>
		
<!-- 		RadioButtonChoice - what is your knowledge level? -->
<%-- 		Level 1 <form:radiobutton path="level" value="lvl1"/> --%>
<%-- 		Level 2 <form:radiobutton path="level" value="lvl2"/> --%>
<%-- 		Level 3 <form:radiobutton path="level" value="lvl2"/>	 --%>

		RadioButtonChoice - what is your knowledge level?
		<form:radiobuttons path="level" items="${employeeAttribute.levelOptions}"/>
		
<!-- 		<br> -->
<!-- 		Foreign languages -->
<%-- 		EN <form:checkbox path="languages" value = "English"/> --%>
<%-- 		RU <form:checkbox path="languages" value = "Russian"/> --%>
<%-- 		FR <form:checkbox path="languages" value = "French"/> --%>

		<br>
		Foreign languages
	<form:checkboxes path="languages" items="${employeeAttribute.languageOptions}"/>

		<br><br><br><br>
		
		Phone number
	<form:input path="phoneNumber"/>
	<form:errors path="phoneNumber"/>
	
	<br><br>
			Email
	<form:input path="mail"/>
	<form:errors path="mail"/>
				
		<br>
		<input type="submit" value = "save my data">
		
		
		
		
	</form:form>
	

</body>
</html>