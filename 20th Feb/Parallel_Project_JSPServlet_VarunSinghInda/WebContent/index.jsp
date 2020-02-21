<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<%String id = (String)session.getAttribute("sid");
if(id!=null){
	response.sendRedirect("loginactivity.jsp");
}%>
<form method="get" action="IndexServlet">
<input type="submit" name="addAccount" value="Add Account"><br>
<input type="submit" name="loginAccount" value="Login"><br>
<input type="submit" name="viewUsers" value="View All Users"><br>
<input type="submit" name="exit" value="Exit"><br>
</form>
<p>${message1}</p>
</body>
</html>