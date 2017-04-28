<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Edit User</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	<div class="container">
		<form:form method="post" action="${editRole.id}/edit"
			modelAttribute="editRole">
		
		<div class="form-group">
				<label for="name">Role Name:</label>
				<form:input id="name" path="name" cssClass="form-control" />
				<form:errors path="name" cssClass="form-control error" />
		</div>
		
	
			<form:input path="id" readonly="true" cssClass="form-control"/>
			
			<input type="submit" name="edit" value="Edit" class="btn btn-primary">
			<input type="reset" value="reset" class="btn btn-primary">
			<br>
		</form:form>
		<c:if test="${empty usersInRole}">
			<form method="post" action="${editRole.id}/delete">
				<input type="submit" name="delete" value="Delete" class="btn btn-danger">
				 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			</form>
		</c:if>
		
		<table class="table table-striped table-condensed">
			<thead>
				<tr>
					<th>Id</th>
					<th>User Name</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
		
		<c:forEach items="${usersInRole}" var="currentUser">
			<tr>
				<td><a href='<c:url value="/users/${currentUser.id}"/>'>${currentUser.id}</a></td>
				<td><a href='<c:url value="/users/${currentUser.id}"/>'>${currentUser.username}</a></td>
				<td><a href='<c:url value="/users/${currentUser.id}"/>'>${currentUser.email}</a></td>
			</tr>		
		</c:forEach>
		
		</tbody>
		</table>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>