#Informations

- Java 21
- Wildfly 31
- Persistence 3.1

# Download Jar PostgreSQL Driver

### First Step

		https://mvnrepository.com/artifact/org.postgresql/postgresql/42.7.2
		- Must be Jar
- In WildFly: change directory to modules/system/layers/base/org/(create a folder with name postgresql) and paste insede the driver jar and create module.xml:


	<?xml version="1.0" encoding="UTF-8"?>
	<module name="org.postgresql" xmlns="urn:jboss:module:1.9">
    <resources>
        <resource-root path="postgresql-42.7.2.jar"/>
    </resources>
    <dependencies>
        <module name="java.compiler"/>
        <module name="java.desktop"/>
        <module name="java.instrument"/>
        <module name="java.logging"/>
        <module name="java.management"/>
        <module name="java.naming"/>
        <module name="java.scripting"/>
        <module name="java.sql"/>
        <module name="java.transaction.xa"/>
        <module name="javax.servlet.api:h2" optional="true"/>
        <module name="org.slf4j"/>
    </dependencies>
	</module>
	
### Second step
- In WILDFLY_HOME/bin and create a user with executable: add-user.sh (or .bat)

- After create user, start server with ./standalone.sh

	[Wildfly Administration Console] http://localhost:9990/console/index.html

	Configuration/Subsystems/Datasources & Drivers/JDBC Drivers
	- Create a datasource with postgresql. 
	Name: postgresql
	Driver Module Name: org.postgresql
	Driver Class Name: org.postgresql.Driver
	
- After, create your datasources with your credentials to access database.
	
- In this step, the UI will add the datasource configured by the graphical tool to your standalone.xml or standalone-full.xml as chosen by you.
- Save and reaload.
	 
# Observations: 
- The latest version of postgresql, currently 16.2, has connection problems, making the connection to the datasource unviable by throwing (javax/security/sasl/SaslException). In my tests, version 12.x runs normally.