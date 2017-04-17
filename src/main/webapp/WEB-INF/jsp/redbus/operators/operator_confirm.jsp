<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Confirm Operator Details</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	<!-- display any message from server -->
	<div class="container">

	<div class="alert alert-info">status:<br> editRequest: ${editRequest} <br>editExistingRequest: ${editExistingRequest}</div>		
	
	<!-- if request is for editing existing operator then post to /edit otherwise post to /new -->
	<c:choose>
		<c:when test="${editExistingRequest}">
			<c:url var="postURL" value="/redbus/operators/${validatedOperator.id}/edit"/>
		</c:when>
		<c:otherwise>
			<c:url var="postURL" value="/redbus/operators/new"/>
		</c:otherwise>
	</c:choose>	
	
	<form:form action="${postURL}" method="post" modelAttribute="validatedOperator">
		
		<form:hidden path="id"/>
		<div class="form-group">
			<label for="name">Name:</label>
			<form:input id="name" path="name" cssClass="form-control" readonly="true"/>
		</div>
		
		<div class="form-group">
			<label for="contactName">contactName:</label>
			<form:input id="contactName" path="contactName" cssClass="form-control"  readonly="true"/>
		</div>
 
		<div class="form-group">
			<label for="contactNumber">contactNumber:</label>
			<form:input id="contactNumber" path="contactNumber" cssClass="form-control"  readonly="true"/>
		</div>
		
		<div class="form-group">
			<label for="headOfficeAddress">headOfficeAddress:</label>
			<form:input id="headOfficeAddress" path="headOfficeAddress" cssClass="form-control"  readonly="true"/>
		</div>
 				
		<div class="form-group">
			<label for="email">email:</label>
			<form:input id="email" path="email" cssClass="form-control"  readonly="true"/>
		</div>
		<div class="">
			<input type="submit" name="create" value="confirm" class="btn btn-primary">
			<div class="divider"></div>
			<input type="submit" name="isEditRequest" value="edit" class="btn btn-primary">
			<div class="divider"></div>
			<c:url value="/redbus/operators/" var="operatorsList"/>
			<a href="${operatorsList}" class="btn btn-primary">
        		<i class="fa fa-cog" aria-hidden="true"></i> Cancel
	    	</a>
    	</div>
	</form:form>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>