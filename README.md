Fights microservice 
============================================

### Introduction

This microservice manages the fights between two players . 

### Releases

0.0.1 - Initial version


### Endpoints

#### [POST] - {basePath}/fights

This endpoint creates a Fight in the system. The system will return either a fight with only one player registered or a fight with both fighters registered.

#### [GET] - {basePath}/fights/{id}

This endpoint retrieves a Fight by its id 	

#### [GET] - {basePath}/fights/{id}/awayFighter

This endpoint retrieves the away fighter registered for a fight. This operation might return a 404 if there is not away fighter registered in the provided Fight.
	
#### [PUT] - {basePath}/fights/{id}/homeFighter

This endpoint requires to execute a fighter in behalf of the homeFighter

#### [PUT] - {basePath}/fights/{id}/awayFighter

This endpoint requires to execute a fighter in behalf of the awayFighter

  	
### Executing

Once you have executed maven build task, you will find a SpringBoot executable jar on target directory. To execute it you only have to run the following command:
		
	java -jar target/players-{VERSION}.jar

Optionally, you can specified the following parameters, although they are not required in the current version:

	--spring.profiles.active=local --spring.cloud.config.enabled=false
	

#### Note

Currently this service is not using a sping cloud config server to retrieve its configuration.

Please, notice that in the bootstrap.yml file we have disabled the spring cloud config feature.


### Configure IDE

You must attach lombok.jar as External Jar to Java Build Path for project compilation on IDE. 
You can download lombok.jar from this location: https://projectlombok.org/ 


### Swagger

The swagger documentation will be available at:

	/swagger-ui.html
	
