# sprint-boot-api-with-mysql-and-list
It is very basic project to start sprint boot api

## Prerequisites:

* Ubuntu 16.04 - 64bit
* 2 GB or more memory (Recommended)
* Root Privileges // command for get root privileges: sudo -s
* Java 1.8.x
* Apache Maven 3.x.x
* Tomcat 8.x.x
* Mysql 5.x.x

 Update resource file src/main/resources/application.properties with your mysql credentials
```sql
-- ----------------------------
-- Table structure for `User`
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(191) DEFAULT '',
  `email` varchar(191) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of User
-- ----------------------------
INSERT INTO `User` VALUES ('1', 'saqi', 'saqi@gmail.com');
INSERT INTO `User` VALUES ('2', 'ffk', 'ffk@gm.com');
```
## Note: 
you have to stop tomcat and free port 8080 to start this project. It will auto start tomcat and bound port 8080
## run the command from project root:
mvn clean package

## run to start the project
mvn spring-boot:run
## or
java -jar path-to-jar

## Retrieve all Persons

Open POSTMAN tool, select request type [GET for this usecase], specify the uri http://localhost:8080/api/persons/ and Send., should retrieve all Persons.

## Retrieve all users

Open POSTMAN tool, select request type [GET for this usecase], specify the uri http://localhost:8080/all/ and Send., should retrieve all users.

## This is what our REST API does:

* GET request to /api/person/ returns a list of persons
* GET request to /api/person/1 returns the person with ID 1
* POST request to /api/person/ with a person object as JSON creates a new person
* PUT request to /api/person/3 with a person object as JSON updates the person with ID 3
* DELETE request to /api/person/4 deletes the person with ID 4
* DELETE request to /api/person/ deletes all the persons


Detailed Explanation :

@RestController : First of all, we are using Spring 4′s new @RestController annotation. This annotation eliminates the need of annotating each method with @ResponseBody. Under the hood, @RestController is itself annotated with @ResponseBody, and can be considered as combination of @Controller and @ResponseBody.

@RequestBody : If a method parameter is annotated with @RequestBody, Spring will bind the incoming HTTP request body(for the URL mentioned in @RequestMapping for that method) to that parameter. While doing that, Spring will [behind the scenes] use HTTP Message converters to convert the HTTP request body into domain object [deserialize request body to domain object], based on ACCEPT or Content-Type header present in request.

@ResponseBody : If a method is annotated with @ResponseBody, Spring will bind the return value to outgoing HTTP response body. While doing that, Spring will [behind the scenes] use HTTP Message converters to convert the return value to HTTP response body [serialize the object to response body], based on Content-Type present in request HTTP header. As already mentioned, in Spring 4, you may stop using this annotation.

ResponseEntity is a real deal. It represents the entire HTTP response. Good thing about it is that you can control anything that goes into it. You can specify status code, headers, and body. It comes with several constructors to carry the information you want to sent in HTTP Response.

@PathVariable This annotation indicates that a method parameter should be bound to a URI template variable [the one in '{}'].

Basically, @RestController , @RequestBody, ResponseEntity & @PathVariable are all you need to know to implement a REST API in Spring. Additionally, spring provides several support classes to help you implement something customized.

MediaType : Although we didn’t, with @RequestMapping annotation, you can additionally, specify the MediaType to be produced or consumed (using produces or consumes attributes) by that particular controller method, to further narrow down the mapping.





