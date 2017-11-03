# Schedule Management System

## STEP 1 : Environment set up

### To start from this repo

1. Git clone the repo
2. Launch eclipse and add the project

*or you can recreate the project..*

### Steps to create project from scratch

In Eclipse you must first install some plugins.

1. Go to Help->Eclipse Marketplace->(search for the Spring and it will find all Spring plugins)
    -> Install(Spring Tool Suite, Spring Source Tool Suite).
1. Create new project-> Spring Boot ->Spring Starter Project
2. Name the project schms
3. Name the package com.schms
4. Next, choose Web package, MySQL package
5. Add those dependencies:
	>	<dependency>
	>		<groupId>org.springframework.boot</groupId>
	>		<artifactId>spring-boot-starter-jdbc</artifactId>
	>	</dependency>
	>	
	>	<dependency>
	>		<groupId>org.springframework.boot</groupId>
	>		<artifactId>spring-boot-starter-data-jpa</artifactId>
	>	</dependency>
	>
	>	<dependency>
	>		<groupId>org.springframework.boot</groupId>
	>		<artifactId>spring-boot-starter-test</artifactId>
	>		<scope>test</scope>
	>	</dependency>


## STEP 2 :  Working set up

1. After instalation there must be a generated project. 
2. Use a MySQL Manager (MySQLBench, cli, or others), to generate the the database :
	- database name : schms
	- user : root
	- password : *none*
3. Find the SchmsApplication.java under the src folder
4. Right click, find Run As-> Spring Boot App. You should be able on the right side to see the server
trying to run. It must show Tomcat started on port(s): 8080 (http)


Below a direct extract from [Spring Doc](https://github.com/spring-projects/spring-boot/blob/master/README.adoc)

== Modules
There are a number of modules in Spring Boot, here is a quick overview:



=== spring-boot
The main library providing features that support the other parts of Spring Boot,
these include:

* The `SpringApplication` class, providing static convenience methods that make it easy
to write a stand-alone Spring Application. Its sole job is to create and refresh an
appropriate Spring `ApplicationContext`
* Embedded web applications with a choice of container (Tomcat, Jetty or Undertow)
* First class externalized configuration support
* Convenience `ApplicationContext` initializers, including support for sensible logging
defaults



=== spring-boot-autoconfigure
Spring Boot can configure large parts of common applications based on the content
of their classpath. A single `@EnableAutoConfiguration` annotation triggers
auto-configuration of the Spring context.

Auto-configuration attempts to deduce which beans a user might need. For example, if
`HSQLDB` is on the classpath, and the user has not configured any database connections,
then they probably want an in-memory database to be defined. Auto-configuration will
always back away as the user starts to define their own beans.



=== spring-boot-starters
Starters are a set of convenient dependency descriptors that you can include in
your application. You get a one-stop-shop for all the Spring and related technology
that you need without having to hunt through sample code and copy paste loads of
dependency descriptors. For example, if you want to get started using Spring and JPA for
database access just include the `spring-boot-starter-data-jpa` dependency in your
project, and you are good to go.



=== spring-boot-cli
The Spring command line application compiles and runs Groovy source, making it super
easy to write the absolute minimum of code to get an application running. Spring CLI
can also watch files, automatically recompiling and restarting when they change.



=== spring-boot-actuator
Spring Boot Actuator provides additional auto-configuration to decorate your application
with features that make it instantly deployable and supportable in production.  For
instance if you are writing a JSON web service then it will provide a server, security,
logging, externalized configuration, management endpoints, an audit abstraction, and
more. If you want to switch off the built in features, or extend or replace them, it
makes that really easy as well.



=== spring-boot-loader
Spring Boot Loader provides the secret sauce that allows you to build a single jar file
that can be launched using `java -jar`. Generally you will not need to use
`spring-boot-loader` directly, but instead work with the
link:spring-boot-tools/spring-boot-gradle-plugin[Gradle] or
link:spring-boot-tools/spring-boot-maven-plugin[Maven] plugin.



== Samples
Groovy samples for use with the command line application are available in
link:spring-boot-cli/samples[spring-boot-cli/samples]. To run the CLI samples type
`spring run <sample>.groovy` from samples directory.

Java samples are available in link:spring-boot-samples[spring-boot-samples] and should
be built with maven and run by invoking `java -jar target/<sample>.jar`.



== Guides
The http://spring.io/[spring.io] site contains several guides that show how to use Spring
Boot step-by-step:

* http://spring.io/guides/gs/spring-boot/[Building an Application with Spring Boot] is a
  very basic guide that shows you how to create a simple application, run it and add some
  management services.
* http://spring.io/guides/gs/actuator-service/[Building a RESTful Web Service with Spring
  Boot Actuator] is a guide to creating a REST web service and also shows how the server
  can be configured.
* http://spring.io/guides/gs/convert-jar-to-war/[Converting a Spring Boot JAR Application
  to a WAR] shows you how to run applications in a web server as a WAR file.
