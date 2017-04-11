Tomcat is being used as the server..
datasource configuration

Add the resource configuration to the $CATALINA_BASE/conf/server.xml inside Server->GlobalNamingResources tag
  

<Resource name="jdbc/derbyDataSource"
              auth="Container"
              type="javax.sql.DataSource"
              username="<username>"
              password="<password>"
              url="jdbc:derby://localhost:1527/test;create=true"
              driverClassName="org.apache.derby.jdbc.ClientDriver"
              initialSize="20"
              maxWaitMillis="15000"
              maxTotal="75"
              maxIdle="20"
              maxAge="7200000"
              testOnBorrow="true"              
              />
Include a resource link in the tomcat context file

<ResourceLink name="jdbc/derbyDataSource"
   global="jdbc/derbyDataSource"
   type="javax.sql.DataSource"/>             