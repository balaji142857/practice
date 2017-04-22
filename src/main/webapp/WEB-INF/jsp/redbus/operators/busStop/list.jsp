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
					<th>Time</th>
				</tr>
			</thead>
			<tbody>
			<c:out value="${busStops.size()} is the bus stops size"/>
				<c:forEach items="${busStops}" var="currentStop">
					<tr>
						<td><a href='<c:url value="/redbus/${currentStop.id}/edit"/>'>${currentStop.id}</a></td>
						<td><a href='<c:url value="/redbus/${currentStop.id}/edit"/>'>${currentStop.place.display}</a></td>
						<td><a href='<c:url value="/redbus/${currentStop.day}/edit"/>'>${currentStop.day}</a></td>
						<td><a href='<c:url value="/redbus/${currentStop.time}/edit"/>'>${currentStop.time}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>