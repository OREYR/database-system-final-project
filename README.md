# Insurance Client Management Web Application

### Tools & Dependency

* Java Application IDE: Eclipse IDE for Java EE Developers.
* Database Server: MySQL Server 8.0.31 + MySQL Workbench 8.0.31 (used to create tables with query in the *sql/create-client-claim-tables.sql*).
* Java Web Server: Apache Tomcat 8.5.78.
* Other dependencies are included in *WebContent/WEB-INF/lib*.


### Steps:
1. Create database and tables in MySQL Workbench.
2. Create a Eclipse Dynamic Web Project including:
  * Client.java: create a java bean class
  * ClientDao.java: create JDBC
  * ClientServlet.java: handle all web requesters
  * JSP pages: client-list.jsp & client-version.jsp

3. Run on servers.

