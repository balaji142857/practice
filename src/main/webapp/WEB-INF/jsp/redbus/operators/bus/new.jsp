<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>${pageTitle}</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	<div class="container">
		<c:url value="/redbus/operators/${operatorId}/buses/confirm" var="confirmURL"/>
	
	<form:form action="${confirmURL}" method="post" modelAttribute="newBus">



		<form:hidden path="id"/>
		model: <form:input path="model"/> <br>
		seatingCapacity: <form:input path="seatCapacity"/><br>
		chargingAvailable? <form:checkbox path="chargingAvailable"/><br>
		gpsTrackingAvailable? <form:checkbox path="gpsTrackingAvailable"/><br>
		<form:radiobuttons path="busType" items="${busTypes}"/> <br>
		<input type="submit" value="create">
		<input type="reset" value="reset">
	</form:form>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>