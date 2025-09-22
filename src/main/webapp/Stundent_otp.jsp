<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OTP Verification</title>
    <style>
        body {
            margin: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: "Segoe UI", Arial, sans-serif;
            background: linear-gradient(135deg, #74ebd5, #ACB6E5);
        }

        .container {
            background: rgba(255, 255, 255, 0.95);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);
            width: 380px;
            text-align: center;
            transition: transform 0.3s ease-in-out;
        }

        .container:hover {
            transform: scale(1.03);
        }

        h1 {
            color: #333;
            font-size: 26px;
            margin-bottom: 15px;
        }

        p {
            color: #666;
            font-size: 14px;
            margin-bottom: 25px;
        }

        input {
            width: 100%;
            height: 50px;
            font-size: 18px;
            padding: 10px;
            border: 2px solid #ddd;
            border-radius: 8px;
            outline: none;
            margin-bottom: 20px;
            transition: border-color 0.3s, box-shadow 0.3s;
        }

        input:focus {
            border-color: #4CAF50;
            box-shadow: 0 0 10px rgba(76, 175, 80, 0.3);
        }

        button {
            width: 100%;
            height: 50px;
            font-size: 18px;
            background: linear-gradient(90deg, #4CAF50, #45a049);
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background 0.3s, transform 0.2s;
        }

        button:hover {
            background: linear-gradient(90deg, #45a049, #3e8e41);
            transform: translateY(-2px);
        }

        .resend {
            margin-top: 15px;
            display: inline-block;
            font-size: 14px;
            color: #007BFF;
            cursor: pointer;
            transition: color 0.3s;
        }

        .resend:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>OTP Verification</h1>
        <p>Please enter the OTP sent to your registered email/phone</p>
        
        <form action="bookToken" method="post">
            <input type="text" id="otp" name="otp" placeholder="Enter OTP" required>
            <button type="submit">Verify OTP</button>
        </form>

        <span class="resend">Resend OTP</span>
    </div>
</body>
</html>
