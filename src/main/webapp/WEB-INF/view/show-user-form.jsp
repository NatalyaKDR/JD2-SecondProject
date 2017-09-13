<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>RegistrationForm</title>

<style>
.error {
	font-family: Geneva, Arial, Helvetica, sans-serif;
	font-weight: bold;
	color: red
}
</style>

</head>
<body>
	<b><i>Fill the form. Asterisk (*) required field</i></b>

	<form:form action="processForm" modelAttribute="User" method="POST">
	
	FirstName(*): <form:input placeholder="firstName" path="firstName" />
		<form:errors path="firstName" cssClass="error" />
		<br />
		<br />
	
	
	SecondName: <form:input placeholder="secondName" path="secondName" />
		<br />
		<br />
	
	
	Login(*): <form:input placeholder="login" path="login" />
		<form:errors path="login" cssClass="error" />
		<br />
		<br />
	
	
	Password(*): <form:password placeholder="password" path="password" />
		<form:errors path="password" cssClass="error" />
		<br />
		<br />
		
		
	Country:<form:select path="country">
			<form:options items="${theCountryOptions}" />
		</form:select>
		<br />
		<br /> 	
		
		
	Age: <form:select path="age">
			<form:options items="${user.theAgeOptions}" />
		</form:select>
		<br />
		<br /> 
	
	Gender:<br/>
	Gentlemen <form:radiobutton path="gender" value="M" />
	Lady <form:radiobutton path="gender" value="W" />
		<br />
		<br /> 
		
		
	Languages:
		English  <form:checkbox path="language" value="English" />
		Russian  <form:checkbox path="language" value="Russian" />
		Turkish <form:checkbox path="language" value="Turkish" />
		Italian <form:checkbox path="language" value="Italian" />
		Franch  <form:checkbox path="language" value="Franch" />
		German  <form:checkbox path="language" value="German" />
		<br />
		<br />

	
	Email(*) : <form:input placeholder="eMail" path="eMail" />
		<form:errors path="eMail" cssClass="error" />
		<br />
		<br />

		<input type="submit" value="Submit" />


	</form:form>
	
</body>
</html>