<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Your Token</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            height: 100vh;
            margin: 0;
        }

        .container {
            text-align: center;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        img {
            max-width: 100%;
            height: auto;
            border-radius: 10px;
            margin-bottom: 15px;
        }

        h1 {
            margin-bottom: 10px;
            color: #333;
        }

        p {
            color: #666;
            font-size: 16px;
            margin-bottom: 20px;
        }

        .button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin: 5px;
            transition: background-color 0.3s;
        }

        .button:hover {
            background-color: #45a049;
        }

        .message {
            color: #d9534f;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<%
    java.util.Calendar calendar = java.util.Calendar.getInstance();
    int dayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);
    
    String foodItem;
    String foodImage;

    switch (dayOfWeek) {
        case java.util.Calendar.TUESDAY:
            foodItem = "Chicken Briyani";
            foodImage = "image/brr.jpg";
            break;
        case java.util.Calendar.MONDAY:
            foodItem = "Egg Gravy";
            foodImage = "image/egggravy.jpg";
            break;
        case java.util.Calendar.WEDNESDAY:
            foodItem = "Chicken Gravy";
            foodImage = "image/chickengravy.jpg";
            break;
        case java.util.Calendar.THURSDAY:
            foodItem = "Cauliflower";
            foodImage = "image/cauliflower.jpeg";
            break;
        case java.util.Calendar.FRIDAY:
            foodItem = "Chicken 65";
            foodImage = "image/chicken65.webp";
            break;
        case java.util.Calendar.SATURDAY:
            foodItem = "Boiled Egg";
            foodImage = "image/boiledegg.jpg";
            break;
        case java.util.Calendar.SUNDAY:
            foodItem = "Bread Omlet";
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
        <button type="submit" class="button">Yes, Book Now!</button>
        <button type="button" class="button" onclick="window.history.back();">No, Go Back</button>
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
