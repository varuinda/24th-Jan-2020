<!DOCTYPE html>
<html>
<%if((String)session.getAttribute("name")!=null){
	response.sendRedirect("active.jsp")	;
}%>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<p>${message}</p>
<form method="post" action="LoginServlet">
Username: <input type="text" placeholder="Enter the username" name="username"><br>
Password: <input type="text" placeholder="Enter the password" name="password"><br>
<input type="submit" name="login" value="Login">
</form>
</body>
</html>