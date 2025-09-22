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
	static String food=null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        food = req.getParameter("foodItem");
        String email = null;

        // Get email from cookies
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie temp : cookies) {
                if ("email".equals(temp.getName())) {
                    email = temp.getValue();
                    break;
                }
            }
        }

        if (email != null) {
            try {
                otp otpGen = new otp();
                otpGen.run(email);  // Generate OTP and store in DB
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        // Redirect to OTP entry page
        resp.sendRedirect("/MESS_MANAGEMENT/Stundent_otp.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String userOtp = req.getParameter("otp");
     //   String food = req.getParameter("foodItem");
        String email = null;

        // Get email from cookies
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie temp : cookies) {
                if ("email".equals(temp.getName())) {
                    email = temp.getValue();
                    break;
                }
            }
        }

        if (email == null) {
            out.println("<div style='color:red;'>Session expired. Please login again.</div>");
            return;
        }

        String url = "jdbc:mysql://localhost:3306/mb";
        String dbUser = "root";
        String dbPass = "3105";

        try (Connection con = DriverManager.getConnection(url, dbUser, dbPass)) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Fetch OTP from DB
            String selectSql = "SELECT ott FROM dailybill WHERE email=?";
            String deleteSql = "DELETE FROM dailybill WHERE email=?";

            int dbOtp = -1;
            try (PreparedStatement ps = con.prepareStatement(selectSql)) {
                ps.setString(1, email);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        dbOtp = rs.getInt("ott");
                    }
                }
            }

            if (dbOtp == -1) {
                out.println("<div style='color:red;'>OTP not found. Please try again.</div>");
                return;
            }

            // Compare OTP
            if (String.valueOf(dbOtp).equals(userOtp)) {
                try (PreparedStatement ps = con.prepareStatement(deleteSql)) {
                    ps.setString(1, email);
                    int count = ps.executeUpdate();

                    if (count == 1) {
                        out.println("<div style='color:green;'>TOKEN ADDED SUCCESSFULLY</div>");

                        // Call Excel class (your implementation)
                        Excel e = new Excel();
                        e.add(food, email);

                    } else {
                        out.println("<div style='color:red;'>TOKEN CAN'T BE ADDED</div>");
                    }
                }
            } else {
                out.println("<div style='color:red;'>Invalid OTP</div>");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            out.println("<div style='color:red;'>Database error.</div>");
        }
    }
}
