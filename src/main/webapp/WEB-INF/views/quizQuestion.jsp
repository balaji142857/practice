<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<body>
<h2>${quizModel.category.name} : ${quizModel.difficulty.name}</h2>
<h4>${quizModel.comment}</h4> 
	<form:form action="${flowExecutionUrl}&_eventId=next" method="post">
	Question Number: ${quizModel.currentQuestion}
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"><br />
		<c:out value="${quizModel.questions[quizModel.currentQuestion].text}" 
		default="oopsie... question content not found"> </c:out>
		<br>
		<c:forEach items="${quizModel.questions[quizModel.currentQuestion].answers}" var="answer">
			 <input type="radio" name="answerId" value="${answer.id}"> ${answer.text}<br>
		</c:forEach> 
		<br>
		
		<c:if test="${fn:length(quizModel.questions) gt (1+quizModel.currentQuestion)}">
   			<input type="submit" value="Next Question" />
		</c:if>
		
	</form:form>
	<form:form action="${flowExecutionUrl}&_eventId=cancel" method="post">
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"><br /> 
		<input type="submit" value="Cancel quiz" />
	</form:form>
	<form:form action="${flowExecutionUrl}&_eventId=finish" method="post">
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"><br /> 
		<input type="submit" value="Finish Quiz" />
	</form:form>
<br>
======RESULT====<br>	
Number of questions: ${fn:length(quizModel.questions)} <br>
Number of questions answered : ${quizModel.answeredQuestions} <br>
Number of correct answers : ${quizModel.correctAnswers} <br>
	
</body>
</html>