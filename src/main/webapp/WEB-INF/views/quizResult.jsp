<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<body>

Number of questions: ${fn:length(quizModel.questions)} <br>
Number of questions answered : ${quizModel.answeredQuestions} <br>
Number of correct answers : ${quizModel.correctAnswers} <br>
</body>
</html>