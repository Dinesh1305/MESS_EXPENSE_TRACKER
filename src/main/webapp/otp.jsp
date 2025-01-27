<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter OTP</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f4f4f4;
        }
        .container {
            text-align: center;
            background: white;
            padding: 30px; 
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            width: 350px; 
        }
        h1 {
            color: #4CAF50;
            font-size: 24px; 
            margin-bottom: 20px; 
        }
        input {
            margin-bottom: 15px; 
            width: 100%;
            height: 40px; 
            font-size: 16px; 
            padding: 8px; 
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            width: 100%;
            height: 40px; 
            font-size: 16px; 
            margin-top: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Enter OTP</h1>
        <form action="verify" method="post">
            <label for="otp">OTP:</label><br>
            <input type="text" id="otp" name="otp" required><br>
            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
