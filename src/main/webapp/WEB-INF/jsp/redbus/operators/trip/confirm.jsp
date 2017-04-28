<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style>
ul.verticalRadios {
  list-style-type: none;
}
</style>
<title>${pageTitle}</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	<div class="container">
		<c:url value="/redbus/operators/${operatorId}/trips/new" var="confirmURL"/>
	
		<form:form action="${confirmURL}" method="post" modelAttribute="validatedTrip" class="form-horizontal">

			<form:hidden path="id"/>
			<div class="form-group">
				<label for="name" class="control-label col-sm-4">Route Name</label>
				<div class="col-sm-8">
					<form:input path="route" id="name" cssClass="form-control" readonly="true"/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="name" class="control-label col-sm-4">Bus</label>
				<div class="col-sm-8">
					<form:input path="bus" id="name" cssClass="form-control" readonly="true"/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="name" class="control-label col-sm-4">TripDate</label>
				<div class="col-sm-8">
					<form:input path="tripDate" id="name" cssClass="form-control" readonly="true"/>
				</div>
			</div>			
			
			
			<div class="form-group">
				<div class="col-sm-4"></div>
				<div class="col-sm-8">
					<input type="submit" value="confirm" class="btn btn-primary">
					<input type="reset" value="reset" class="btn btn-primary">
				</div>
			</div>
	</form:form>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>

</html>

