<%@ page language="java" %>
<%@ page import="com.paisabank.model.User" %>
<%@ page import="com.paisabank.dao.UserDAO" %>
<%String status = request.getParameter("status");
String message="";
if(status == null) {
    status = "";
}else if(status.equals("success")){
	message="Registration Success";
}else if(status.equals("fail")){
	message="Registration Failed";
}
%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>PAISA BANK - Create Account</title>

    <link rel="stylesheet" href="css/forms.css">

</head>
<%
	if (request.getMethod().equals("POST")) {
		String fullName=request.getParameter("fullName");
	if(fullName==null || fullName.trim().isEmpty()){
		out.println("Invalid Name");
		status="fail";
	}
	String email=request.getParameter("email");
	if(email==null || email.trim().isEmpty() || !email.endsWith("@gmail.com")){
		out.println("Invalid Email");
		status="fail";
	}
	String mobile=request.getParameter("mobile");
	if(mobile==null || mobile.trim().isEmpty()){
		out.println("Invalid Mobile");
		status="fail";	
	}
	String password=request.getParameter("password");	
	if(password==null || password.trim().isEmpty()){
		out.println("Invalid Password");
		status="fail";
	}
    if (!status.equals("fail")) {
	User user=new User();
	user.setFullName(fullName);
	user.setEmail(email);
	user.setMobile(mobile);
	user.setPassword(password);
	    UserDAO userOb=new UserDAO();
    	boolean check=userOb.registerUser(user);
    	if(check==true){
    		response.sendRedirect("signup.jsp?status=success");
    		return;
    	}else{
    	    response.sendRedirect("signup.jsp?status=fail");
    		return;
    	}
    }else{
    	out.println("Please enter your details correctly");
    }
	//response.sendRedirect("signup.jsp");
	}
%>
<body>

    <div class="signup-container">

        <div class="signup-card">

            <div class="brand">
                PAISA BANK
            </div>

            <h1>Create Account</h1>

            <p class="subtitle">
                Open your Paisa Bank account
            </p>
			<% if (!message.equals("")) { %>

			    <div class="message">
        			<%= message %>
    			</div>

			<% } %>
			<form method="post">

                <div class="form-group">
                    <label>Full Name</label>
                    <input type="text"
                           name="fullName" 
                           placeholder="Enter your full name">
                </div>

                <div class="form-group">
                    <label>Email</label>
                    <input type="email"
                           name="email" 
                           placeholder="Enter your email">
                </div>

                <div class="form-group">
                    <label>Mobile Number</label>
                    <input type="text"
                           name="mobile" 
                           placeholder="Enter your mobile number">
                </div>

                <div class="form-group">
                    <label>Password</label>
                    <input type="password"
                           name="password" 
                           placeholder="Create a password">
                </div>

                <button type="submit" >
                    Create Account
                </button>

            </form>

            <p class="login-link">
                Already have an account?
                <a href="login.jsp">Login</a>
            </p>

        </div>

    </div>

</body>
</html>