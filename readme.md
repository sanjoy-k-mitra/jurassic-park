#h1 jurassic-park
This Application has been developed as SpringBoot Application. requirements for the application are

1. java-8
2. maven
3. mysql

#h3 Database Configuration
Database configurations are available for modifications on '{projectDirectory}/src/main/resources/application.properties' file

Enter your mysql username and password in that file accordingly, and the database url. default database name is 'jurassic_park'.


#h3 Running Application
Open project directory in a terminal window and excute the following command 'mvn spring-boot:run'

This command will create the database tables initial entries and then start the program in 'http://localhost:8080/' 


#h3 using the application
This appliocation exposes 2 api endpoint '/api/dinosaur' and 'api/cage' following is the small description for these 2 endpoint

#h4 '/api/cage'
1. GET request to '/api/cage' creates a full list of Cages
2. GET request to '/api/cage/{id}' gets the Cage with specific id
3. POST request to '/api/cage' creates Cage
4. PUT request to '/api/cage/{id}' with some data updates the Cage with given data (data needs to be 'application/json' format)
5. DELETE request to '/api/cage/{id}' deletes a Dinosaur

#h4 '/api/dinosaur'
1. GET request to '/api/dinosaur' creates a full list of Dinosaurs
2. GET request to '/api/dinosaur/{id}' gets the Dinosaur with specific id
3. POST request to '/api/dinosaur' creates Dinosaur
4. PUT request to '/api/dinosaur/{id}' with some data updates the Dinosaur with given data (data needs to be 'application/json' format)
5. DELETE request to '/api/dinosaur/{id}' deletes a Dinosour

#h3 Making WAR file
'mvn package' command in the project root directory will create WAR file in /target directory

#h4 Sample json for create/update Dinosaur
{
"name":"CCC",
"species":{"id":1},
"cage":{"id":1}
}

 