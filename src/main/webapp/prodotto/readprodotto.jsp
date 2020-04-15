<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ProdottoDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Prodotto Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">	
<title>Read Prodotto</title>
</head>
<body>
	<%@ include file="./css.header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a>
		<a href="/user.jsp">Users</a>
		<a href="/wishlists.jsp">Wishlists</a>
		<a href="/portfolio.jsp">Portafoglio</a>
		<a class="active" href="/prodotto/gettall"> Prodotti</a>
		<a href="/progress.jsp">Timeline</a>
		<a href="/categorie.jsp">Categorie</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>
	
	<div class="main">
	<%
		ProdottoDTO p = (ProdottoDTO) request.getSession().getAttribute("dto");
	%>
	
	<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Priority</th>
		</tr>
		<tr>
				<td><%=p.getId()%></td>
				<td><%=p.getName()%></td>
				<td><%=p.getDescription()%></td>
				<td><%=p.getPrice()%></td>
				<td><%=p.getPriority()%></td>
		</tr>
	</table>
	
	<br> <br> <br> <br> <br> <br> <br>
	<br> <br> <br> <br> <br> <br> <br>
	
	</div>
	
	<%@ include file="./css/footer.jsp"%>

</body>
</html>