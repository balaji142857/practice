<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style>
ul.verticalRadios {
  list-style-type: none;
}
</style>
<title>${pageTitle}</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	<div class="container">
		<c:url value="/redbus/operators/${operatorId}/routes/new" var="confirmURL"/>
	
		<form:form action="${confirmURL}" method="post" modelAttribute="validatedRoute" class="form-horizontal">

			<form:hidden path="id"/>
			<div class="form-group">
				<label for="name" class="control-label col-sm-4">Route Name</label>
				<div class="col-sm-8">
					<form:input path="name" id="name" cssClass="form-control" readonly="true"/>
				</div>
			</div>
			
			<%-- <div class="form-group">
				<label for="stops" class="control-label col-sm-4">Bus Stops</label>
				<div class="col-sm-8">
					<form:select path="stops" id="stops" items="${availableStops}" itemLabel="displayName" itemValue="id" cssClass="form-control" readonly="true"/>
				</div>
			</div> --%>			
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
			<c:out value="${validatedRoute.stops.size()} is the bus stops size"/>
				<c:forEach items="${validatedRoute.stops}" var="currentStop">
					<tr>
						<td><a href='<c:url value="/redbus/${currentStop.id}/edit"/>'>${currentStop.id}</a></td>
						<td><a href='<c:url value="/redbus/${currentStop.id}/edit"/>'>${currentStop.place.display}</a></td>
						<td><a href='<c:url value="/redbus/${currentStop.id}/edit"/>'>${currentStop.day}</a></td>
						<td><a href='<c:url value="/redbus/${currentStop.time}/edit"/>'>${currentStop.time}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			
			<div class="form-group">
				<div class="col-sm-4"></div>
				<div class="col-sm-8">
					<input type="submit" value="confirm" class="btn btn-primary">
					<input type="reset" value="reset" class="btn btn-primary">
				</div>
			</div>
	</form:form>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>

</html>

