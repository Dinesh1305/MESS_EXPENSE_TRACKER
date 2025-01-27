package MANAGEMENT;

import javax.mail.*;
import javax.mail.internet.*;



import java.util.Properties;
import java.util.Random;



public class otp {
    private String generatedOtp;
    
   
    static String EMAIL_USERNAME = "hakihackers@gmail.com";
    static  String EMAIL_PASSWORD = "dxfe plxy dwkv cbwj";

   
    public void  run(String e) {
      
        String email =e;
      
   // System.out.println("hi");
        sendEmail(email);

     
    }


    private void sendEmail(String to) {
      
    	//System.out.print(otp);
        try {
            InternetAddress emailAddr = new InternetAddress(to);
            emailAddr.validate(); 
        } catch (AddressException ex) {
            System.err.println("Invalid email address: " + ex.getMessage());
            return;
        }

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
           
            message.setText("Contract successful !! ");

            Transport.send(message);
       //     System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }

    
}