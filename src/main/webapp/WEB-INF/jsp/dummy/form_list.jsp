<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>List of dummies</title>
</head>
<body>
	
	<c:forEach items="${dummies}" var="dummy">
		someNumber:${dummy.someNumber}<br>
		name:${dummy.name}<br>
		email:${dummy.email}<br>
		hobbies:${dummy.hobbies}<br>
		gender:${dummy.gender}<br>
		phone:${dummy.phone}<br>
		subscriptions:${dummy.subscriptions}<br>
		<%-- someDate:${dummy.someDate}<br>
		someFile:${dummy.someFile}<br>
		someFiles:${dummy.someFiles}<br>
		someImage:${dummy.someImage}<br> --%>
	<!-- 	private long someNumber;
	private String name;
	private String email;
	private Set<String> hobbies;
	private Gender gender;*/
	private Set<String> subscriptions;	
	private LocalDate date;
	private File file;
	private Set<File> files;
	private File image; -->
	</c:forEach>

</body>
</html>