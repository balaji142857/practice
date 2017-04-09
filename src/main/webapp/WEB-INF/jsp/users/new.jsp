<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Create User</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	<div class="container">
		<form:form method="post" action="confirm" modelAttribute="newUser">


		<div class="form-group">
				<label for="email">Email:</label>
				<form:input id="email" path="email" cssClass="form-control" />
				<form:errors path="email" cssClass="form-control error" />
		</div>

		<div class="form-group">
				<label for="username">Username:</label>
				<form:input id="username" path="username" cssClass="form-control" />
				<form:errors path="username" cssClass="form-control error" />
		</div>

		<div class="form-group">
				<label for="password">Password:</label>
				<form:password id="password" path="password" cssClass="form-control" />
				<form:errors path="password" cssClass="form-control error" />
		</div>
		
		<div class="form-group">
				<label for="firstName">firstName:</label>
				<form:input id="firstName" path="firstName" cssClass="form-control" />
				<form:errors path="firstName" cssClass="form-control error" />
		</div>
		
		<div class="form-group">
				<label for="username">LastName:</label>
				<form:input id="lastName" path="lastName" cssClass="form-control" />
				<form:errors path="lastName" cssClass="form-control error" />
		</div>			
	
		<div class="form-group">
				<label for="roles">Roles</label>
				<form:select path="authorities" items="${availableRoles}" cssClass="form-control" />
				<form:errors path="authorities" cssClass="form-control error" />
		</div>	

			<input type="submit" value="create" class="btn btn-primary">
			<input type="reset" value="reset" class="btn btn-warning">
		</form:form>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>