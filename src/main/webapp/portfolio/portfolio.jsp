<%@ page import="it.contrader.dto.PortfolioDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Portfolio Management">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Portfolio Manager</title>

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
			List<PortfolioDTO> list = (List<PortfolioDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Totalmoney</th>
				<th>Revenue</th>
				<th>Outputs</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (PortfolioDTO u : list) {
			%>
			<tr>
				<td><a href="/user/read?id=<%=u.getId()%>"> <%=u.getTotalmoney()%>
				</a></td>
				<td><%=u.getRevenue()%></td>
				<td><%=u.getOutputs()%></td>
				<td><a href="/portfolio/preupdate?id=<%=u.getId()%>">Edit</a></td>


				<td><a href="/portfolio/delete?id=<%=u.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/portfolio/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Saldo</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="totalmoney"
						placeholder="inserisci saldo">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Entrate</label>
				</div>
				<div class="col-75">
					<input type="text" id="pass" name="revenue"
						placeholder="inserisci entrate">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Uscite</label>
				</div>
				<div class="col-75">
				<input type="text" id="pass" name="outputs"
						placeholder="inserisci uscite">
					
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>