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
	
	
	<c:url value="/redbus/operators/${operatorId}/buses/new" var="confirmURL"/>
	
	<div class="container">
		<form:form action="${confirmURL}" method="post" modelAttribute="validatedBus" class="form-horizontal">
			<form:hidden  path="id"/>
			<div class="form-group">
				<label for="model" class="control-label col-sm-4">Model:</label>
				<div class="col-sm-8">
					<form:input id="model" path="model" cssClass="form-control" readonly="true"/>
				</div>
			</div>
			<div class="form-group">
				<label for="regNumber" class="control-label  col-sm-4">Registration Number:</label>
				<div class="col-sm-8">
					<form:input id="regNumber" path="regNumber" cssClass="form-control" readonly="true"/>
				</div>
			</div>			
			<div class="form-group">
				<label for="busType" class="control-label  col-sm-4">Bus Type</label>
				<div class="col-sm-8">
					<form:input id="busType" path="busType" cssClass="form-control" readonly="true"/>
				</div>	
			</div>
			
			<div class="form-group">
				<label for="seatCapacity" class="control-label  col-sm-4">Seat Capacity</label>
				<div class="col-sm-8">
					<form:input id="seatCapacity" path="seatCapacity" cssClass="form-control" readonly="true"/>
				</div>	
			</div>	
			
			<div class="form-group">
				<label for="features" class="control-label col-sm-4">Features</label>
				<div class="col-sm-8">
					<c:if test="${validatedBus.chargingAvailable}">
						<span class="label label-info">Charging</span>
					</c:if>
					<c:if test="${validatedBus.gpsTrackingAvailable}">
						<span class="label label-info">GPS Tracking</span>
					</c:if>					
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-4"></div>
				<div class="col-sm-8">
					<input type="submit" value="create" class="btn btn-primary">
					<input type="submit" name="edit" value="edit" class="btn btn-primary">	
				</div>
			</div>			
		</form:form>
	</div>
	
	
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>