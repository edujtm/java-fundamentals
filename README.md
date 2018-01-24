# java-fundamentals

Some code snippets that i believe are worthy of a repo on my github because they were kinda challenging 

This repository has the exercises' code from a course called [Java Fundamentals For Android Development](https://www.edx.org/course/java-fundamentals-android-development-galileox-caad001x-2) that i audited on my free time. The project that made me create this repository
was the simple-chat one, since i had no previous knowledge of multithreading and concurrency issues.

These are the topics covered in each lesson that i learned

1. lesson 3
	1. nutrition-app  
		Simple application to read inputs from different files formats. The result is tested using JUnit

		Topics covered:   
		**JSONP api, BufferedReader, FileReader, ObjectOutputStream and ObjectInputStream**
1. lesson 4
	1. lambda-exercises  
		Series of exercises of lambda expression and streams in java. The output is tested with Junit.

		Topics covered:  
		**Lambda expressions, streams and java functional programming**
	1. movie-theater  
		Multithreading app that represents a Movie-theater with 5 queues for 15 movies with an Entry object that generates 
		customers in parallel with the attendants that are looking for customers in the queue. Customers are generated at a 
		random time between 3-5 seconds and takes between 3-5 seconds to decide which movie. Each queue attends 3 movies.

		Topics covered:  
		**Java Threads and Runnables and Random class**
1. lesson 5
	1. simple-chat  
		Simple implementation of a chat server and client. The server creates threads for each user and redirect messages to all 
		other users that are logged in. Each user has a thread that listen to server messages and another that receives messages from 
		the standard input and sends to the server.

		Topics covered:  
		**Java Threads and Runnables, synchronized methods, SocketServer and Sockets**


### Libraries used
* [javax.json-api:1.0](https://mvnrepository.com/artifact/javax.json/javax.json-api)
* [javax.json-1.0.4](https://javaee.github.io/jsonp/download.html)
* [junit:4.12](https://mvnrepository.com/artifact/junit/junit/4.12)