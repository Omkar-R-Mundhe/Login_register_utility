# Dynamic Web Project in Java (Login & Register System)

This project is a basic dynamic web application built using Java (JSP & Servlets), providing **user authentication** features such as **Login** and **Registration**. It is ideal for beginners who are learning Java web development and want to understand how to connect frontend forms with backend logic using Java and databases.

## Features

- User Registration
- User Login
- Input validation
- Password encryption 

## Technologies Used

- Java (Servlets, JSP)
- Apache Tomcat (Recommended: v9 or above)
- JDBC for Database Connectivity
- MySQL / any relational database
- HTML, CSS (for frontend)

## Prerequisites

- JDK 8 or above
- Apache Tomcat server
- MySQL or any SQL database
- IDE (Eclipse, IntelliJ IDEA, NetBeans)
- Maven (if using)

## Project Structure
```
Login_register_utility/
│
├── src/
│ ├── controller/ # Servlets for handling requests
│     ├── login
│     ├── register
│ └── DAO/ # Java classes for DB operations
│      ├── daoLogin
│     ├── daoRegister
│ └── model /# Java classes for model
│     ├── User
│     ├── registerUser
│ └── Utility /# Java class to handle db connection
│     ├──dbConnection
│
├── WebContent/
│ ├── register.html # Registration page
│ ├── login.html # Login page
│ ├── sucessful.html # success page after login
│ ├── error.html # Error handling page
│ └── WEB-INF/
│ └── web.xml # Deployment descriptor
│
└── README.md
```



## Database Setup

1. Create a database (e.g., `userdb`)
2. Create a table for users:

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```
3. Update your DB connection details in your project (DBUtil.java or similar):
```sql
private static final String URL = "jdbc:mysql://localhost:3306/userdb";
private static final String USER = "root";
private static final String PASSWORD = "yourpassword";
```

How to Run

  1.Clone or download the project.

  2.Import into your IDE as a Dynamic Web Project.

  3.Configure Tomcat server in your IDE.

  4.Set up the database and update DB credentials in code.

  5.Build and deploy the project on Tomcat.

  6.Access the app at:
    http://localhost:8080/DynamicWebProject/login.jsp



Developed by: Omkar
Contact: ommundhe67@gmail.com
