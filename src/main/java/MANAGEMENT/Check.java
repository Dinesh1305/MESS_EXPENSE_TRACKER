package MANAGEMENT;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/add")
public class Check extends HttpServlet {
    
    public void service(HttpServletRequest r, HttpServletResponse r2) throws ServletException, IOException{
    	
         	
         PrintWriter out=r2.getWriter();
         	//out.println("jfjfjfj");
             
            try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
             String one = r.getParameter("email");
             String two = r.getParameter("password");
             String insert = "SELECT PASSWORD FROM details WHERE EMAIL = ?";
             Cookie c3=new Cookie("email",one);
             
             Cookie c1=new Cookie("password",two);
             r2.addCookie(c3);
             r2.addCookie(c1);
             
             
             String url = "jdbc:mysql://localhost:3306/mb";
             String name = "root";
             String password = "3105";
             Connection c;
			try {
				c = DriverManager.getConnection(url, name, password);
				 PreparedStatement ps = c.prepareStatement(insert);
	             ps.setString(1, one);

	             ResultSet rs = ps.executeQuery();
	             boolean message=false ;
	             String message1=" ";            // Verify the password
	             if (rs.next()) {
	                 String pass1 = rs.getString("password");
	                 if (pass1.equals(two)) {
	                 	
	                     message =true;
	                 } else {
	                     message = false;
	                 }
	             } else {
	                 message1 = "EMAIL NOT FOUND";
	             }

	            
	             r.setAttribute("message", message);
	             r.setAttribute("message1", message1);
	           
	             RequestDispatcher dispatcher = r.getRequestDispatcher("/index.jsp");
	             dispatcher.forward(r, r2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
             

         
     }
 }