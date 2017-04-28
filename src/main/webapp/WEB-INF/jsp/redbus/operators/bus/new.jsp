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
		<c:url value="/redbus/operators/${operatorId}/buses/confirm" var="confirmURL"/>
	
		<form:form action="${confirmURL}" method="post" modelAttribute="newBus" class="form-horizontal">

			<form:hidden path="id"/>
			<div class="form-group">
				<label for="email" class="control-label col-sm-4">Model</label>
				<div class="col-sm-8">
					<form:input path="model" id="model" cssClass="form-control"/>
					<form:errors path="model" cssClass="form-control error" />
				</div>
			</div>

			<div class="form-group">
				<label for="seatCapacity" class="control-label col-sm-4">Registration Number</label>
				<div class="col-sm-8">
					<form:input path="regNumber" id="regNumber" cssClass="form-control"/>
					<form:errors path="regNumber" cssClass="form-control error" />
				</div>
			</div>
						
			<div class="form-group">
				<label for="seatCapacity" class="control-label col-sm-4">Seating Capacity</label>
				<div class="col-sm-8">
					<form:input path="seatCapacity" id="seatCapacity" cssClass="form-control"/>
					<form:errors path="seatCapacity" cssClass="form-control error" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="chargingAvailable" class="control-label col-sm-4">Features</label>
				<div class="col-sm-8">
					<label class="checkbox-inline">
						<form:checkbox path="chargingAvailable" id="chargingAvailable"/>
						<form:errors path="chargingAvailable" cssClass="form-control error" />
						Mobile Charging
					</label>
					<label class="checkbox-inline">
						<form:checkbox path="gpsTrackingAvailable" id="gpsTrackingAvailable"/>
						<form:errors path="gpsTrackingAvailable" cssClass="form-control error" />
						GPS Tracking
					</label>
				</div>
			</div>
						
		 
		 	<div class="form-group">
				<label for="seatCapacity" class="col-sm-4 control-label">Bus Type</label>
				<div class="col-sm-8">
					<form:errors path="busType" cssClass="form-control error" />
					<ul class="verticalRadios">				
						<form:radiobuttons path="busType" items="${busTypes}" element="li"/>
					</ul>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-4"></div>
				<div class="col-sm-8">
				<c:choose>
					<c:when test="${editExisting}">
						<input type="submit" value="edit" class="btn btn-primary">
						<input type="hidden" name="editExistingRequest" value="true">
					</c:when>
					<c:otherwise>
						<input type="submit" value="create" class="btn btn-primary">
					</c:otherwise>
				</c:choose>
					
					
					<input type="reset" value="reset" class="btn btn-primary">
					<a href='<c:url value="/redbus/operators/${operatorId}/buses/list"/>' class="btn btn-primary">Cancel</a>
				</div>
			</div>
	</form:form>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>

</html>

