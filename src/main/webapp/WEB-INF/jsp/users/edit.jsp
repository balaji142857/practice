<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Edit User</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
<body>
<form:form method="post" action="confirm" modelAttribute="editUser">
	
	firstName :
	<form:input path="firstName"/>
	<form:errors path="firstName" cssClass="error"/>
	<br>
	
	<%-- :
	<form:input path=""/>
	<form:errors path="" cssClass="error"/>
	<br> --%>
	
	lastName:
	<form:input path="lastName"/>
	<form:errors path="lastName" cssClass="error"/>
	<br>
	
	email:
	<form:input path="email"/>
	<form:errors path="email" cssClass="error"/>
	<br>
	
	username:
	<form:input path="username"/>
	<form:errors path="username" cssClass="error"/>
	<br>
	
	password:
	<form:password path="password"/>
	<form:errors path="password" cssClass="error"/>
	<br>
	
	role:
	<form:select path="roles" items="${roles}"/>
	<form:errors path="roles" cssClass="error"/>
	<br>


	<input type="submit" value="create">
	<input type="reset" value="reset">
</form:form>

</body>
</html>