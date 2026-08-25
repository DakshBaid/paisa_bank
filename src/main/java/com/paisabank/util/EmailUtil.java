package com.paisabank.util;

	import java.util.Properties;
	import java.util.Random;
	import jakarta.mail.Message;
	import jakarta.mail.MessagingException;
	import jakarta.mail.PasswordAuthentication;
	import jakarta.mail.Session;
	import jakarta.mail.Transport;
	import jakarta.mail.internet.InternetAddress;
	import jakarta.mail.internet.MimeMessage;

	public class EmailUtil {

		private static String tempOTP;
		public String generatedOTP() {
			Random random = new Random();
		    String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		    String otp ="";
		    for(int i=0;i<6;i++) {
		    	int index=random.nextInt(chars.length());
		    	otp+=chars.charAt(index);
		    }
		    tempOTP = String.valueOf(otp);
		   return tempOTP;
		}
		
		public String sendOTP(String recipientEmail) {

	        final String senderEmail = "paisabanktest@gmail.com"; 
	        final String senderPassword =System.getenv("PAISA_BANK_EMAIL_PASSWORD"); 

	        String otp = generatedOTP();

	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");

	        Session session = Session.getInstance(props,
	                new Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                    	return new PasswordAuthentication(senderEmail, senderPassword);
	                    }
	                });

	        try {
	            Message message = new MimeMessage(session);

	            message.setFrom(new InternetAddress(senderEmail));

	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse(recipientEmail)
	            );

	            message.setSubject("Paisa Bank - Email Verification\\r\\n\"");
	            
	            message.setText("Your OTP is: "+otp+"\r\n"
	            		+ "\r\n"
	            		+ "This OTP is valid for 5 minutes.\r\n"
	            		+ "Do not share this OTP with anyone.");

	            Transport.send(message);

	            System.out.println("OTP sent successfully to " + recipientEmail);

	        } catch (Exception e) {
	            System.out.println("Failed to send OTP: " + e.getMessage());
	        }
	        return otp;
		} 
		public boolean verifyOTP(String userOTP) {
	        return tempOTP!= null && tempOTP.equals(userOTP);
		}
	}
