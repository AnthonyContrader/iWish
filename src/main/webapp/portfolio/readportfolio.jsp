<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PortfolioDTO"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Portfolio Read">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Portfolio</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<div class="navbar">
     <a href="/homeadmin.jsp">Home</a> 
     <a href="/user/getall">Users</a>
     <a href="/wishlist/getall">WishLists</a>
     <a class="active" href="/portfolio/getall">Portafoglio</a>
     <a href="/prodotto/getall">Prodotti</a>
     <a href="/progress/getall">Progressi</a>
     <a  href="/category/getall">Categorie</a>
     <a href="/user/logout" id="logout">Logout</a>
     </div>
<br>

	<div class="main">
		<%
			PortfolioDTO u = (PortfolioDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				
				<th>Totalmoney</th>
				<th>Revenue</th>
				<th>Outputs</th>
			</tr>
			<tr>
				
				<td><%=u.getTotalmoney()%></td>
				<td><%=u.getRevenue()%></td>
				<td><%=u.getOutputs()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>