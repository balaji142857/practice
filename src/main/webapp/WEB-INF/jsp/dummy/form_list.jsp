<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>List of dummies</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	<div class="container">
		<c:forEach items="${dummies}" var="dummy">
			<div class="panel panel-default panel-modest">
			  <div class="panel-heading">email:${dummy.email}</div>
			  <div class="panel-body">
				someNumber:${dummy.someNumber}<br>
				name:${dummy.name}<br>
				email:${dummy.email}<br>
				hobbies:${dummy.hobbies}<br>
				gender:${dummy.gender}<br>
				phone:${dummy.phone}<br>
				subscriptions:${dummy.subscriptions}<br>  
			  </div>
			</div>
		</c:forEach>
	</div>
<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>