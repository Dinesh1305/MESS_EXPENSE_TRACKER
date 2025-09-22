<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.util.*" %> 
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Book Your Token</title>
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
      flex-direction: column;
      height: 100vh;
      animation: bgMove 10s infinite alternate ease-in-out;
    }

    @keyframes bgMove {
      from { background-position: left; }
      to { background-position: right; }
    }

    .container {
      text-align: center;
      background: #fff;
      padding: 25px 20px;
      border-radius: 15px;
      box-shadow: 0 8px 25px rgba(0, 0, 0, 0.15);
      width: 320px;
      animation: fadeIn 1s ease-in-out;
      transition: transform 0.3s ease;
    }

    .container:hover {
      transform: scale(1.03);
    }

    @keyframes fadeIn {
      from { opacity: 0; transform: translateY(20px); }
      to { opacity: 1; transform: translateY(0); }
    }

    img {
      max-width: 100%;
      height: auto;
      border-radius: 12px;
      margin-bottom: 15px;
      box-shadow: 0 5px 15px rgba(0,0,0,0.1);
    }

    h1 {
      margin-bottom: 12px;
      color: #333;
      font-size: 24px;
      font-weight: 600;
    }

    p {
      color: #555;
      font-size: 15px;
      margin-bottom: 20px;
    }

    .button {
      background: linear-gradient(135deg, #4CAF50, #3d8c40);
      color: white;
      padding: 12px 20px;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      font-size: 16px;
      font-weight: 600;
      margin: 8px;
      transition: all 0.3s ease;
    }

    .button:hover {
      background: linear-gradient(135deg, #45a049, #367c39);
      transform: scale(1.05);
    }

    .button.secondary {
      background: linear-gradient(135deg, #ff4e50, #f9d423);
      color: #fff;
    }

    .button.secondary:hover {
      background: linear-gradient(135deg, #f44336, #ff9800);
    }

    .message {
      color: #d9534f;
      margin-top: 15px;
      font-weight: 500;
    }

    @media (max-width: 400px) {
      .container {
        width: 90%;
        padding: 20px;
      }
      h1 {
        font-size: 20px;
      }
    }
  </style>
</head>
<body>

<%
    Calendar calendar = Calendar.getInstance();
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

    String foodItem;
    String foodImage;

    switch (dayOfWeek) {
        case Calendar.TUESDAY:
            foodItem = "Chicken Briyani";
            foodImage = "image/brr.jpg";
            break;
        case Calendar.MONDAY:
            foodItem = "Egg Gravy";
            foodImage = "image/egggravy.jpg";
            break;
        case Calendar.WEDNESDAY:
            foodItem = "Chicken Gravy";
            foodImage = "image/chickengravy.jpg";
            break;
        case Calendar.THURSDAY:
            foodItem = "Cauliflower Curry";
            foodImage = "image/cauliflower.jpeg";
            break;
        case Calendar.FRIDAY:
            foodItem = "Chicken 65";
            foodImage = "image/chicken65.webp";
            break;
        case Calendar.SATURDAY:
            foodItem = "Boiled Egg";
            foodImage = "image/boiledegg.jpg";
            break;
        case Calendar.SUNDAY:
            foodItem = "Bread Omelet";
            foodImage = "image/breadomlet.jpg";
            break;
        default:
            foodItem = "Delicious Meal";
            foodImage = "image/Default.jpg";
            break;
    }

    request.setAttribute("foodItem", foodItem);
    request.setAttribute("foodImage", foodImage);
%>

<div class="container">
  <h1><%= foodItem %></h1>
  <img src="<%= foodImage %>" alt="<%= foodItem %>">
  <p>Do you want to book a token for this delicious meal?</p>
  
  <form action="bookToken" method="get">
    <input type="hidden" name="foodItem" value="<%= foodItem %>">
    <button type="submit" class="button">🍴 Yes, Book Now!</button>
    <button type="button" class="button secondary" onclick="window.history.back();">❌ No, Go Back</button>
  </form>

  <div class="message">
    <% 
        String food = (String) request.getAttribute("foodItem");
        String bookingMessage = (String) request.getAttribute("bookingMessage");
        if (bookingMessage != null && !bookingMessage.trim().isEmpty()) { 
            out.println(bookingMessage); 
        } else if (food != null) {
            out.println("Today's meal is: " + food);
        } 
    %>
  </div>
</div>

</body>
</html>
