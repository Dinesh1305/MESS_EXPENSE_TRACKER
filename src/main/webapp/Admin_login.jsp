<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ADMIN LOGIN</title>
  <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
      font-family: "Segoe UI", Arial, sans-serif;
    }

    body {
      background: linear-gradient(135deg, #74ebd5, #ACB6E5);
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .login-container {
      background: #fff;
      padding: 40px;
      border-radius: 15px;
      box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);
      width: 350px;
      animation: fadeIn 1s ease-in-out;
      transition: transform 0.3s ease-in-out;
    }

    .login-container:hover {
      transform: scale(1.03);
    }

    @keyframes fadeIn {
      from { opacity: 0; transform: translateY(-30px); }
      to { opacity: 1; transform: translateY(0); }
    }

    h2 {
      text-align: center;
      margin-bottom: 25px;
      color: #333;
      font-size: 26px;
      letter-spacing: 1px;
    }

    form {
      display: flex;
      flex-direction: column;
    }

    label {
      margin-bottom: 8px;
      font-weight: bold;
      color: #555;
      font-size: 15px;
    }

    input[type="email"],
    input[type="password"] {
      padding: 12px;
      margin-bottom: 20px;
      border: 1px solid #ccc;
      border-radius: 8px;
      width: 100%;
      font-size: 15px;
      transition: all 0.3s ease;
    }

    input[type="email"]:focus,
    input[type="password"]:focus {
      border-color: #4CAF50;
      box-shadow: 0 0 8px rgba(76, 175, 80, 0.3);
      outline: none;
    }

    input[type="submit"] {
      background: linear-gradient(135deg, #4CAF50, #45a049);
      color: white;
      padding: 14px;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      font-size: 18px;
      font-weight: bold;
      transition: background 0.3s ease, transform 0.2s;
    }

    input[type="submit"]:hover {
      background: linear-gradient(135deg, #45a049, #3d8c40);
      transform: scale(1.02);
    }

    .message {
      text-align: center;
      color: #d9534f;
      margin-bottom: 15px;
      font-size: 16px;
      font-weight: 500;
    }

    /* Mobile Responsive */
    @media (max-width: 400px) {
      .login-container {
        width: 90%;
        padding: 30px;
      }
      h2 {
        font-size: 22px;
      }
    }
  </style>
</head>
<body>

  <div class="login-container">
    <h2>ADMIN LOGIN</h2>

    <div class="message">
      <% String message = (String) request.getAttribute("message1"); 
         if (message != null && !message.trim().isEmpty()) { 
             out.println(message); 
         } 
      %>
    </div>

    <form action="admin123" method="post">
      <label for="email">Email</label>
      <input type="email" id="email" name="email" placeholder="Enter your email" required>

      <label for="password">Password</label>
      <input type="password" id="password" name="password" placeholder="Enter your password" required>

      <input type="submit" value="Login">
    </form>
  </div>

</body>
</html>
