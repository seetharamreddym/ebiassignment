# Person REST API

### Prerequisites
Maven
Java8

## API details

person spring boot application exposes a singel REST Endpoint for performing insert, update, delete and get operations on persons.
This REST API also exposes one end point for bulk insert of multiple persons at once in batch mode.

All person data maintained in the H2 in-memory database, So when we restart application everything will be lost.

/persons is the end point which will handle all operations on person.

## Security details

Implemented spring basic authentication/autherization via login password, for the time being I have hard coded user.
When we are trying to test any API method need to supply authentication/authorization information in the form of username and password.

Username:  admin
password:  admin123
Role    :  ADMIN


## API operations  

For all operations we need provide content-type header and autharization infromation.

### Headers:

content-type : application/json

### Authorization:

Type : Basic Auth  

Username:  admin
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
            "first_name": "vandana",
            "last_name": "reddy",
            "age": 38,
            "favourite_color": "black",
            "hobby": [
                "music"
            ]
        }
    ]
}


### how to install 

$ mvn clean install

## To run the person spring boot application

$ java -jar target\person-0.0.1-SNAPSHOT.jar



## TODO improvements

pagination for get all persons instead of all at once with pagination jpa respository.
Localization of all  messages through ResourceManager.
