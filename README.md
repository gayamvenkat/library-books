# Project to manage books in a library.
 **CRUD application made with Spring Boot to maintain books in library** 
    <li>  JDK 8 </li>
    <li> Sring boot 2.4.5 </li>
    <li> spring boot data JPA</li>
    <li>  H2 database </li>
    <li> lombok </li>
    <li> commons-csv </li>
    <li> Swagger-springfox </li>
    

 **Git Clone and setup in the IDE**
 
 https://github.com/gayamvenkat/library-books.git
 
  <li>  File -> Import -> Maven -> Existing Maven Projects -> Browse Project from cloned location </li>
  

**Run Project**
  <li>   Build maven project e.g mvn clean install </li>
  <li>   Run the project using  java -jar target/books-0.0.1-SNAPSHOT.jar  </li>
  <li>  To run from any IDE , Run as  spring boot application  </li>
  
**Access APIS**

   <li> Access swagger from http://localhost:8080/swagger-ui/  </li>
   <li>  Take CSV template (book.csv) from  /src/main/resources  to upload books  </li>
  
   <li> From swagger UI  access all CRUD APIS  </li>
  
**Curl requests to access APIS**
 <p>
  curl -X GET "http://localhost:8080/books/123" -H "accept:*/* "
    </p>
  
  <p> curl -X POST "http://localhost:8080/books/addBooks" -H "accept:*/*" -H "Content-Type: application/json" -d "[ { \"author\": \"testpostauthor\", \"isbn\": 130, \"tags\": [ \"posttag\" ], \"title\": \"posttitle\" }]" </p>
  
  <p> curl -X PUT "http://localhost:8080/books/123" -H "accept:*/*" -H "Content-Type: application/json" -d "{ \"isbn\": 123, \"title\": \"testTile1updated\", \"author\": \"testauthor1\", \"tags\": [ \"tag1\" ]}" </p>
  
  <p> curl -X DELETE "http://localhost:8080/books/123" -H "accept: */*" </p>
  
<p>  curl --location --request POST 'http://localhost:8080/books/uploadBooks' \
--header 'Accept: application/json' \
--header 'Content-Type: multipart/form-data' \
--form 'file=@"CSV location"'   </p>

  
**Junits**
<li> Added integration test cases </li>
<li> wrote  tests using the mocking approach (spring mockMVC). </li>
