<!DOCTYPE html>
<%if((String)session.getAttribute("name")!=null){
	response.sendRedirect("active.jsp")	;
}%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<p>${message}</p>
Choose any option
<form method="post" action="IndexServlet">
<input type="submit" value="Create Account" name="create"><br>
<input type="submit" value="Login" name="login"><br>
</form>
</body>
</html>