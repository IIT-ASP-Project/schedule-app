## To start fron this repo

1. Git clone the repo
2. Launch eclipse and add the project


## Steps to create project from scratch

In Eclipse you must first install some plugins.

1. Go to Help->Eclipse Marketplace->(search for the Spring and it will find all Spring plugins)
    -> Install(Spring Tool Suite, Spring Source Tool Suite).
1. Create new project-> Spring Boot ->Spring Starter Project
2. Name the project schms
3. Name the package com.schms
4. Next, choose Web package, MySQL Package
5. Add those dependcies:
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


## This is for the installation.

1. After instalation there must be a generated project. Find the SchmsApplication.java under the src folder
2. Right click, find Run As-> Spring Boot App. You should be able on the right side to see the server
trying to run. It must show Tomcat started on port(s): 8080 (http)