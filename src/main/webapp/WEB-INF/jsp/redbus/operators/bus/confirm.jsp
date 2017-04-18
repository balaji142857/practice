<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Confirm details</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	
	
	<c:url value="/redbus/operators/${operatorId}/buses/new" var="confirmURL"/>
	
	<div class="container">
		<form:form action="${confirmURL}" method="post" modelAttribute="validatedBus">
			<form:hidden  path="id"/>
			<form:input id="model" path="model" cssClass="form-control" readonly="true"/>
			<form:input id="busType" path="busType" cssClass="form-control" readonly="true"/>
			<form:input id="chargingAvailable" path="chargingAvailable" cssClass="form-control" readonly="true"/>
			<form:input id="gpsTrackingAvailable" path="gpsTrackingAvailable" cssClass="form-control" readonly="true"/>
			<form:input id="seatCapacity" path="seatCapacity" cssClass="form-control" readonly="true"/>
			<input type="submit" value="create" class="btn btn-primary">
			<input type="submit" name="edit" value="edit" class="btn btn-primary">
		</form:form>
	</div>
	
	
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>