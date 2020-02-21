<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<%String id = (String)session.getAttribute("sid");
if(id!=null){
	response.sendRedirect("loginactivity.jsp");
}%>
<form method="post" action="LoginAccountServlet">
Unique ID: <input type="text" placeholder="Enter your unique ID" name="uniqueid"><br>
Password: <input type="text" placeholder="Enter your password" name="password"><br>
<input type="submit" value="Login" name="loginaccount">
</form>
<p>${message1}</p>
</body>
</html>