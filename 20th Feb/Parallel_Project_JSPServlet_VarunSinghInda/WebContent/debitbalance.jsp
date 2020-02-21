<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Debit Balance</title>
</head>
<body>
<%String id = (String)session.getAttribute("sid");
if(id==null){
	response.sendRedirect("index.jsp");
}%>
<form method="get" action="DebitBalanceServlet">
Enter the balance to debit: <input type="text" placeholder="Debit balance" name="debitholder"><br>
<input type="submit" value="Debit" name="debitbutton">

</form>
<p>${message1}</p>
</body>
</html>