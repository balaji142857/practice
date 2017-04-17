<%@ page isELIgnored="false" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src='<c:url value="/resources/js/jquery-2.2.3.min.js"/>' type="text/javascript"></script>
<script src='<c:url value="/resources/bootstrap/js/bootstrap.js"/>' type="text/javascript"></script>
<link href='<c:url value="/resources/bootstrap/css/bootstrap.css"/>' rel="stylesheet">
<link href='<c:url value="/resources//css/style.css"/>' rel="stylesheet">
<link href='<c:url value="/resources/bootstrap/css/bootstrap-theme.css"/>' rel="stylesheet">
<link rel="shortcut icon" href='<c:url value="/resources/images/favicon.ico"/>' />
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">32KB</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href='<c:url value="/redbus/links/"/>'>Redbus<span class="sr-only">(current)</span></a></li>
        <li><a href='<c:url value="/dummy/"/>'>Categories</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href='<c:url value="/users/"/>'>Users</a></li>
            <li><a href='<c:url value="/roles/"/>'>Roles</a></li>
            <li><a href='<c:url value="/tags/"/>'>Tags</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-info">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
      
      <sec:authorize var="loggedIn" access="isAuthenticated()" />
		<c:choose>
		    <c:when test="${loggedIn}">
				<c:url var="logoutUrl" value="/logout" />
				<form action="${logoutUrl}" id="logout" method="post" style="display:none">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
				<li><a href='#' onclick="document.getElementById('logout').submit();">Logout</a></li>
			</c:when>
		    <c:otherwise>
		        <li><a href='<c:url value="/login"/>'>Login</a></li>
		    </c:otherwise>
		</c:choose>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>