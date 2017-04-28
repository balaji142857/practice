<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Routes</title>
</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	<div class="container">
		<!-- both added and edited should return to this page with a success message -->
		<c:if test="${message !=null && message.length() > 0}">
			<div class="alert alert-info">${message}</div>
		</c:if>
		
		<br>		
		<a href='<c:url value="/redbus/operators/${operatorId}/routes/new"/>' class="btn btn-primary">
		        <i class="fa fa-ban" aria-hidden="true"></i> Add Route
	    </a>
		<br><br><br>
		<c:out value="${validatedRoute.size()} is the routes size"/>
		<table class="table table-striped table-condensed">
			<thead>
				<tr>
					<th>Id</th>
					<th>Date</th>
					<th>Bus</th>
					<th>Route</th>
					<th>Stops</th>
					<th>Options</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${trips}" var="currentTrip">
					<tr>
						<td>${currentTrip.id}</td>
						<td>${currentTrip.tripDate}</td>
						<td>${currentTrip.bus.regNumber}</td>
						<td>${currentTrip.route.displayName}</td>
						<td>${currentTrip.route.stops.size()}</td>
						<td>
							<a class="btn btn-success btn-sm" href='<c:url value="/redbus/operators/${operatorId}/routes/${currentTrip.id}/edit"/>'>
								<span class="glyphicon glyphicon-pencil"></span>
							</a>
							<a class="btn btn-danger btn-sm" href='<c:url value="/redbus/s/${operatorId}/busStops/${currentRoute.id}/delete"/>'>
								<span class="glyphicon glyphicon-remove"></span>
							</a>						
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class = "pager">
		   <li class = "previous"><a href = '<c:url value="/redbus/operators/${operatorId}/trips/list?pageNumber=${currentPage-1}"/>'>&larr; Previous</a></li>
		   <li class = "next"><a href ='<c:url value="/redbus/operators/${operatorId}/trips/list?pageNumber=${currentPage+1}"/>'>Next &rarr;</a></li>
		</ul>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>