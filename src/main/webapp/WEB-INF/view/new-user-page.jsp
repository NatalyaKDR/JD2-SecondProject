<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>New user was successfully registered with the following data :
	</h3>
	<br />
	<div>
		<ul>
			<li>First name : ${User.firstName}</li>

			<li>Second name : ${User.secondName}</li>

			<li>Login: ${User.login}</li>

			<li>Password : ${User.password}</li>

			<li>Gender : ${User.gender}</li>

			<li>Country: ${User.country}</li>

			<li>Age : ${User.age}</li>

			<li>Email: ${User.eMail}</li>

			<li>Language :
				<ul>
					<c:forEach var="temp" items="${User.language}">
						<li>${temp}</li>
					</c:forEach>
				</ul>
			</li>
		</ul>
	</div> 
	<br>
<a href="http://localhost:8080/task02-project/user/showRegistrationForm" title ="Registration">Back to the registration form</a>
<br>
<br>
<a href="http://localhost:8080/task02-project/" title ="Main page">Back to the main page</a>

</body>
</html>