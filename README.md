# n11-talenthub-bootcamp-graduation-project
### Built With
* [Java 11](https://www.oracle.com/tr/java/technologies/javase/jdk11-archive-downloads.html)
* [IntelliJ Idea](https://www.jetbrains.com/idea)
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
* [Spring HATEOAS](https://spring.io/projects/spring-hateoas)
* [Open API](https://springdoc.org)
* [MapStruct](https://mapstruct.org)
* [Lombok](https://projectlombok.org)
## About
It's a Spring Boot application about user(customer) service. This application includes a simple scenario about User(Customer) entity. In short, If you want to save a user, you will pass several condition.

| Method       | EndPoint           | Params  |
| ------------- |:-------------:| -----:|
| Post      | /api/v1/users | No Params |
| Get      | /api/v1/users/check/{tc}/{birthday}      |  @{tc}/{birthday} |
| Put | /api/v1/users      |   No Params  |
| Delete | /api/v1/users/{id}      |    @{id} |

**All method**

![image](https://user-images.githubusercontent.com/46068920/151678793-5c18b036-310b-4411-8ade-afe2dcd72be4.png)

**Post method example value**

![image](https://user-images.githubusercontent.com/46068920/151678859-6d847fcc-5db1-412d-a964-07b9c3961d74.png)

### Installation
1. Clone the repo
   ```sh
   git clone https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-melihakan.git
   ```
2. Import the project to your IDE.
3. Open the swagger ui on your browser -> http://localhost:8080/swagger-ui.html

