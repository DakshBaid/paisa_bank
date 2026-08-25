<%@ page import="com.paisabank.util.EmailUtil" %>

<%
    EmailUtil emailUtil = new EmailUtil();

    String result = emailUtil.sendOTP("dakshbaid9168@gmail.com");

    System.out.println("Result: " + result);
%>