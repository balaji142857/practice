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
					<th>Name</th>
					<th>Origin</th>
					<th>Destination</th>
					<th>stops</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${routes}" var="currentRoute">
					<tr>
						<td>${currentRoute.id}</td>
						<td>${currentRoute.name}</td>
						<!-- <td></td>
						<td></td> -->
						<td>${currentRoute.stops[0].place.display}</td>
						
						<td>${currentRoute.stops[currentRoute.stops.size()-1].place.display}</td>
						<td>${currentRoute.stops.size()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>