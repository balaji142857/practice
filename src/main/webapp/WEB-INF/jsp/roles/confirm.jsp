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
		<form:form method="post" action="new" modelAttribute="newRoleReview">

			<div class="form-group">
				<label for="name">Role Name:</label>
				<form:input id="name" path="name" cssClass="form-control" readonly="true" />
				<form:errors path="name" cssClass="form-control error" />
			</div>


			<input type="submit" value="confirm" class="btn btn-primary">
			<input type="submit" name="edit" value="edit" class="btn btn-warning">

		</form:form>

		<a href='<c:url value="/roles/"/>'>Cancel</a> <a
			href='<c:url value="/"/>'>Home</a>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>