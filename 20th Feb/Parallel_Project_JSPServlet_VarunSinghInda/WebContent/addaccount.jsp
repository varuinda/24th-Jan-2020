<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
</head>
<body>
<%String id = (String)session.getAttribute("sid");
if(id!=null){
	response.sendRedirect("loginactivity.jsp");
}%>
<form method="post" action="AddAccountServlet">
Name: <input type="text" placeholder="Enter your name" name="name"><br>
Password: <input type="text" placeholder="Enter your password" name="password"><br>
Unique ID: <input type="text" placeholder="Enter your unique ID" name="uniqueid"><br>
Starting Balance: <input type="text" placeholder="Enter your starting balance" name="startingbalance"><br>
<input type="submit" value="Create Account" name="createaccount">
</form>
<p>${message1}</p>
</body>
</html>