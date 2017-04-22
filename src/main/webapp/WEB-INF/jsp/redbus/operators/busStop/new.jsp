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
		<c:url value="/redbus/operators/${operatorId}/busStops/confirm" var="confirmURL"/>
	
		<form:form action="${confirmURL}" method="post" modelAttribute="newBusStop" class="form-horizontal">

			<form:hidden path="id"/>
			<!-- place -->
			<div class="form-group">
				<label for="place" class="control-label col-sm-4">Place</label>
				<div class="col-sm-8">
					<form:select path="place" items="${availablePlaces}" itemLabel="display" itemValue="id" id="place" cssClass="form-control"/>
					<form:errors path="place" cssClass="form-control error" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="day" class="control-label col-sm-4">Day</label>
				<div class="col-sm-8">
					<form:input  path="day" id="day" cssClass="form-control"/>
					<form:errors path="day" cssClass="form-control error" />
				</div>
			</div>
						
			<!-- time -->
			<div class="form-group">
				<label for="time" class="control-label col-sm-4">Time</label>
				<div class="col-sm-8">
					<input type="time" name="time" class="form-control">
					<%-- <form:input  path="time" id="regNcityumber" cssClass="form-control"/> --%>
					<form:errors path="time" cssClass="form-control error" />
				</div>
			</div>
						
			
						
			
			<div class="form-group">
				<div class="col-sm-4"></div>
				<div class="col-sm-8">
					<input type="submit" value="create" class="btn btn-primary">
					<input type="reset" value="reset" class="btn btn-primary">
				</div>
			</div>
	</form:form>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>

</html>

