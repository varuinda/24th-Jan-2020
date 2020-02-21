<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Home</title>
</head>
<body>
<%
if(session.getAttribute("sid")==null || request.getSession()==null){
	response.sendRedirect("index.jsp");
}%>
<form method="get" action="LoginActivityServlet">
<input type="submit" name="creditbalance" value="Credit Balance"><br>
<input type="submit" name="debitbalance" value="Debit Balance"><br>
<input type="submit" name="viewbalance" value="View balance"><br>
<input type="submit" name="fundtransfer" value="Fund Transfer"><br>
<input type="submit" name="viewtransactions" value="View all transactions"><br>
<input type="submit" name="logout" value="Log out"><br>
</form>
<p>${message1}</p>
</body>
</html>