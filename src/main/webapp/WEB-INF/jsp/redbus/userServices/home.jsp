<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>List of Operators</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
	<body>
		<c:import url="/resources/template/header.jsp"></c:import>
		<div class="container">
		<c:url value="/redubus/services/search"	 var="newURL"/>
			<form:form action="${newURL}" method="get" modelAttribute="validatedOperator">
			<div class="form-group">
				<label for="name">from:</label>
				<form:input id="from" path="from" cssClass="form-control" readonly="true"/>
			</div>
			<div class="form-group">
				<label for="name">to:</label>
				<form:input id="to" path="to" cssClass="form-control" readonly="true"/>
			</div>
			<div class="form-group">
				<label for="name">date:</label>
				<form:input id="date" path="date" cssClass="form-control" readonly="true"/>
			</div>
			</form:form>
		</div>
		<c:import url="/resources/template/footer.jsp"></c:import>
	</body>
</html>