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
			<a href='<c:url value ="/redbus/operators/"/>'>operators</a><br>
			<a href='<c:url value ="/redbus/buses/"/>'>buses</a><br>
			<a href='<c:url value ="/redbus/services/"/>'>services</a><br>
			<a href='<c:url value ="/redbus/places/"/>'>Places</a><br>
		</div>
		<c:import url="/resources/template/footer.jsp"></c:import>
	</body>
</html>