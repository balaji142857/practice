<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Edit User Info</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	<div class="container">
	<c:url value="/users/${userToEdit.id}/edit" var="postURL"/>
	<c:out value="${postURL} is the form post url"></c:out>	
		<form:form action="${postURL}" method="post" modelAttribute="userToEdit" cssClass="form-horizontal">

			<div class="form-group">
				<label class="control-label col-sm-2" for="username">User Name:</label>
				<div class="col-sm-10">
					<form:input id="username" path="username"
						cssClass="form-control col-sm-6" />
					<form:errors path="username" cssClass="col-sm-4 error" />
				</div>
			</div>

			<div class="form-group">
				<label for="email" class="control-label col-sm-2">Email:</label>
				<div class="col-sm-10">
					<form:input id="email" path="email"
						cssClass="form-control col-sm-6" />
					<form:errors path="email" cssClass="error col-sm-4" />
				</div>
			</div>

			<div class="form-group">
				<label for="firstname" class="control-label col-sm-2">First
					Name:</label>
				<div class="col-sm-10">
					<form:input id="firstname" path="firstName"
						cssClass="form-control col-sm-6" />
					<form:errors path="firstName" cssClass="error col-sm-4" />
				</div>
			</div>

			<div class="form-group">
				<label for="lastName" class="control-label col-sm-2">Last
					Name:</label>
				<div class="col-sm-10">
					<form:input id="lastName" path="lastName"
						cssClass="form-control col-sm-6" />
					<form:errors path="lastName" cssClass="error col-sm-4" />
				</div>
			</div>


			<div class="form-group">
				<label for="roles" class="control-label col-sm-2">Roles:</label>
				<div class="col-sm-10">
					<form:select id="authorities" class="form-control col-sm-6" path="authorities" items="${availableRoles}"></form:select>
					<form:errors path="authorities" cssClass="error col-sm-4" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="currentRoles" class="control-label col-sm-2">Current Roles</label>
				<div class="col-sm-10">
				<c:forEach items="${userToEdit.authorities}" var="role">
						<h4 style="display: inline">
							<a href='<c:url value="/roles/${role.id}"/>'><span
								class="label label-info">${role.name}</span></a>
						</h4>
					</c:forEach>
				</div>
			</div>
			
					
			<div class="form-group">
				<input type="submit" value="Edit" class="btn btn-primary">
				<input type="reset" value="Reset" class="btn btn-warning">
			</div>
			</form:form>
			
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>