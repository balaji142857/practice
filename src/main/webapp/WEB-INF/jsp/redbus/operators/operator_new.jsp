<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>${pageTitle}</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	<div class="container">
	
	<!-- display any message from server -->
	<c:if test="${message !=null && message.length() > 0}">
		<div class="alert alert-info">${message}</div>
	</c:if>
	<div class="alert alert-info">status:<br> editRequest: ${editRequest} <br>editExistingRequest: ${editExistingRequest}</div>
	
	
	<c:url value="/redbus/operators/confirm" var="confirmURL"/>
	<form:form action="${confirmURL}" method="post" modelAttribute="newOperator">
	
		<!-- if request is to edit a new operator while creating or to edit an already created operator-->
		<c:if test="${editRequest}">
			<input type="hidden" name="editRequest" value="true">
		</c:if>
		<c:if test="${editExistingRequest}">
			<input type="hidden" name="editExistingRequest" value="true">
		</c:if>
	
		<!-- actual form components -->
		<form:hidden path="id"/>
		<div class="form-group">
			<label for="name">Name:</label>
			<form:input id="name" path="name" cssClass="form-control" />
			<form:errors path="name" cssClass="form-control error" />
		</div>
		
		<div class="form-group">
			<label for="contactName">contactName:</label>
			<form:input id="contactName" path="contactName" cssClass="form-control" />
			<form:errors path="contactName" cssClass="form-control error" />
		</div>
 
		<div class="form-group">
			<label for="contactNumber">contactNumber:</label>
			<form:input id="contactNumber" path="contactNumber" cssClass="form-control" />
			<form:errors path="contactNumber" cssClass="form-control error" />
		</div>
		
		<div class="form-group">
			<label for="headOfficeAddress">headOfficeAddress:</label>
			<form:input id="headOfficeAddress" path="headOfficeAddress" cssClass="form-control" />
			<form:errors path="headOfficeAddress" cssClass="form-control error" />
		</div>
 				
		<div class="form-group">
			<label for="email">email:</label>
			<form:input id="email" path="email" cssClass="form-control" />
			<form:errors path="email" cssClass="form-control error" />
		</div>
		<div class="">
			<c:choose>
				<c:when test="${editRequest || editExistingRequest}">
					<input type="submit" value="edit" class="btn btn-primary">
				</c:when>
				<c:otherwise>
					<input type="submit" value="create" class="btn btn-primary">
				</c:otherwise>
			</c:choose>
			
			<div class="divider"></div>
			<input type="reset" value="reset" class="btn btn-primary">
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