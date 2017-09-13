<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Users</title>

<script type="text/javascript">
	function update(){
		var change = confirm('Do you really want to delete this user?');
		if (change == true){
			
		}else{
 			document.write("You canceled the delete.");
			window.history.back();
		}
	}
</script>
</head>
<body>

<!-- Сообщение об успешном изменении данных -->
 <h2 ><b>${message}</b></h2>
 
 <!-- Сообщение об успешном удалении данных -->
 <h2 ><b>${messageDelete}</b></h2>
 
<!--  Список пользователей -->
<c:forEach items="${users}" var="user" >
	<ul>
	<li>Name: <c:out value="${user.firstName }"/></li>
	<li>SecondName: <c:out value="${user.secondName }"/></li>
	<li>E-mail: <c:out value="${user.eMail }"/></li>
	<li>Country: <c:out value="${user.country }"/></li>
	<li>Age: <c:out value="${user.age }"/></li>
	<li>Gender: <c:out value="${user.gender }"/></li>
	<li>Login: <c:out value="${user.login }"/></li></ul>
	
	
	<form action="updateUsers">
		<input type="hidden" name="id" value="${user.id}">
<%-- 		<c:out value="${user.firstName}"/> --%>
		<input type="submit" value="Update">
	</form>
	
	<form action="deleteUser">
		<input type="hidden" name="id" value="${user.id}">
<%-- 		<c:out value="${user.firstName}"/> --%>
		<input type="submit" value="Delete" onclick="update()">
	</form>
	<br/><br/>
</c:forEach>


</body>

</html>
