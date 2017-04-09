<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Users</title>
</head>
<body>
	<c:import url="/resources/template/header.jsp"></c:import>
	<div class="container">
		<!-- both added and edited should return to this page with a success message -->
		<c:if test="${message !=null && message.length() > 0}">
			<div class="alert alert-info">${message}</div>
		</c:if>
		
		<br>		
		<a href='<c:url value="/users/new"/>' class="btn btn-primary">
		        <i class="fa fa-ban" aria-hidden="true"></i> Create new user
	    </a>
		<br><br><br>
		
		<table class="table table-striped table-condensed">
			<thead>
				<tr>
					<th>Id</th>
					<th>Username</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usersList}" var="currentUser" varStatus="vs">
					<tr>
						<td><a href='<c:url value="/users/${currentUser.id}"/>'>${currentUser.id}</a></td>
						<td><a href='<c:url value="/users/${currentUser.id}"/>'>${currentUser.username}</a></td>
						<td><a href='<c:url value="/users/${currentUser.id}"/>'>${currentUser.firstName}</a></td>
						<td><a href='<c:url value="/users/${currentUser.id}"/>'>${currentUser.lastName}</a></td>
						<td><a href='<c:url value="/users/${currentUser.id}"/>'>${currentUser.email}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:import url="/resources/template/footer.jsp"></c:import>
</body>
</html>