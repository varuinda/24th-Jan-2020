<!DOCTYPE html>
<html>
<%if((String)session.getAttribute("name")!=null){
	response.sendRedirect("active.jsp")	;
}%>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
</head>
<body>
<p>${message}</p>
<form method="post" action="CreateServlet">
Name: <input type="text" placeholder="Enter your name" name="name"><br>
Username: <input type="text" placeholder="Enter a username" name="username"><br>
Password: <input type="text" placeholder="Enter a password" name="password"><br>
Date of birth: <input type="date" name="date"><br>
<input type="submit" value="Create account" name = "create">
</form>
</body>
</html>