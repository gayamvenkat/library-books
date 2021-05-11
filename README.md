# project to manage books in a library.
 **CRUD application made with Spring Boot to maintain books in library** 
    <li>  JDK 8 </li>
    <li> Sring boot 2.4.5 </li>
    <li> spring boot data JPA</li>
    <li>  H2 database </li>
    <li> lombok </li>
    <li> commons-csv </li>
    <li> Swagger-springfox </li>
    

 **Clone or download the project from**
 https://github.com/gayamvenkat/library-books.git

**Import project into IDE**
  <li>  File -> Import -> Maven -> Existing Maven Projects -> Browse Project from cloned location </li>
  <li>   Build maven project e.g mvn clean install </li>
  <li>   Run the project using  java -jar target/books-0.0.1-SNAPSHOT.jar  </li>
  <li>  To run from any IDE , Run as  spring boot application  </li>
  
  <li>  Take CSV template (book.csv) from  /src/main/resources  </li>
  <li>  curl --location --request POST 'http://localhost:8080/books/uploadBooks' \
--header 'Accept: application/json' \
--header 'Content-Type: multipart/form-data' \
--form 'file=@"CSV location"'
</li>
  <li> Access swagger from  </li>
  <li>  http://localhost:8080/swagger-ui/  </li>
   
  <li> From swagger UI  access all CRUD APIS  </li>
  **Curl requests to access APIS** 
     <li>  curl -X GET "http://localhost:8080/books/123" -H "accept: */* "  </li>
     <li>curl -X POST "http://localhost:8080/books/addBooks" -H "accept: */*" -H "Content-Type: application/json" -d "[ { \"author\": \"testpostauthor\", \"isbn\": 130, \"tags\": [ \"posttag\" ], \"title\": \"posttitle\" }]"  </li>
     <li> curl -X PUT "http://localhost:8080/books/123" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"isbn\": 123, \"title\": \"testTile1updated\", \"author\": \"testauthor1\", \"tags\": [ \"tag1\" ]}" </li>
     <li> curl -X DELETE "http://localhost:8080/books/123" -H "accept: */*" </li>
     
     
     



