<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Main Page</title>
	<meta name="viewport" content="width-device-width, initial-scale=1"/>

   <link rel="stylesheet" href="./Style/Style.css">
   
</head>
<body>

   <!-- login form container  -->

    <div class="login-form-container">

        <i class="fas fa-times" id="form-close"></i>

        <form action="ULoginServlet" method=post>
            <h3>Login</h3>
            <input type="email" class="box" placeholder="enter your email" name=inemail required>
            <input type="password" class="box" placeholder="enter your password" name=inpassword required>
            
            <input type="submit" value="login now" class="btn">
            <input type="checkbox" name="" id="remember">
            <label for="remember">remember me</label>
            <p>Forget password? <a href="Forget.jsp">Click Here</a></p>
            <p>Don't have an account? <a href="Register.jsp">Register Account</a></p>
        </form>

    </div>

</body>
</html>