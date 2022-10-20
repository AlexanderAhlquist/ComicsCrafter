# ComicsCrafter
The goal of this project was to create something useful to my fiancee. They are a comic book creator by trade, but being a comic book creator does not make you a financial saavant. She explained to me that she needed to reprint her comics, but had no idea what paper she had used to print them out. I took that idea and ran with it! My goal was to create a website which could take a comic project, and allow a user to easily track which paper they used for what project. This project is far from done, and only has the very basic implementation complete, but it is definitely a project I want to sink more time into to make more useful! I want this to be something that I can be proud of!

This project was done as part of the Per Scholas fellowship as a capstone project. The course was a Full-Stack Java Engineering program, and, well... Here's the full stack project I made! From front-end to back-end, it actually connects! A few months ago I could never dream of making something like this, but thanks to a lot of hard work and effort, I've made something that I'm proud of. 

The backend of this project will be using Java and MariaDb. The frontend is HTML, CSS, and Javascript. The project was assembled as a Maven project using Spring Boot.

## Project Requirements
### 1. Project Structure, Standardization and Conventions 12%
#### a.The project package structure should be shown in class, where the models, DAO/repositories, services, controllers, and exceptions, etc., have a package. Views or templates do not require a package - 2%.
My project has different packages for each aspect of the project.

#### b.Each class should include comments to describe the class and the methods - 2%.
In each class, I at least included a small description of the class. For non-complex methods I didn't include descriptions, since the names of the methods explain the purpose of them.

#### c. Have the project pushed into GitHub from the early stage of development and hosted on GitHub with a “readme” file documenting an overview of your project - 5%.
I pushed the project to GitHub as I was working on it. I started the project over a month ago, but I didn't really get momentum going until the end of class once we had learned about all of the aspects of the project which we had to include.

#### d. Standard Java naming conventions should be followed
I did my best to follow standard naming conventions.


### 2. Core Java and Models: 16%
#### a. Utilize Java classes with constant variables (i.e., variables that never change from their initial value). The value of these variables can be requested parameters, SQL queries used in the DAO, names of HTML pages, or URL patterns to forward a request to - 2%.
All of my controller classes return static HTML pages. 

#### b. Have at least four models and corresponding tables in a relational database (if four models/tables do not make sense for your application, discuss this with your instructor) - 12%
I have five models, Paper, Printing, Project, Role, and User.
Each of the five models have corresponding tables in the relational database (See the Database_Schema.png for the schema of the database).

#### c. Apply exception handling - 2%.
definitely could add more exception handling, and as I continue to work on this project in the future I definitely will add more as I see errors appear. Currently all of my service implementations have a method where they will return a RuntimeException if the requested object's ID is not found in the database.

