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
		<c:url value="/redbus/operators/${operatorId}/buses/confirm" var="confirmURL"/>
	
	<form:form action="${confirmURL}" method="post" modelAttribute="newBus">



		<form:hidden path="id"/>
			<div class="form-group">
				<label for="email">Model:</label>
				<form:input path="model" id="model" cssClass="form-control"/>
				<form:errors path="model" cssClass="form-control error" />
			</div>

			<div class="form-group">
				<label for="seatCapacity">Registration Number:</label>
				<form:input path="regNumber" id="regNumber" cssClass="form-control"/>
				<form:errors path="regNumber" cssClass="form-control error" />
			</div>
						
			<div class="form-group">
				<label for="seatCapacity">Seating Capacity:</label>
				<form:input path="seatCapacity" id="seatCapacity" cssClass="form-control"/>
				<form:errors path="seatCapacity" cssClass="form-control error" />
			</div>
			
			<div class="form-group">
				<label for="seatCapacity">Mobile Charging</label>
				<form:checkbox path="chargingAvailable" id="chargingAvailable" cssClass="form-control"/>
				<form:errors path="chargingAvailable" cssClass="form-control error" />
			</div>
			
			<div class="form-group">
				<label for="seatCapacity">GPS Tracking</label>
				<form:checkbox path="gpsTrackingAvailable" id="gpsTrackingAvailable" cssClass="form-control"/>
				<form:errors path="gpsTrackingAvailable" cssClass="form-control error" />
			</div>			
		 
		 	<div class="form-group">
				<label for="seatCapacity">Bus Type</label>
				<form:radiobuttons path="busType" items="${busTypes}"/> <br>
				<form:errors path="gpsTrackingAvailable" cssClass="form-control error" />
			</div>
		
		<input type="submit" value="create" class="btn btn-primary">
		<input type="reset" value="reset" class="btn btn-primary">
	</form:form>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>
