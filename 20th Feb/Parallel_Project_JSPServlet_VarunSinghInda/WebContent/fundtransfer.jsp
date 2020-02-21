<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fund Transfer</title>
</head>
<body>
<%String id = (String)session.getAttribute("sid");
if(id==null){
	response.sendRedirect("index.jsp");
}%>
<form method="get" action="FundTransferServlet">
ID of the receiver: <input type="text" placeholder="Unique ID" name="receiverid"><br>
Balance to transfer: <input type="text" placeholder="Transfer money" name="balancetransfer"><br>
<input type="submit" value="Transfer" name="transferbutton">
</form>
<p>${message1}</p>
</body>
</html>