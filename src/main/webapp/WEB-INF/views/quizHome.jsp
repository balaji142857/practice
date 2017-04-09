<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<body>
	<form:form action="${flowExecutionUrl}&_eventId=quizSelected" method="post">
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"><br /> 
		<input type="submit" value="Start Quiz" />
	</form:form>
</body>
</html>