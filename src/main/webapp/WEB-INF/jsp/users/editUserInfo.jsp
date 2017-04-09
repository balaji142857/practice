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
	
		<form:form action="edit" method="post" modelAttribute="userToEdit" cssClass="form-horizontal">

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
					<form:select id="authorities" class="form-control col-sm-6" path="authoritites" items="${availableRoles}"></form:select>
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
			
			<%-- <div class="form-group">
			<label for="address" class="control-label col-sm-2">Address</label>
			<div class="col-sm-10">
			<form:errors path="info.address.*" cssClass="error col-sm-8" />
			<form:input path="info.address.contactName" cssClass="form-control col-sm-8" placeholder="contact name"/>
			<form:input path="info.address.doorNumber" cssClass="form-control col-sm-4" placeholder="door number"/>
			<form:input path="info.address.streetName" cssClass="form-control col-sm-4" placeholder="street name"/>
			<form:input path="info.address.locality" cssClass="form-control col-sm-4" placeholder="locality"/>
			<form:input path="info.address.landmark" cssClass="form-control col-sm-4" placeholder="landmark (near so and so..)"/>	  
	 		<form:input path="info.address.cityOrDistrict" cssClass="form-control col-sm-4" placeholder="City"/>	
	 		<form:input path="info.address.zipCode" cssClass="form-control col-sm-4" placeholder="postal zip code"/>
	
	 phone
	 alternatePhone
			</div>
			</div> --%>
			
					
			<div class="form-group">
				<input type="submit" value="Edit" class="btn btn-primary">
				<input type="reset" value="Reset" class="btn btn-warning">
			</div>
			</form:form>
			
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>