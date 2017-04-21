<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Roles</title><%@ page isELIgnored="false"%>

</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	<div class="container">
		<!-- both added and edited should return to this page with a success message -->
		<c:if test="${message !=null && message.length() > 0}">
			<div class="alert alert-info">${message}</div>
		</c:if>
		<br>
		
		<form:form method="post" action="confirm" modelAttribute="newRole">
			<div class="form-group">
				<label for="name">Role Name:</label>
				<form:input id="name" path="name" cssClass="form-control" />
				<form:errors path="name" cssClass="form-control error" />
			</div>
			<input type="submit" value="create" class="btn btn-primary">
			<input type="reset" value="reset" class="btn btn-primary">
		</form:form>

		<table class="table table-striped table-condensed">
			<thead>
				<tr>
					<th>Id</th>
					<th>Role Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${availableRoles}" var="currentRole">
					<tr>
						<td><a href='<c:url value="/roles/${currentRole.id}"/>'>${currentRole.id}</a>
						<td><a href='<c:url value="/roles/${currentRole.id}"/>'>${currentRole.name}</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>