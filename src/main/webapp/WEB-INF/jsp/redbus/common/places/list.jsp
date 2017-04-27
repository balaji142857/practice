<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Places</title>
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
					<th>State</th>
					<th>Country</th>
					<th>Landmark</th>
					<th>Pin Code</th>
					<th>Options</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${places}" var="currentPlace" varStatus="vs">
					<tr>
						<td>${currentPlace.id}</td>
						<td>${currentPlace.location}</td>
						<td>${currentPlace.city}</td>
						<td>${currentPlace.state}</td>
						<td>${currentPlace.country}</td>
						<td>${currentPlace.landmark}</td>
						<td>${currentPlace.pincode}</td>
						<td>
							<a href='<c:url value="/redbus/places/${currentPlace.id}/edit"/>' class="btn btn-success btn-sm">
								<span class="glyphicon glyphicon-pencil"></span>
							</a>
							<a href='<c:url value="/redbus/places/${currentPlace.id}/delete"/>' class="btn btn-danger btn-sm">
								<span class="glyphicon glyphicon-remove"></span>
							</a>
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class = "pager">
		   <li class = "previous"><a href = '<c:url value="/redbus/places/list?pageNumber=${currentPage-1}"/>'>&larr; Previous</a></li>
		   <li class = "next"><a href = '<c:url value="/redbus/places/list?pageNumber=${currentPage+1}"/>'>Next &rarr;</a></li>
		</ul>
	</div>
	
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>