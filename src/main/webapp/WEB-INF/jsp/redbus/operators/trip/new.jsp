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
		<c:url value="/redbus/operators/${operatorId}/trips/confirm" var="confirmURL"/>
	
		<form:form action="${confirmURL}" method="post" modelAttribute="newTrip" class="form-horizontal">

			<form:hidden path="id"/>
			
			<div class="form-group">
				<label for="route" class="control-label col-sm-4">Select Route</label>
				<div class="col-sm-8">
					<form:select path="route" id="route" 
								 items="${availableRoutes}"
								 itemLabel="displayName"
								 itemValue="id"
								 cssClass="form-control"/>
					<form:errors path="route" cssClass="form-control error" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="message" class="control-label col-sm-4">Select Bus</label>
				<div class="col-sm-8">
				 	<form:select path="bus"
							 	 items="${newTrip.operator.buses}"
							 	 itemLabel="regNumber"
							 	 itemValue="id"
							 	 id="bus"  
							 	 cssClass="form-control"/>
					<form:errors path="bus" cssClass="form-control error" />
				 </div>
			</div>
			
			<div class="form-group">
				<label for="tripDate" class="control-label col-sm-4">Trip Date</label>
				<div class="col-sm-8">
						 	<input type="date" id="tripDate" class="form-control" name="tripDate">
					<%-- <form:input path="tripDate" id="tripDate" cssClass="form-control"/> --%>
					<form:errors path="tripDate" cssClass="form-control error" />
				</div>
			</div>			

			
			<div class="form-group">
				<div class="col-sm-4"></div>
				<div class="col-sm-8">
					<input type="submit" value="create" class="btn btn-primary">
					<input type="reset" value="reset" class="btn btn-primary">
					<a href='' class="btn btn-primary">Cancel</a>
				</div>
			</div>
	</form:form>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>

</html>

