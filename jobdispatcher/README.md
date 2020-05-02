#jobdispatcher
This app publishes objects on a messaging queue. This acts as a Producer.
TechStack: spring-boot, apache kafka, java8

Prerequisites for running this project
1.Install apache kafka on your machine.
2. Start the zookeeper server 
	[eg; if running on windows command line , execute the following:
		--zookeeper-server-start.bat config\zookeeper.properties
	]
3. Start the kafka server
	[eg; if running on windows command line , execute the following:
		--kafka-server-start.bat config\server.properties
	]
	
	
To run this project : 
right click on the project ->run as-> run configuration.. -> select your project and use the following in goals: 
spring-boot:run