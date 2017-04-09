<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Test Page</title>
<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
</head>
<body>
	<h2>This is a test page.</h2>
	<div class="error">Red color</div>
	<div class="success">Green color</div>
	<br>
	<c:out value="${batchResult}" default="Not a batch request" />
	<br>
</body>
</html>