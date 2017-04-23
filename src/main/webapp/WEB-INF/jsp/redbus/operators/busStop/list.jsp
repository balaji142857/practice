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
		<a href='<c:url value="/redbus/operators/${operatorId}/busStops/new"/>' class="btn btn-primary">
		        <i class="fa fa-ban" aria-hidden="true"></i> Add Stop
	    </a>
		<br><br><br>
		
		<table class="table table-striped table-condensed">
			<thead>
				<tr>
					<th>Id</th>
					<th>Place</th>
					<th>Day</th>
					<th>Arrival</th>
					<th>Departure</th>
					<th>Options</th>
				</tr>
			</thead>
			<tbody>
			<c:out value="${busStops.size()} is the bus stops size"/>
				<c:forEach items="${busStops}" var="currentStop">
					<tr>
						<td>${currentStop.id}</td>
						<td>${currentStop.place.display}</td>
						<td>${currentStop.day}</td>
						<td>${currentStop.arrival}</td>
						<td>${currentStop.departure}</td>
						<td>
							<a class="btn btn-success btn-sm" href='<c:url value="/redbus/operators/busStops/${currentStop.id}/edit"/>'>
								<span class="glyphicon glyphicon-pencil"></span>
							</a>
							<a class="btn btn-danger btn-sm" href='<c:url value="/redbus/operators/busStops/${currentStop.id}/delete"/>'>
								<span class="glyphicon glyphicon-remove"></span>
							</a>							
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>