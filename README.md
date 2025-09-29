🍱 Mess Bill Management System
A Java Servlet-based web application designed to digitize the food token system in college hostels. This system simplifies non-veg token booking, automates bill calculations, and generates Excel reports — eliminating the need for manual processes and enhancing efficiency, transparency, and student experience.

📌 Overview
In traditional hostel setups, non-vegetarian token distribution is often manual, error-prone, and time-consuming. This project streamlines the entire process through:

OTP-based student authentication

Digital meal booking system (Veg/Non-Veg)

Automated mess bill generation

Excel export for admin reports

🧰 Tech Stack
Layer	Technology
Backend	Java Servlets (Jakarta EE)
Database	MySQL
Email OTP	JavaMail API (javax.mail)
Excel I/O	Apache POI
Build Tool	Maven
Frontend	JSP, HTML, CSS
Server	Apache Tomcat

✨ Features
👨‍🎓 Student Module
🔐 OTP-Based Login: Secure email-based authentication.

🍽️ Token Booking: Choose from items like Chicken Biryani, Egg Gravy, Boiled Egg, etc.

📩 Email Notification: OTP and booking confirmation sent via Gmail SMTP.

🧾 Bill Tracking: Students can view their daily token usage and total cost.

👨‍💼 Admin Module
📊 Excel Export: Generate monthly/weekly reports using Apache POI.

📋 Bill Monitoring: Track token count and cost per student.

🍱 Menu Management: Control food items and pricing.

🛡️ Secure Admin Login: Restricted access to reports and configurations.

🛠️ How to Run the Application
Clone the Repository

bash
Copy
Edit
git clone https://github.com/Dinesh1305/MESS_MANAGEMENT.git
Open in IDE

Use Eclipse, NetBeans, or IntelliJ IDEA

Add Dependencies

MySQL Connector

JavaMail API

Apache POI

Configure Database and Email

Update DBConnection.java with your MySQL credentials

Update otp.java with your SMTP credentials (for Gmail)

Deploy to Tomcat

Start Apache Tomcat

Access the app at: http://localhost:8080/MESS_MANAGEMENT/

🧱 Database Schema
sql
Copy
Edit
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
📁 Sample Excel Report
File Path:
C:\Users\praga\OneDrive\Documents\New folder\Book2.xlsx

Email	Total Cost
user1@gmail.com	₹220
user2@gmail.com	₹130

💸 Price Chart
Item	Price
Chicken Biryani	₹120
Chicken 65	₹90
Boiled Egg	₹20

🔐 Admin Credentials (For Demo)
makefile
Copy
Edit
Email:    admin@123gmail.com  
Password: admin123

Output
![Mess Bill Management System](https://raw.githubusercontent.com/Dinesh1305/MESS_EXPENSE_TRACKER/main/images/Screenshot%202025-09-29%20104153.png)



🙋‍♂️ Author
Dinesh M
📍 Pre-Final Year CSE Student | Full-Stack & Blockchain Developer
🔗 LinkedIn
💻 GitHub

“Built and deployed for real-world use in my college hostel to eliminate the non-veg token chaos!” 🏫

