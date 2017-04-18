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
		contactName:${operator.contactName}<br>
		contactNumber:${operator.contactNumber}<br>
		headOfficeAddress:${operator.headOfficeAddress}<br>
		email:${operator.email}<br>
		buses:${operator.buses}<br>  
		</div>
	</div>
	
	
	
	horizontal line	
	<div class="container">
	<a class="btn btn-primary" href='<c:url value="/redbus/operators/${operator.id}/buses/new"/>'>Register bus</a>
		<c:choose>
			<c:when test="${null != operator.buses}">
				<div class="altert -alert-info">No buses registered so far.</div>
			</c:when>
			<c:otherwise>
				<c:forEach items="operator.buses" var="currentBus">
					<div class="panel panel-primary panel-modest">
						<div class="panel-heading">${currentBus.model}</div>
						<div class="panel-body">
							seatCapacity : ${currentBus.seatCapacity}<br>
							busType	     : ${currentBus.busType}
							<c:if test="${currentBus.isChargingAvailable}">
								<span class="label label-primary">Charging</span>
							</c:if>
							<c:if test="${currentBus.isGPSTrackingAvailable}">
								<span class="label label-primary">GPS Tracking</span>
							</c:if>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
	
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>