<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>STUDENT LOGIN</title>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
  <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
      font-family: 'Poppins', Arial, sans-serif;
    }

    body {
      background: linear-gradient(135deg, #74ebd5, #9face6);
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      animation: bgShift 10s infinite alternate ease-in-out;
    }

    @keyframes bgShift {
      from { background-position: left; }
      to { background-position: right; }
    }

    .login-container {
      background: #fff;
      padding: 50px 40px;
      border-radius: 15px;
      box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);
      width: 400px;
      text-align: center;
      animation: fadeIn 1s ease-in-out;
      transition: transform 0.3s ease;
    }

    .login-container:hover {
      transform: scale(1.03);
    }

    @keyframes fadeIn {
      from { opacity: 0; transform: translateY(20px); }
      to { opacity: 1; transform: translateY(0); }
    }

    h2 {
      margin-bottom: 25px;
      color: #333;
      font-size: 28px;
      font-weight: 600;
      letter-spacing: 1px;
    }

    form {
      display: flex;
      flex-direction: column;
      width: 100%;
    }

    label {
      margin-bottom: 8px;
      font-weight: bold;
      color: #444;
      font-size: 16px;
      text-align: left;
    }

    input[type="email"],
    input[type="password"] {
      padding: 14px;
      margin-bottom: 18px;
      border: 1px solid #ccc;
      border-radius: 8px;
      width: 100%;
      font-size: 15px;
      transition: all 0.3s ease;
    }

    input[type="email"]:focus,
    input[type="password"]:focus {
      border-color: #4CAF50;
      box-shadow: 0 0 10px rgba(76, 175, 80, 0.3);
      outline: none;
    }

    input[type="submit"] {
      background: linear-gradient(135deg, #4CAF50, #3d8c40);
      color: white;
      padding: 14px;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      font-size: 18px;
      font-weight: 600;
      transition: background 0.3s ease, transform 0.2s;
    }

    input[type="submit"]:hover {
      background: linear-gradient(135deg, #45a049, #367c39);
      transform: scale(1.05);
    }

    .message {
      text-align: center;
      color: #d9534f;
      margin-bottom: 18px;
      font-size: 16px;
      font-weight: 500;
    }

    /* Mobile Responsive */
    @media (max-width: 450px) {
      .login-container {
        width: 90%;
        padding: 40px 25px;
      }
      h2 {
        font-size: 24px;
      }
    }
  </style>
</head>
<body>
<% 
    Boolean isLoggedIn = (Boolean) request.getAttribute("message"); 
    if (isLoggedIn != null) { 
        if (isLoggedIn) {
            response.sendRedirect("Book.jsp");
        } else {
            request.setAttribute("message1", "INVALID PASSWORD ❌");
        }
    }
%>

  <div class="login-container">
    <h2>🔑 STUDENT LOGIN</h2>
   
    <div class="message">
      <% String message = (String) request.getAttribute("message1"); 
         if (message != null && !message.isEmpty()) { 
             out.println(message); 
         } 
      %>
    </div>

    <form action="add" method="post">
      <label for="email">📧 Email:</label>
      <input type="email" id="email" name="email" placeholder="Enter your email" required>

      <label for="password">🔒 Password:</label>
      <input type="password" id="password" name="password" placeholder="Enter your password" required>

      <input type="submit" value="Login">
    </form>
  </div>
</body>
</html>
