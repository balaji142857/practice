<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Users</title>
</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	<div class="container">
		<!-- both added and edited should return to this page with a success message -->
		<c:if test="${message !=null && message.length() > 0}">
			<div class="alert alert-info">${message}</div>
		</c:if>
		
		<br>		
		<a href='<c:url value="/redbus/operators/${operatorId}/buses/new"/>' class="btn btn-primary">
		        <i class="fa fa-ban" aria-hidden="true"></i> Add Buss
	    </a>
		<br><br><br>
		
		<table class="table table-striped table-condensed">
			<thead>
				<tr>
					<th>Id</th>
					<th>Model</th>
					<th>Registration Number</th>
					<th>Seating Capacity</th>
					<th>Bus Type</th>
					<th>Features</th>
					<th>Options</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${buses}" var="currentBus">
					<tr>
						<td>${currentBus.id}</td>
						<td>${currentBus.model}</td>
						<td>${currentBus.regNumber}</td>
						<td>${currentBus.seatCapacity}</td>
						<td>${currentBus.busType}</td>
						<td>
							<c:if test="${currentBus.chargingAvailable}">
								<span class="label label-info">Charging</span>
							</c:if>
							<c:if test="${currentBus.gpsTrackingAvailable}">
								<span class="label label-info">GPS Tracking</span>
							</c:if>							
						</td>
						<td>
							<a class="btn btn-success btn-sm" href='<c:url value="/redbus/operators/${operatorId}/buses/${currentBus.id}/edit"/>'>
								<span class="glyphicon glyphicon-pencil"></span>
							</a>
							<a class="btn btn-danger btn-sm" href='<c:url value="/redbus/operators/${operatorId}/buses/${currentBus.id}/delete"/>'>
								<span class="glyphicon glyphicon-remove"></span>
							</a>							
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
		
		<ul class = "pager">
		   <li class = "previous"><a href = '<c:url value="/redbus/operators/${operatorId}/buses/list?pageNumber=${currentPage-1}"/>'>&larr; Previous</a></li>
		   <li class = "next"><a href ='<c:url value="/redbus/operators/${operatorId}/buses/list?pageNumber=${currentPage+1}"/>'>Next &rarr;</a></li>
		</ul>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>
