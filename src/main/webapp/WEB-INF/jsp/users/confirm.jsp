<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Create User</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
<body>
<c:import url="/resources/template/header.jsp"></c:import>
<div class="container">
<form:form method="post" action="new" modelAttribute="newUserReview">


	<div class="form-group">
			<label for="username">Username:</label>
			<form:input id="username" path="username" cssClass="form-control" readonly="true"/>				
	</div>
	
	<div class="form-group">
			<label for="username">FirstName:</label>
			<form:input id="firstName" path="firstName" cssClass="form-control" readonly="true"/>				
	</div>
	
	<div class="form-group">
			<label for="username">LastName:</label>
			<form:input id="lastName" path="lastName" cssClass="form-control" readonly="true"/>				
	</div>
	
	<div class="form-group">
			<label for="email">Email:</label>
			<form:input id="email" path="email" cssClass="form-control" readonly="true"/>				
	</div>	
	
	
	<div class="form-group">
		<label for="username">Roles:</label>
		<c:forEach items="${newUserReview.authorities }" var="role">
			<h4 style="display:inline"><span class="label label-info">${role.name}</span></h4> 
		</c:forEach>
	</div>
	
	<br>

	<input type="submit" value="create" class="btn btn-primary">
	<input type="reset" value="reset" class="btn btn-warning">

</form:form>
</div>
<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>