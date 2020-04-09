<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ProdottoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Prodotto</title>
</head>
<body>
<%@ include file="../css/header.jsp"  %>
<div class="navbar">
	<a href="homeadmin.jsp">Home</a>
	<a class="active" href="ProdottoServlet?mode=prodottilist">Prodotto</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%ProdottoDTO u = (ProdottoDTO) request.getAttribute("dto"); %>


<table>
	<tr>
		<th>Nome</th>
		<th>Descrizione</th>
		<th>Prezzo</th>
		<th>Priorità</th>
	</tr>
	<tr>
		<td><%=u.getName()%></td>
		<td><%=u.getDescription()%></td>
		<td><%=u.getPrice()%></td>
		<td><%=u.getPriority()%></td>
	</tr>			
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>