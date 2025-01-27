package MANAGEMENT;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/bookToken")
public class Addtokens extends HttpServlet {
	static String email=null;
static int otp2 = 0;
static String food=null;

static String email1=null;
	protected void doGet(HttpServletRequest r,HttpServletResponse r1) throws IOException
	{
		Cookie []c=r.getCookies();
		//System.out.println(r.getParameter("foodItem"));
	//	Cookie add=new Cookie("food",r.getParameter("foodItem"));
		food=r.getParameter("foodItem");
		otp otp1=new otp();
		for(Cookie temp:c)
		{
			if(temp.getName().equals("email"))
			{
				email=temp.getValue();
				
			// otp2 = otp1.run(email);
				//System.out.println(otp2);
				
				
				
				
			}
			if(temp.getName().equals("email"))
			{
				email1=temp.getValue();
			}
		}
		r1.sendRedirect("/MESS_MANAGEMENT/Stundent_otp.jsp");
	}
		
	protected void doPost(HttpServletRequest r,HttpServletResponse r1) throws IOException
	{
		
		
		PrintWriter out=r1.getWriter();
		String User_otp=r.getParameter("otp");
		 String url = "jdbc:mysql://localhost:3306/mb";
         String name = "root";
         String password = "3105";
         try {
        	 
        	 
        	 Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, name, password);
			String insert="insert into dailybill() values(?,?,?)";
			 PreparedStatement ps = con.prepareStatement(insert);
			 ps.setString(1,email);
		     ps.setInt(2,1);
		     
		     String h=String.valueOf(otp2);
		    
		     ps.setInt(3, otp2);
		     if(h.equals(User_otp))
		     {
		    	 try {
		    		int count=ps.executeUpdate();	
		    		if(count==1)
		    		{
		    			 out.println("<div style='color: green;'>TOKEN ADDED SUCCESSFULLY</div>");
		    			 
		    		Excel e=new Excel();
		    		e.add(food,email1);
		    		
		    		}
		    		else
		    		{
		    			out.println("<div style='color: red;'>TOKEN CAN'T BE ADDED</div>");
		    		}
		    		
		    	 }catch(Exception hhh)
		    	 {
		    		 System.out.println(hhh.getMessage());
		    		 out.println("<div style='color: red;'>Error occurred while adding token.</div>"); 
		    	 }
		     }
		     else
		     {
		    	
		            out.println("<div style='color: red;'>Invalid OTP</div>");

		     }
		    
		
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 out.println("<div style='color: red;'>Database error.</div>");
	       
		}
	}

}