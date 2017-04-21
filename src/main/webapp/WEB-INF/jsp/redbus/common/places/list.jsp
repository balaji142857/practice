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
		<a href='<c:url value="/redbus/places/new"/>' class="btn btn-primary">
		        <i class="fa fa-ban" aria-hidden="true"></i> Add place
	    </a>
		<br><br><br>
		
		<table class="table table-striped table-condensed">
			<thead>
				<tr>
					<th>Id</th>
					<th>Location</th>
					<th>City</th>
					<th>state</th>
					<th>Country</th>
					<th>landmark</th>
					<th>pincode</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${places}" var="currentPlace" varStatus="vs">
					<tr>
						<td><a href='<c:url value="/redbus/places/${currentPlace.id}/edit"/>'>${currentPlace.id}</a></td>
						<td><a href='<c:url value="/redbus/places/${currentPlace.id}/edit"/>'>${currentPlace.location}</a></td>
						<td><a href='<c:url value="/redbus/places/${currentPlace.id}/edit"/>'>${currentPlace.city}</a></td>
						<td><a href='<c:url value="/redbus/places/${currentPlace.id}/edit"/>'>${currentPlace.state}</a></td>
						<td><a href='<c:url value="/redbus/places/${currentPlace.id}/edit"/>'>${currentPlace.country}</a></td>
						<td><a href='<c:url value="/redbus/places/${currentPlace.id}/edit"/>'>${currentPlace.landmark}</a></td>
						<td><a href='<c:url value="/redbus/places/${currentPlace.id}/edit"/>'>${currentPlace.pincode}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>