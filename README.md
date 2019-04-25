# homeinsurance
A Java Website tested with Selenium Automation

This repository contains a Maven project that you can download and run on your Eclipse IDE. The use of Maven pom.xml makes for the easier management of test dependencies.
However, some recommended build path settings will be called out by Eclipse for which you will have to allow the changes to take place.

Some of them are as follows:
1) Java JDK 9
2) Apache Web Server which you may have to install and configure with your Eclipse.
3) Oracle JDBC to access the SQL Database

On the backend, you will need to have an Oracle Database. 
1) There is a database creation script (*.sql) inside the Other_Files folder of this project.
2) The properties.db within the properties package has the necessary address and authentication settings you will need
  to properly connect to the database.
  
This readme is not a complete list of necessary configurations that you will need to run everything. For example, Selenium tests have my original paths for the webdriver.
At the least, you should be able to see my website run locally.  

Feel free to contact me at paulsison@gmail.com for assistance and information regarding this project. Thanks for your interest.
  
  -Paul
  

