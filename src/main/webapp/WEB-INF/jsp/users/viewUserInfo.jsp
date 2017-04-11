<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>View User Info</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	<div class="container">
		<form:form action="${user.id}/edit" method="post" modelAttribute="user" cssClass="form-horizontal">

			<div class="form-group">
				<label class="control-label col-sm-2" for="username">UserName:</label>
				<div class="col-sm-10">
					<form:input id="username" path="username"
						cssClass="form-control col-sm-6" readonly="readonly" />
				</div>
			</div>

			<div class="form-group">
				<label for="email" class="control-label col-sm-2">Email:</label>
				<div class="col-sm-10">
					<form:input id="email" path="email" readonly="readonly"
						cssClass="form-control col-sm-6" />
				</div>
			</div>

			<div class="form-group">
				<label for="firstname" class="control-label col-sm-2">First
					Name:</label>
				<div class="col-sm-10">
					<form:input id="firstname" path="firstName"
						cssClass="form-control col-sm-6" readonly="readonly" />
				</div>
			</div>

			<div class="form-group">
				<label for="lastName" class="control-label col-sm-2">Last
					Name:</label>
				<div class="col-sm-10">
					<form:input id="lastName" path="lastName"
						cssClass="form-control col-sm-6" readonly="readonly" />
				</div>
			</div>

			<div class="form-group">
				<label for="currentRoles" class="control-label col-sm-2">Roles:</label>
				<div class="col-sm-10">
					<c:forEach items="${user.authorities}" var="role">
						<h4 style="display: inline">
							<a href='<c:url value="/roles/${role.id}"/>'><span
								class="label label-info">${role.name}</span></a>
						</h4>
					</c:forEach>
				</div>
			</div>
			
			
			<div class="form-group">
				<label for="lastName" class="control-label col-sm-2"></label>
				<div class="col-sm-10">
					<input type="submit" value="Edit" class="btn btn-primary">
					<a href='<c:url value="/users/"/>' class="btn btn-warning">
				        <i class="fa fa-ban" aria-hidden="true"></i> Cancel
				    </a>
				</div>
			</div>
			</form:form>

			
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>