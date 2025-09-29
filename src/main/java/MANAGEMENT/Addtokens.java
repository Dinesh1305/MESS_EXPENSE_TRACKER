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
    static String food = null;

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

        // Add modern CSS styling
        out.println("<style>"
                + "body { font-family: Arial, sans-serif; background:#f9f9f9; }"
                + ".msg { padding: 15px; margin: 20px auto; width: 60%; border-radius: 8px; "
                + "font-size: 16px; text-align: center; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }"
                + ".success { background: #e6ffed; color: #1e4620; border: 1px solid #b7e4c7; }"
                + ".error { background: #ffe6e6; color: #661919; border: 1px solid #f5c2c2; }"
                + ".warning { background: #fff7e6; color: #664d1a; border: 1px solid #ffe5b4; }"
                + "</style>");

        String userOtp = req.getParameter("otp");
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
            out.println("<div class='msg error'>Session expired. Please login again.</div>");
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
                out.println("<div class='msg error'>OTP not found. Please try again.</div>");
                return;
            }

            // Compare OTP
            if (String.valueOf(dbOtp).equals(userOtp)) {
                try (PreparedStatement ps = con.prepareStatement(deleteSql)) {
                    ps.setString(1, email);
                    int count = 1; // your logic unchanged

                    if (count == 1) {
                        out.println("<div class='msg success'>TOKEN ADDED SUCCESSFULLY</div>");

                        // Call Excel class (your implementation)
                        Excel e = new Excel();
                        e.add(food, email);

                    } else {
                        out.println("<div class='msg warning'>TOKEN CAN'T BE ADDED</div>");
                    }
                }
            } else {
                out.println("<div class='msg error'>Invalid OTP</div>");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            out.println("<div class='msg error'>Database error.</div>");
        }
    }
}

