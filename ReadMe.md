# Person REST API

## UI for validating API operations

All these APIs can be validated through react based UI project https://github.com/seetharamreddym/ebiassignmentui

### Prerequisites
Maven <br/>
Java8

## API details

person spring boot application exposes a single REST endpoint for performing insert, update, delete and get operations on persons.
This REST API also exposes one method for bulk insert of multiple persons at once in batch mode.

All persons data maintained in H2 in-memory database, So on application restart all data will be removed from DB.

/persons is the end point which will handle all operations.

## Security details

Implemented  basic  security in the form of username and password for all API access, with this application is authenticating/authorizing  the user. 
I have hard coded user to demonstrate the security feature.
To test any API method user need to supply authentication/authorization information in the form of username and password.

Username:  admin <br/>
Password:  admin123



## API operations  

For all operations we need provide content-type header and authorization information.

### Headers:

content-type : application/json

### Authorization:

Type : Basic Auth  

Username:  admin  <br/>
password:  admin123

### Insert a person 

URL :  http://localhost:8080/persons  
Method: POST

request payload

{
	"first_name":"seetharam",
	"last_name": "reddy",
	"age":"38",
	"favourite_color":"black",
	"hobby": ["music"]

}


### Insert list of persons
 

URL :  http://localhost:8080/persons/bulk  
Method: POST

request payload

{
    "person": [
        {
            "id": 1,
            "first_name": "seetharam",
            "last_name": "reddy",
            "age": 38,
            "favourite_color": "black",
            "hobby": [
                "music"
            ]
        },
        {
            "id": 3,
            "first_name": "mohan",
            "last_name": "reddy",
            "age": 40,
            "favourite_color": "black",
            "hobby": [
                "reading"
            ]
        }
    ]
}


### Update a person 

URL :  http://localhost:8080/persons  
Method: POST

request payload

{   "id" : "1"
	"first_name":"vamsi",
	"last_name": "raghava",
	"age":"38",
	"favourite_color":"blue",
	"hobby": ["music", "reading"]

}


## Get all persons 

URL:  http://localhost:8080/persons

Method: GET

## Get a person by id

We need pass  user id in url

Method: GET

http://localhost:8080/persons/1

## Delete a person

We need pass  user id in url

Method: DELETE

http://localhost:8080/persons/1


### how to install 

$ mvn clean install

## To run the person spring boot application

$ java -jar target\person-0.0.1-SNAPSHOT.jar



# Global exception handler

This will handle person not found or internal server errors and generate appropriate error response.


## TODO improvements

##### pagination for get all persons instead of all at once with pagination jpa respository.
##### Localization of all  messages through ResourceManager.
##### Use swagger to generate API classes ( partially done but not completed)
#### Combine API and UI projects in single project as hybrid application

