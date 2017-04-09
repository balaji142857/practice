<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Confirm dummy values</title>
</head>
<body>

	<form:form modelAttribute="validatedObject" action="new" method="post">
		someNumber:<form:input path="someNumber" disabled="true"/><br>
		name:<form:input path="name" disabled="true"/><br>
		email:<form:input path="email" disabled="true"/><br>
		hobbies:<form:select path="hobbies" items="${hobbiesList}" disabled="true"></form:select><br>
		gender:<form:radiobuttons path="gender" items="${genderList}" disabled="true"/><br/>
		phone:<form:input path="phone" disabled="true"/><br/>
		subscriptions:<form:checkboxes items="${subscriptionsList}" path="subscriptions" disabled="true"/><br>
		<input type="submit" value="save" name="create">
		<input type="submit" value="edit" name="edit">
		<input type="submit" value="cancel" name="cancel">
	</form:form>


</body>
</html>