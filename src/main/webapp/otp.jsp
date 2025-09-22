<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter OTP</title>
    <style>
        body {
            margin: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(135deg, #6dd5ed, #2193b0);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        .container {
            background: rgba(255, 255, 255, 0.95);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0px 8px 25px rgba(0, 0, 0, 0.2);
            width: 360px;
            text-align: center;
            transition: transform 0.3s ease-in-out;
        }

        .container:hover {
            transform: scale(1.03);
        }

        h1 {
            color: #333;
            font-size: 26px;
            margin-bottom: 10px;
        }

        p {
            font-size: 14px;
            color: #666;
            margin-bottom: 25px;
        }

        input[type="text"] {
            width: 100%;
            height: 50px;
            font-size: 20px;
            font-weight: bold;
            letter-spacing: 8px;
            text-align: center;
            border: 2px solid #ccc;
            border-radius: 8px;
            outline: none;
            transition: border-color 0.3s, box-shadow 0.3s;
        }

        input[type="text"]:focus {
            border-color: #4CAF50;
            box-shadow: 0 0 8px rgba(76, 175, 80, 0.4);
        }

        button {
            width: 100%;
            height: 50px;
            font-size: 18px;
            margin-top: 20px;
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
            font-size: 14px;
            color: #007BFF;
            cursor: pointer;
            display: inline-block;
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
        <p>Please enter the OTP sent to your email/phone</p>
        
        <form action="verify" method="post">
            <input type="text" id="otp" name="otp" maxlength="6" placeholder="••••••" required>
            <button type="submit">Verify OTP</button>
        </form>
        
        <span class="resend">Resend OTP</span>
    </div>
</body>
</html>
