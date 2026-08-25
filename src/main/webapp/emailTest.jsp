<%@ page import="com.paisabank.util.EmailUtil" %>

<html>
<head>
    <title>Email Test</title>
</head>
<body>

<%
    EmailUtil emailUtil = new EmailUtil();

    String result = emailUtil.sendOTP("dakshbaid9168@gmail.com@gmail.com");

    out.println("<h2>Result: " + result + "</h2>");
%>

</body>
</html><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>