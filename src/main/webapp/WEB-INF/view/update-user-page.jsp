<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Editing user data</title>

<script type="text/javascript">
	function update(){
		var change = confirm('Do you really want to make changes?');
		if (change == true){
			
		}else{
 			document.write("You canceled the change.");
			window.history.back();
		}
		//ccылка на текущую страницу
	}
</script>

<style>
.error{
 font-family: Geneva, Arial, Helvetica, sans-serif;  
 font-weight: bold; 
 color: red
}
</style>
</head>

<body>
	<b><i>Fill the form. Asterisk (*) required field</i></b>
			
<!-- 	Форма для изменения данных пользователя // Form for changing user data -->

	<form:form action="processFormUpdate" modelAttribute="User">
	
		            <form:hidden placeholder="id" path="id"/>
			
			
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
			
		
	Email(*) : <form:input placeholder="eMail" path="eMail"/>
			   <form:errors path="eMail" cssClass="error"/>
		<br/>
		<br/>
		<input type="submit" value="Update" onclick="update()"/>
</form:form>
	
	
</body>
</html>