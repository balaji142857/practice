<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head></head>
<body>
	<h1>Login</h1>
	<c:if test="${param.error !=null }">
		<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
			<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
		</c:if>
	</c:if>
	
	<c:if test="${param.logout !=null}">
		<c:out value="you have been logged out"/>
	</c:if>

	<form name='f' action="authenticate" method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
	</form>
</body>
</html>