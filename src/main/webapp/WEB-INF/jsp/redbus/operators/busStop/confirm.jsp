<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Confirm details</title>
<style>
ul.verticalRadios {
  list-style-type: none;
}
</style>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	
	
	<c:url value="/redbus/operators/${operatorId}/busStops/new" var="confirmURL"/>
	
	<div class="container">
		<form:form action="${confirmURL}" method="post" modelAttribute="validatedBusStop" class="form-horizontal">
			<form:hidden  path="id"/>
			<div class="form-group">
				<label for="place" class="control-label col-sm-4">Place</label>
				<div class="col-sm-8">
					<form:input path="place" id="place" cssClass="form-control" readonly="true"/>
				</div>
			</div>

			<div class="form-group">
				<label for="day" class="control-label col-sm-4">Day</label>
				<div class="col-sm-8">
					<form:input path="day" id="day" cssClass="form-control" readonly="true"/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="city" class="control-label col-sm-4">Time</label>
				<div class="col-sm-8">
					<form:input path="time" id="time" cssClass="form-control" readonly="true"/>
				</div>
			</div>
						
			<div class="form-group">
				<div class="col-sm-4"></div>
				<div class="col-sm-8">
					<input type="submit" value="confirm" class="btn btn-primary">
					<input type="submit" name="edit" value="edit" class="btn btn-primary">	
				</div>
			</div>			
		</form:form>
	</div>
	
	
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>