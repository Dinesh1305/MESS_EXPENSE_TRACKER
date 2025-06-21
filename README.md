🍱 Mess Bill Management System
A Java Servlet-based web application to digitize the food token system in college hostels. This system supports OTP-based meal booking, mess bill tracking, and Excel report generation — eliminating the need for manual token distribution and making the process fast and transparent.
📌 Overview
In traditional hostel systems, non-veg token distribution is manual, time-consuming, and inefficient. This project addresses that by providing:
- Student and admin login
- Meal token booking (veg/non-veg)
- OTP verification using javax.mail
- Bill calculation and Excel export (Apache POI)
- MySQL backend for data persistence
🧰 Tech Stack
- Backend: Java Servlets (Jakarta EE)
- Database: MySQL
- Email OTP: JavaMail (javax.mail)
- Excel I/O: Apache POI
- Build Tool: Maven
- Frontend: JSP, HTML, CSS
- Server: Apache Tomcat
✨ Key Features
- 🔐 Login with OTP (Student authentication via email)
- 🍗 Token Booking for food items like Chicken Biryani, Egg Gravy, etc.
- 📊 Excel Integration for storing mess bills per student
- 📧 Email Notifications via Gmail SMTP using javax.mail
- 📋 Admin Login for menu control and report review
🗂️ Folder Structure

MessBillManagement/
├── src/ 
│   ├──  MANAGEMENT/
│   │   ├──  Addtokens.java
│   │   ├──  Check.java
│   │   ├──  admin_side.java
│   │   ├──  otp.java
│   │   ├──  Excel.java
│   │   └──  Verification.java
├──  webapp/
│   ├──  index.jsp
│   ├──  Stundent_otp.jsp
│   └──  otp.jsp
├──  lib/
│   ├──  mysql-connector-java.jar
│   ├──  poi.jar
│   └──  javax.mail.jar

🛠️ How to Run
1. Clone the repo
2. Import into Eclipse / NetBeans / IntelliJ
3. Add external libraries to the build path:
   - MySQL Connector
   - JavaMail (javax.mail)
   - Apache POI (for Excel I/O)
4. Update configurations in DBConnection.java and otp.java
5. Start Apache Tomcat and access on http://localhost:8080/MESS_MANAGEMENT/
📄 Database Schema (mb)

CREATE DATABASE mb;

USE mb;

CREATE TABLE details (
    email VARCHAR(100) PRIMARY KEY,
    password VARCHAR(100)
);

CREATE TABLE dailybill (
    email VARCHAR(100),
    token_count INT,
    ott INT
);

📁 Excel Report Sample

File generated at:
C:\Users\praga\OneDrive\Documents\New folder\Book2.xlsx

| Email               | Total Cost |
|---------------------|------------|
| user1@gmail.com     | 220        |
| user2@gmail.com     | 130        |

Food prices:
- Chicken Biryani: ₹120
- Chicken 65: ₹90
- Boiled Egg: ₹20

🧪 Admin Credentials
Email: admin@123gmail.com
Password: admin123
🙋‍♂️ Author
Dinesh M
LinkedIn: https://www.linkedin.com/in/dinesh-m-b3827528b/
GitHub: https://github.com/Dinesh1305

“Built for real-world use in my college hostel to eliminate the non-veg token chaos!” 🏫
