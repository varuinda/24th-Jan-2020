<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
Welcome<br>
Name: <%String name = (String)session.getAttribute("name");
if(name==null){
	response.sendRedirect("loginacc.jsp");
}
else{
out.println(name);
}%><br>
Date of birth: <%String date = (String)session.getAttribute("dob"); 
out.println(date);%><br>
<form action="LogoutServlet" method="get">
<input type="submit" name="logout" value="Log Out">
</form>
</body>
</html>