**Spring Modules and Hibernate mappings showcase application**
=========

Hello there !!.. Have attempted to showcase the various spring modules in this application. Feel free to raise a pull request/suggestions if you notice any issues. Near the rear end of this document, have included my  understanding of the filter chain used by Spring security. Love to **`KISS`**[^kiss]

**Environment**

 1. Linux
 2. Tomcat server
 3. Derby database

**Spring modules covered**

 1. Core
 2.  Web (with validation, file upload)
 3.  Webflow
 4.  Batch
 5.  Data
 6. Transaction Management
 6.  Security
 

**Other dependencies**

 1. P6Spy as datasource proxy to capture the SQL
 2.  Hibernate as the ORM tool
 3.  Logback as the Logging framework of choice (with SLF4J)
 4.  Apache POI for creating/writing excel from batch
 5. Envers for auditing the changes to data
 6. Jackson for java <-> json conversion
 7. Apache commons for file uploads
 8. Junit for testing

*Being a bit disinclined towards XML due to verbosity, have preferred to use javaConfig wherever possible.* 

**Tomcat Datasource configuration**

Have used light wight tomcat as the server for this demo application. Follow the below two steps to setup the datasource

 1. Add the resource configuration to the
    `$CATALINA_BASE/conf/server.xml` file . 
    Place the datasource resource details inside `Server -> GlobalNamingResources tag`
    
	```
	<Resource name="jdbc/derbyDataSource" 
	  global="jdbc/derbyDataSource" 
	  auth="Container" 
	  type="javax.sql.DataSource"
	  driverClassName="org.apache.derby.jdbc.ClientDriver"
	  url="jdbc:derby://localhost:1527/test;create=true" 
	  username="<username>" 
	  password="<password>" 
	  maxActive="100" 
	  maxIdle="20" 
	  minIdle="5" 
	  maxWait="10000"/>
	```

 2.  Once that is done,  create a reference to the new resource
    (datasource) from the `context.xml` file    

```
	<ResourceLink name="jdbc/derbyDataSource"
	      global="jdbc/derbyDataSource"
	      auth="Container"
	      type="javax.sql.DataSource" />
```
     
**Spring Security Filter chain explained**
Spring security by default comes with checks against many of the known issues out of the box like CSRF, XSS etc. However for few other vulnerabilities, it requires the developers to provide it with additional info to secure the app and details of such configuration are well documented in the spring reference manual.  


----------
This is one such example where spring would need the developer to pitch in with additional info
> **Content Negotiation** 
>  Content negotiation is serving request per the type required. By type I imply json/xml/plain text formats..
>  That being said, this would mean accessing either /users/1.css or  /users/1 both are same would give the same result because of content negotiation given there is no explicit handling for 1.css 

Spring security Internals
-------------------------
Spring security is implemented using Servlet Filters so that for each and every request, based on the requested resources selected filters can be chained together making it highly modular, thanks to Rob Winch.

**List of filters: (known to me, many more exist!!!)  **
>- **DelegatingFilterProxy** 
	 1. This is directly defined in web.xml as a servlet Filter
	 2. It delegates all work to FilterChainProxy 
	 3. This filter should be named as `springSecurityFilterChain` in `web.xml` as this filter looks up a bean by name 
    `sprinSecurityFilterChain` from `applicationContext` and delegates all     requests to it

>- **FilterChainProxy** 
1. security:http element defined in the spring security configuration translates to a bean (named springSecurityFilterChain) 
2. For each request, based on URL, this filter is responsible for identifying the list of filters to be used and invokes them all and finally call its own doFIlter method to process the original request
3.  This gives a 1:n mapping b/w (i.e single filter declared in web.xml versus multiple filters being invoked on a request to request basis),
>- **ExceptionTransaltionFilter** 
1. This Filter will attempt to invoke rest of the filters & catch any `AccessDeniedException` 
2. If `AccessDeniedException` is caught, it stores the original request in a cache and sends the user to a login Page 
>- **SecurityFilterInteceptor** 
1. Checks if the requested URL needs to be secured based on the intercept-url defined in security configuration 
2. If authentication is required & user is not logged in, it throws    a `AccessDeniedException`
>- **DefaultLoginPageGeneratingFilter**  
1. if the requested URL is `/spring_security_login,` this filter generates a default login page with form submit action pointing to  to j_spring_security_check  by default with j_username and  `j_password` as the `parameters`
>- **SecurityContextPersistenceFilter** 
1. This filter notices any change in the SecurityContextHolder for new authentiction 
2. That is if a user got logged in, it will move the userDetails from SecurityContextHolder and put it in httpSession It is moving not copying (since in web app threads are pooled, we dont want an unauthenticated user to get ths thread with context) 
3. If HttpSession already has a logged in user, it copies the user to the SecurityContextHolder One che chain.doFilter is done for this filter, it clears the info from SecurityContextHolder(ThreadLocal) since server pools the threads
>- **UsernamePasswordAuthenticationFilter** 
1. This Filter intercepts requests to j_spring_security_check and uses `authenticationManager` to authenate the login request
2.  Once authenticationManager returns a authentication token, this filter puts the token in `SecurityContextHolder` (ThreadLocal) 
3. Then it replays (redirects) the stored request from request cache (initial user request) `RequestCacheAwareFilter` if it is the stored reqeust that is being replayed, it has something to do - not sure

To include details of login failed reason
===============================
```
<c:if test="${param.error !=null }"> 
  <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
	<c:out value:"${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
   </c:if> 
</c:if>
``` 
likewise to display the logout message just use the below:
```
<c:if test="${param.logout !=null}">
	<c:out value:"you have been logged out"/>
</c:if>
```

[^kiss]: [Keep It Simple Silly](https://en.wikipedia.org/wiki/KISS_principle)
Attachments area

