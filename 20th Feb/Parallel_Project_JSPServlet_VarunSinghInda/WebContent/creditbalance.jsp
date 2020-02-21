<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Credit Balance</title>
</head>
<body>
<%String id = (String)session.getAttribute("sid");
if(id==null){
	response.sendRedirect("index.jsp");
}%>
<form method="get" action="CreditBalanceServlet">
Enter the balance to credit: <input type="text" placeholder="Add balance" name="creditholder"><br>
<input type="submit" value="Credit" name="creditbutton">

</form>
<p>${message1}</p>
</body>
</html>