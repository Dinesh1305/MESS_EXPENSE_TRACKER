package MANAGEMENT;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/verify")
public class Verification extends HttpServlet {
    protected void service(HttpServletRequest r, HttpServletResponse r1) throws IOException {
        String otp = r.getParameter("otp");
        String url = "jdbc:mysql://localhost:3306/mb";
        String name = "root";
        String password = "3105";
        boolean isVerified = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection(url, name, password);
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT ott FROM dailybill");
            
            while (rs.next()) {
                String dbOtp = rs.getString("ott");
                if (otp.equals(dbOtp)) {
                    isVerified = true;
                    
                    PreparedStatement ps=c.prepareStatement("delete  from dailybill where ott=?");
                    ps.setInt(1,Integer.parseInt(otp));
                    ps.executeUpdate();
                    break;
                }
            }

            rs.close();
            s.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // Prepare the response
        r1.setContentType("text/html");
        r1.setCharacterEncoding("UTF-8");

        // HTML and CSS for displaying OTP verification result
        r1.getWriter().write(
            "<!DOCTYPE html>" +
            "<html lang='en'>" +
            "<head>" +
            "    <meta charset='UTF-8'>" +
            "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
            "    <title>OTP Verification Result</title>" +
            "    <style>" +
            "        body { display: flex; justify-content: center; align-items: center; height: 100vh; }" +
            "        .container { padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); width: 300px; text-align: center; }" +
            "        .message { font-size: 18px; }" +
            "        .success { color: green; }" +
            "        .error { color: red; }" +
            "    </style>" +
            "</head>" +
            "<body>" +
            "    <div class='container'>");

        // Display the message based on verification result
        if (isVerified) {
            r1.getWriter().write(
                "        <div class='message success'>OTP verified successfully!</div>"
            );
        } else {
            r1.getWriter().write(
                "        <div class='message error'>Invalid OTP. Please try again.</div>"
            );
        }

        r1.getWriter().write(
            "    </div>" +
            "</body>" +
            "</html>"
        );
    }
}
