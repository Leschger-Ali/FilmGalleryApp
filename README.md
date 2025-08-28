# 🎬 Film Gallery

> ⚠️ **Project Status:** This project is still under development. Upcoming features will include movie categorization (e.g., Action, Drama), linking movies with actors and directors, and much more.

A simple web application to display and manage a movie gallery.  
Built with **Java Spring Boot**, **Spring MVC**, **Spring Data JPA**, **Thymeleaf**, and **SQL Server**.

---

## 🚀 Features

- Display a movie gallery with title, description, and poster image  
- Pagination (9 movies per page) for better performance  
- Dynamic content loaded from SQL Server database  
- Clean architecture with Controller – Service – Repository layers  
- Responsive UI built with Thymeleaf templates, HTML, and CSS  

---

## 🛠️ Technologies Used

- **Backend:** Java 21, Spring Boot 3.x, Spring MVC, Spring Data JPA (Hibernate)  
- **Frontend:** Thymeleaf, HTML5, CSS3  
- **Database:** Microsoft SQL Server  
- **Build Tool:** Maven  

---



## ▶️ How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/YOUR-USERNAME/Film-Gallery.git
   cd Film-Gallery

## 📦 Configure SQL Server
- **Restore the SQL Server database (Backup included) – this repo contains FilmGallery.bak
- **Update your database credentials in application.properties

spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=FilmGallery;encrypt=false
spring.datasource.username=YOUR_DB_USER
spring.datasource.password=YOUR_DB_PASSWORD
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true



##⚡Build and run 
mvn spring-boot:run

## 🌍 Open in browser
- **http://localhost:8080


## 📸 Screenshots
<img width="2123" height="1258" alt="Screenshot 2025-08-28 234659" src="https://github.com/user-attachments/assets/e2156b6d-c71c-4160-9844-ab3447172a7b" />
<img width="1328" height="1067" alt="Screenshot 2025-08-28 234715" src="https://github.com/user-attachments/assets/72c8e936-fc3b-4dff-9acb-ff847f6536d2" />
