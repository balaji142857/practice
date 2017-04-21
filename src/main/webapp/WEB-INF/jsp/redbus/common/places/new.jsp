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
		<c:url value="/redbus/places/confirm" var="confirmURL"/>
	
		<form:form action="${confirmURL}" method="post" modelAttribute="newPlace" class="form-horizontal">

			<form:hidden path="id"/>
			<div class="form-group">
				<label for="email" class="control-label col-sm-4">Location</label>
				<div class="col-sm-8">
					<form:input path="location" id="location" cssClass="form-control"/>
					<form:errors path="location" cssClass="form-control error" />
				</div>
			</div>

			<div class="form-group">
				<label for="city" class="control-label col-sm-4">City</label>
				<div class="col-sm-8">
					<form:input path="city" id="regNcityumber" cssClass="form-control"/>
					<form:errors path="city" cssClass="form-control error" />
				</div>
			</div>
						
			<div class="form-group">
				<label for="seatCapacity" class="control-label col-sm-4">State</label>
				<div class="col-sm-8">
					<form:input path="state" id="state" cssClass="form-control"/>
					<form:errors path="state" cssClass="form-control error" />
				</div>
			</div>
			
		 	<div class="form-group">
				<label for="country" class="col-sm-4 control-label">Country</label>
				<div class="col-sm-8">
					<form:input path="country" cssClass="form-control" />
					<form:errors path="country" cssClass="form-control error" />
				</div>
			</div>
			
		 	<div class="form-group">
				<label for="pincode" class="col-sm-4 control-label">Pincode</label>
				<div class="col-sm-8">
					<form:input path="pincode" cssClass="form-control" />
					<form:errors path="pincode" cssClass="form-control error" />
				</div>
			</div>		
			
		 	<div class="form-group">
				<label for="landmark" class="col-sm-4 control-label">Landmark</label>
				<div class="col-sm-8">
					<form:input path="landmark" cssClass="form-control" />
					<form:errors path="landmark" cssClass="form-control error" />
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

