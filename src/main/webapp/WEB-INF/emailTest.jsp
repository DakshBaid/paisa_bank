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
</html>