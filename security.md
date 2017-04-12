/users/1.css == /users/1 both are same - content negotiation

delegatingFilterProxy
	defined in web.xml -> a servlet Filter, delegates all work to FilterChainProxy
	this filter should be named as springSecurityFilterChain in web.xml
	this filter looks up sprinSecurityFilterChain from applicationContext and delegates all requests to it
FilterChainProxy
	<security:http> element translates to a bean (named springSecurityFilterChain)
	for each requsts, based on URL, identifies a list of filters to be used and invokes them all
	finally call its own doFIlter method to process the original request
	this gives a 1:n mapping
ExceptionTransaltionFilter
	Will try to invoke rest of the filters and catch Any AccessDeniedException
	If ADException is caught, it stores the original request in a cache and sends the user to a login Page
SecurityFilterInteceptor
	Checks if the requested URL needs to be secured based on the intercept-url defined in security configuration
	If authentication is required & user is not logged in, it throws AccessDeniedException
DefaultLoginPageGenerating Filter
	if url is /spring_security_login, this generates a default login Page
	this form submits to j_spring_security_check j_username, j_password
SecurityCOntextPersistenceFilter
	This filter notices any change in the SecurityContextHolder for new authentiction
		i.e if a user got logged in, it will move the userDetails from SecurityContextHolder and put it in httpSession
		It is moving not copying (since in web app threads are pooled, we dont want an unauthenticated user to get ths thread with context)
	If HttpSession already has a logged in user, it copies the user to the SecurityContextHolder		
	One che chain.doFilter is done for this filter, it clears the info from SecurityContextHolder(ThreadLocal) since server pools the threads
UsernamePasswordAUthenticationFilter
	intercepts j_spring_security_check and uses authenticationManager to authenation 
	once authenticationManager returns a user, this filter puts the user in SecurityContextHolder (ThreadLocal)
	then it replays (redirects) the stored request from request cache (initial user request)
RequestCacheAwareFilter
	if it is the stored reqeust that is being replayed, it has something to do - not sure 	


	to include details of login failed reason
	===============================
	
<c:if test="${param.error !=null }">
	<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
		<c:out value:"${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
	</c:if>
</c:if>
likewise
 <c:if test="${param.logout !=null}">
 	<c:out value:"you have been logged out"/>
 </c:if>