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
			<c:if test="${message !=null && message.length() > 0}">
				<div class="alert alert-info">${message}</div>
			</c:if>
			<a class="btn btn-primary" href='<c:url value="/redbus/operators/new"/>'>Create operator</a>
			<br><br>
			<h4>Operators</h4>
			<c:forEach items="${operators}" var="dummy">
				<div class="panel panel-primary panel-modest">
				  <div class="panel-heading">${dummy.name}  </div>
				  <div class="panel-body">
				    id: ${dummy.id}<br>
					contactName:${dummy.contactName}<br>
					contactNumber:${dummy.contactNumber}<br>
					headOfficeAddress:${dummy.headOfficeAddress}<br>
					email:${dummy.email}<br>
					buses:${dummy.buses.size()}<br>
					<a href='<c:url value="/redbus/operators/${dummy.id}/"/>' class="btn btn-primary">View</a>
					<a href='<c:url value="/redbus/operators/${dummy.id}/edit"/>' class="btn btn-primary">Edit</a>  
				  </div>
				</div>
			</c:forEach>
		</div>
		<c:import url="/resources/template/footer.jsp"></c:import>
	</body>
</html>