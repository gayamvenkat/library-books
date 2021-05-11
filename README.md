# project to manage books in a library.
**CRUD library application made with Spring Boot to maintain books ** 
    <li>  JDK 8 </li>
    <li> Sring boot 2.4.5 </li>
    <li> spring boot data JPA</li>
    <li>  h2database </li>
    <li> projectlombok </li>
    <li> commons-csv </li>
    <li> Swagger-springfox </li>
    

# 1) Clone or download the project from 
 https://github.com/gayamvenkat/library-books.git

**Import project into IDE**
  <li>  File -> Import -> Maven -> Existing Maven Projects -> Browse Project from cloned location </li>
  <li>   Build maven project e.g mvn clean install </li>
  <li>   Run the project using  java -jar target/books-0.0.1-SNAPSHOT.jar  </li>
  <li>  Take CSV template from  /src/main/resources  </li>
  <li>  curl --location --request POST 'http://localhost:8080/books/uploadBooks' \
--header 'Accept: application/json' \
--header 'Content-Type: multipart/form-data' \
--form 'file=@"CSV location"'
</li>
    
  <li> Access swagger from http://localhost:8080/swagger-ui/ </li>
  
   <li> FROM swagger UI  access all CRUD APIS  </li>
  

  
 
  
  



