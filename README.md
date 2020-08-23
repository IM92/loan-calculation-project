# Leanpay team
Loan calculation task

This project is using:
- Java 8 JDK
- Spring Boot (Framework)
- Spring Boot for developing RESTful API
- MYSQL as SQL solution for storing data from API
- Spring Data JPA for developing JPA repositories/Data for MYSQL  
- Project Lombok for reducing boilerplate code
- Docker as containerized environment
- Junit and Mockito for testing

#Start the project

## Built With

Build with gradle:
```
mvn clean install
```
Run docker-compose command on project root to create images of mysql server database that runs on 3306 port
with created user: username: kdbuser ; password: kdbpass
```
docker-compose -f docker-compose.yml up
```
##Run the Application:
As we are ready with all the changes, let us compile the spring boot project and run the application as a java project. Go to Run and Run ProjectApplication.
We can run this maven comand 
````
>> mvn spring-boot:run
````
# Implementation decision notes

### Populate data in MYSQL
In order to populate the MYSQL database with correct data we need to trigger the POST api call:
 - /secure/loanInfo/installment-plan

We need to provide initial data for Request body in order for us trigger 
major logic for calculating the loan value.
 ```
{
  "amount": 1000,
  "numberOfMonths": 10,
  "annualInterestPercent": 5
}
 ```

# REST Endpoints
```
Create Calculated Loan Info
POST http://localhost:8009/secure/loanInfo/installment-plan
```

## APIs Documentation
Swagger is used tool for API documentation.

http://localhost:8080/swagger-ui.html#/

# Improvements
- Improve existing and add more tests (especially integration tests) with e2e and Junit
- Provide one more layer of abstraction for the calculation part
- As final part from this task will be for example to deploy the project on one of the platforms (Heroku)
- Add authentication/authorization, maybe implement SpringSecurity for this api call. But
since there was only need for one call I figure it will be a huge over engineering effort.    

## Authors

* **Ivan Milanovic** - *Initial work* - [IM92](https://github.com/IM92)