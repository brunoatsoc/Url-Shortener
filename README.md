# 🔗 URL Shortener

A simple link shortener that lets you turn long URLs into short, easy-to-share links.

## 🚀 How it works

The project exposes an endpoint for shortening links:

- **POST** A simple link shortener that lets you turn long URLs into short, easy-to-share links.`http://localhost:8080/url-shortener/shorten`  
  - **Body (JSON):**
    ```json
    {
      "url": "https://exemplo.com/alguma-url-bem-grande"
    }
    ```
  - **Response (JSON):**
    ```json
    {
      "shortUrl": "http://localhost:8080/url-shortener/{short-url}"
    }
    ```

- **GET** `http://localhost:8080/url-shortener/{short-url}`  
  - Redireciona automaticamente para a URL original.

## 🛠️ Technologies

- Java / Spring Boot
- PostgreSQL
- API REST

## ⚙️ How to Run

### Prerequisites

- Java 21
- Maven
- PostgreSQL (with a database configured in `application.properties`)

### Application Properties Settings

- app.server-link-base=http://localhost:8080/url-shortener/
- app.link-characters=ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-+
- app.url-expire-time-minutes=60
- app.short-url-size=10

- spring.datasource.url=jdbc:postgresql://localhost:5432/url_shortener
- spring.datasource.username=postgres
- spring.datasource.password=postgres
- spring.datasource.driver-class-name=org.postgresql.Driver

- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.open-in-view=false

- logging.level.com.bruno=DEBUG

### Steps to run

# Clone the repository
git clone https://github.com/brunoatsoc/Url-Shortener.git

# Access the project folder
cd url-shortener

# Run the application
./mvnw spring-boot:run

### Dependencies

- Spring Boot Starter Data JPA
- Spring Boot Starter Validation
- Spring Boot Starter Web
- Spring Boot Devtools
- PostgreSQL Driver
- Lombok
- Spring Boot Starter Test
   
   
## 🧑‍💻 Author

**Bruno Santos Costa**  
Java Developer | Spring Boot Enthusiast

[![LinkedIn](https://img.shields.io/badge/LinkedIn-brunocosta-blue?logo=linkedin)](https://www.linkedin.com/in/bruno-costa-698a82159/)  
📧 E-mail: [brunosantos20003237@gmail.com](mailto:brunosantos20003237@gmail.com)
