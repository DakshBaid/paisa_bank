package com.paisabank.util;

	import java.util.Properties;
	import java.util.Random;
	import javax.mail.Authenticator;
	import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.PasswordAuthentication;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;

	public class EmailUtil {

		private static String tempOTP;
		public static String generatedOTP() {
			Random random = new Random();
		    String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		    String otp ="";
		    for(int i=0;i<8;i++) {
		    	int index=random.nextInt(chars.length());
		    	otp+=chars.charAt(index);
		    }
		    tempOTP = String.valueOf(OTP);
		   return tempOTP;
		}
		
		public String sendPass(String recipientEmail, int acc_no) {

	        final String senderEmail = "paisabanktest@gmail.com"; 
	        final String senderPassword = ""; 

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

	            message.setSubject("Your Login Details");
	            
	            message.setText("Your Account Number is: "+acc_no+
	            		"\nYour Temporary OTP is: " + otp +
	                    "\nDo not share this OTP with anyone.");

	            Transport.send(message);

	            System.out.println("OTP sent successfully to " + recipientEmail);

	        } catch (MessagingException e) {
	            System.out.println("Failed to send OTP: " + e.getMessage());
	        }
	        return otp;
		} 
		public boolean verifyOTP(String userOTP) {
	        return tempOTP!= null && tempOTP.equals(userOTP);
		}
	}