### 3. Database, ORM, and Hibernate: 18%
#### a. Use MariaDB as your DBMS (check with your instructor if you need support to install MariaDB on your computer) - 2%.
I used MariaDB as my DBMS, you can see this in the application.properties file.
#### b. Include a schema diagram of the tables and the SQL you used for the database - 2%.
I have a schema diagram included with the project (https://github.com/AlexanderAhlquist/ComicsCrafter/blob/main/Schema%20Diagram.png)
#### c. The database configuration file must be set up correctly in your Spring application through “spring initializr” (application.properties) - 2%.
my application.properties file is set up correctly to talk to MariaDB. In order for the program to work, all you need to do is create a database called "comicscrafter" in your MariaDB, and then run the program as a Spring Boot application on your tomcat server.
#### d. Include at least three custom queries - 3%.
My application utilized the @Repository annotation. For Users, Projects, Paper, and Printing, by using @Repositories .save, .findAll, .findById, .deleteById in various ways, the user can make many queries from the front end to create, update, delete, and read the database.
#### e. Use Hibernate or Jakarta Persistence API (JPA) directly or through Spring Data JPA - 3%.
By utilizing Spring Data JPA, the database is queried using Hibernate. The @Repository annotation through Spring Data JPA allows for this to happen.
#### f. Your application should include examples for all four CRUD operations (Create, Read, Update, and Delete) - 6%.
Through the front end of my website, users can create, read, update, and delete entries into the database. This is implemented through my Controller, View, and Models.

### 4. Front-end Development: 16%
#### a. Use CSS to style the Web pages. Use an external CSS stylesheet.(Internal styling may be used along with frameworks such as Bootstrap, but you must still include and utilize a custom CSS external file.) - 3%.
I created my own CSS from scratch. There are two CSS files, one for the index page, and one for each other page that the user can see. I did not use Bootstrap, but I am definitely interested in learning Bootstrap after this course is complete.
#### b. Your application should include six different views/pages - 4%.
My application has 15 views, which you can see in the src/main/resources/template folder.
#### c. Use HTML to lay out the pages and Thymeleaf to make the pages dynamic. (Frameworks such as Angular or React can also be used but will not be covered in the course. Both Angular or React are optional.) The application’s presentation must meet the general view requirements. - 3%
I used thymeleaf extensively with HTML to display data, as well as interact with other parts of my program.
#### d. Use at least one JavaScript script linked from an external script file. (Internal scripts may be used along with frameworks such as jQuery, but you must still include and utilize a custom JavaScript external file.) - 3%.
My index.html page has a simple JavaScript script that I wrote to display information about various different types of comics on the index page when you select an option from a dropdown menu. 
#### e. Include a navigation section that is included across multiple pages - 3%.
I implemented a navigational toolbar at the bottom of my webpage that allows the user to quickly navigate the site.

### 5. Spring Framework: 25%
#### a. Use Spring Boot to develop your project - 2%. 
I used start.spring.io to initialize my project as a Spring Boot project, and declare dependencies.
#### b. Models should be annotated for binding using Spring data binding through Jakarta and/or Hibernate validation - 3%.
All of my models are annotated as @Entity so they can be bound by Spring Data through Hibernate.
#### c. Include and implement at least two repositories and two service classes/interfaces - 4%.
I included a repository for 4 of my models, and a 4 service classes for my models, as well as an additional service class for Spring Security.
#### d. Include at least two ways to create a managed bean/object - 2%.
I used @Autowired, @Configuration, @Service, @Repository extensively in this project, and perhaps a few other way to manage beans. I used beans extensively in this project.
#### e. Use correct implementations of dependency injection with appropriate use of the @Autowired annotation - 3%.
Many of my classes are @Autowired to their respective repositories so that I can perform CRUD operations.
#### f. Include at least one example of session management (Spring Security can be used for session management) - 3%.
I utilized Spring Security for session management.
#### g. Use Transaction and request/response logging (write log to a file) - 2%.
I included logging to a file in my applications.properties . It currently writes to a file called "comicscrafter.log" in the src/main/resources/logs folder.
#### h . Implement Web Services ( JAX-WS, JAX-RS, or Spring REST ) - 3%.
I utilized Spring REST extensively to implement the front end of my website, and my entire project.
#### i. Include sign-up and login functionality with hashing passwords using bcrypt (Spring Security will satisfy this requirement) - 3%.
I implemented this through Spring Security.

### 6. Unit Testing: 8%
#### a. Test each query method created in the repositories - 3%.
I tested each of the custom query methods I created in the UserRepository, both of them have a test. 
#### b. Test at least one method in each service class - 3%.
I had a very difficult time setting up tests for my service class, other than by testing them in the front end of my project. I didn't create jUnit tests for this.
#### c. Include at least one parameterized test - 2%.
I didn't implement parameterized tests either. This is a weak point for me that I need to work on.

### 7. Presentation: 5%
#### a. Create a short overview of your application - 1%.
In a way, this gitHub readMe is a short overview of my application!
#### b. Highlight the business use cases of your presentation - 1%.
The main goal of this project was to create a tool which would be useful to small comics creators. I believe that this project could be upgraded to a subscription service tool, or a one time purchase tool where users could pay to use the features of the site. In its current state, I don't think it is all that useful of a tool, but if I continue to work on it I believe that this project could turn into something more than it is right now. I created this project based on my fiancee's needs as a small publisher. 
#### c. Highlight how your application works from the technical perspective (high level) - 1%.
A user can create an account, create projects, and link the project to themselves, and link the different types of paper and ink used in the project. This way the user can easily see what supplies they need to order if they are reprinting the project.
#### d. Highlight what you have learned from this case study development - 1%.
Developing a project is hard! It takes a lot of time, research, and decisions to create something which is useful! It is very satisfying creating a final product however, and I hope to work on this more in the future!
#### e. Discuss additional features that you think could be added in the future - 1%.
I think in the future I would definitely implement more of the ideas which I had at the start, such as an automatic price to produce calculator for projects, so users can know exactly how much money it costs to publish their own book. If I were to keep working on it, perhaps I would add referral links to Amazon for various supplies, like different types of ink or paint or paper!

### 8. Project Management (Extra Credit): 5% 
#### e. Successfully track your project using JIRA or Trello - 1%.
The only extra credit I did was tracking this project using Trello! It was a great way to focus on what I needed to work on for the project, and allowed me to make decisions needed to deliver the minimum viable product! I hope to continue using Trello to work on my project in the future!

## Final Thoughts
This project was amazing to work on. I have to give credit to my teacher, Ms. LaTonya Lewis for guiding us through the process from start to finish, and providing us with excellent resources and fantastic teaching. I never thought I would be here months ago, and yet here I am! Thank you Per Scholas for this amazing opportunity, and I hope that I get to work with you all again in the future!


### Resources Used
During this project I relied on some of the Per Scholas projects in order to implement some features.
In particular I would like to note that a lot of my Spring Security is based on the project Lab AC10.1 - Spring Boot + Spring Security + Hibernate + MariaDB(SQL). I made modifications to the code in order for it to work with my project, but the design of the security is very much in line with the lab exercise. 
