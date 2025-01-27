package MANAGEMENT;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin123")
public class admin_side extends HttpServlet {
    public void service(HttpServletRequest r, HttpServletResponse r1) throws IOException {
   String email=r.getParameter("email");
   String password=r.getParameter("password");
   if(email.equals("admin@123gmail.com") && password.equals("admin123"))
   {
	   r1.sendRedirect("/MESS_MANAGEMENT/otp.jsp");
   } 
   
   
    }
}
