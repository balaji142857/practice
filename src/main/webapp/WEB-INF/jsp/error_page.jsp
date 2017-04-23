<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Oopsie !!!</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	<div class="container">
		<div class="alert alert-danger">
		<h4>Message</h4>
		Exception:"${exception.message}" occured while handling ${url}
		</div>
		<br><br>
		<div class="alert alert-warning">
		<h3>Stack trace:</h3>
			<c:forEach items="${exception.stackTrace}" var="trace">
				<c:out value="${trace.className}.${trace.methodName} : ${trace.lineNumber}"/><br>
			</c:forEach>
		</div>		
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>