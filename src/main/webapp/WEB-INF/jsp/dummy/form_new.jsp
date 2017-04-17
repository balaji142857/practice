<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>New dummy form</title>
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
<body>
<c:import url="/resources/template/header.jsp"></c:import>
<div class="container">
	<form:form modelAttribute="modelObject" action="confirm" method="post" enctype="multipart/form-data">
	
	someNumber:<form:input path="someNumber" />
	<form:errors path="someNumber" /><br>
	
	name:<form:input path="name"/>
	<form:errors path="name" /><br>
	
	email:<form:input path="email"/>
	<form:errors path="email" /><br>
	
	hobbies:<form:select path="hobbies" items="${hobbiesList}"></form:select>
	<form:errors path="hobbies" /><br>
	
	gender:<form:radiobuttons path="gender" items="${genderList}"/>
	<form:errors path="gender" /><br>
	
	subscriptions:<form:checkboxes items="${subscriptionsList}" path="subscriptions"/>
	<form:errors path="subscriptions" /><br>
	
	phone: <form:input path="phone"/>
	<form:errors path="phone" /><br>
	
	someFile: <input type="file" name="temp_someFile"/><br>
	someImage: <input type="file" name="temp_someImage"/><br>
	
	<%-- date:<form:input path="someDate"/><br> --%>
	<input type="submit" value="submit">
	<input type="reset" value="reset">

	</form:form>
</div>	
	<c:import url="/resources/template/footer.jsp"></c:import>
	
</body>
</html>