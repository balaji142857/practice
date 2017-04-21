<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Confirm details</title>
<style>
ul.verticalRadios {
  list-style-type: none;
}
</style>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	
	
	<c:url value="/redbus/places/new" var="confirmURL"/>
	
	<div class="container">
		<form:form action="${confirmURL}" method="post" modelAttribute="validatedPlace" class="form-horizontal">
			<form:hidden  path="id"/>			
			<div class="form-group">
				<label for="email" class="control-label col-sm-4">Location</label>
				<div class="col-sm-8">
					<form:input path="location" id="location" cssClass="form-control" readonly="true"/>
				</div>
			</div>

			<div class="form-group">
				<label for="city" class="control-label col-sm-4">City</label>
				<div class="col-sm-8">
					<form:input path="city" id="regNcityumber" cssClass="form-control" readonly="true"/>
				</div>
			</div>
						
			<div class="form-group">
				<label for="seatCapacity" class="control-label col-sm-4">State</label>
				<div class="col-sm-8">
					<form:input path="state" id="state" cssClass="form-control" readonly="true"/>
				</div>
			</div>
			
		 	<div class="form-group">
				<label for="country" class="col-sm-4 control-label">Country</label>
				<div class="col-sm-8">
					<form:input path="country" cssClass="form-control" readonly="true"/>
				</div>
			</div>
			
		 	<div class="form-group">
				<label for="pincode" class="col-sm-4 control-label">Pincode</label>
				<div class="col-sm-8">
					<form:input path="pincode" cssClass="form-control" readonly="true"/>
				</div>
			</div>		
			
		 	<div class="form-group">
				<label for="landmark" class="col-sm-4 control-label">Landmark</label>
				<div class="col-sm-8">
					<form:input path="landmark" cssClass="form-control" readonly="true"/>
				</div>
			</div>	

			<div class="form-group">
				<div class="col-sm-4"></div>
				<div class="col-sm-8">
					<input type="submit" value="create" class="btn btn-primary">
					<input type="submit" name="edit" value="edit" class="btn btn-primary">	
				</div>
			</div>			
		</form:form>
	</div>
	
	
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>