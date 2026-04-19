# Library Management System 📚

A web-based **Library Management System** built with **Java 21** and the **Spring Boot** framework. This application allows users to manage a catalog of books, including their associated authors, categories, and publishers.

## 🚀 Features

* **Book Management**: Create, read, update, and delete (CRUD) books with details like ISBN, name, and description.
* **Author Management**: Keep track of authors and their specific biographies.
* **Category & Publisher Tracking**: Organize the library by genre/category and manage publisher information.
* **Responsive UI**: Built with **Thymeleaf** templates and **Bootstrap** for a clean, responsive user experience.
* **Seed Data**: Automatically populates the database with classic titles like *Dune*, *The Hobbit*, and *Clean Code* upon startup.

## 🛠 Tech Stack

* **Backend**: Java 21, Spring Boot 4.0.5
* **Database**: H2 (In-memory)
* **ORM**: Spring Data JPA / Hibernate
* **Frontend**: Thymeleaf, HTML5, Bootstrap 5.3.8
* **Utilities**: Lombok

## 📋 Prerequisites

* **Java Development Kit (JDK) 21** or higher
* **Maven** (or use the included Maven Wrapper)

## 🏗 Getting Started

1.  **Clone the repository**:
    ```bash
    git clone <your-repo-url>
    cd Library
    ```

2.  **Build the project**:
    ```bash
    ./mvnw clean install
    ```

3.  **Run the application**:
    ```bash
    ./mvnw spring-boot:run
    ```

4.  **Access the application**:
    Open your browser and navigate to `http://localhost:8080`

## 🗄 Database Console

The application uses an H2 in-memory database for development. You can access the console at:
* **URL**: `http://localhost:8080/h2-console`
* **JDBC URL**: `jdbc:h2:mem:application-library-management-system`
* **User**: `sa`
* **Password**: (leave blank)

## 📁 Project Structure

* `src/main/java/com/application/library/entity`: Contains JPA entities (Book, Author, etc.).
* `src/main/java/com/application/library/controller`: Web controllers handling HTTP requests.
* `src/main/java/com/application/library/service`: Business logic layer.
* `src/main/resources/templates`: Thymeleaf HTML templates for the UI.
