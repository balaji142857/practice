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
	
	<div class="panel panel-primary panel-modest">
		<div class="panel-heading">Operator info</div>
		<div class="panel-body">
		id: ${operator.id}<br>
		Contact Person : ${operator.contactName}<br>
		Contact Number : ${operator.contactNumber}<br>
		Office Address : ${operator.headOfficeAddress}<br>
		eMail Address : ${operator.email}<br>
		Buses count : ${operator.buses.size()}<br>  
		</div>
	</div>
	<br>
		
	<a class="btn btn-primary" href='<c:url value="/redbus/operators/${operator.id}/buses/new"/>'>Add bus</a>
	<a class="btn btn-primary" href='<c:url value="/redbus/operators/${operator.id}/busStops/new"/>'>Add BusStop</a>
	<a class="btn btn-primary" href='<c:url value="/redbus/operators/${operator.id}/routes/new"/>'>Add Route</a>
	<br>
		<c:choose>
			<c:when test="${empty operator.buses}">
				<br><div class="alert alert-info">No Buses registered so far</div>
			</c:when>
			<c:otherwise>
				<br>
				<h4>Registered Buses</h4>
				<c:forEach items="${operator.buses}" var="currentBus">
					<div class="panel panel-primary panel-modest">
						<div class="panel-heading">${currentBus.regNumber}</div>
						<div class="panel-body">
							model : 			${currentBus.model}<br>
							seatCapacity : ${currentBus.seatCapacity}<br>
							busType	     : ${currentBus.busType}<br>
							facilities : 
							<c:if test="${currentBus.chargingAvailable}">
								<span class="label label-info">Charging</span>
							</c:if>
							<c:if test="${currentBus.gpsTrackingAvailable}">
								<span class="label label-info">GPS Tracking</span>
							</c:if>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${empty operator.routes}">
				<br><div class="alert alert-info">No routes registered so far</div>
			</c:when>
			<c:otherwise>
			<h4><u>Registered Routes</u></h4>
				<c:forEach items="${operator.routes}" var="currentRoute">
					<div class="panel panel-primary panel-modest">
						<div class="panel-heading">${currentRoute.name}</div>
						<div class="panel-body">
						 id: ${currentRoute.id} <br>
						 Origin: ${currentRoute.origin.displayName} <br>
						 Destination: ${currentRoute.destination.displayName} <br>
						 stops: ${currentRoute.stops.size()} <br>
						 journeyTime: ${currentRoute.journeyTime} <br>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>