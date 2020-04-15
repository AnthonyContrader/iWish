<%@ page import="it.contrader.dto.ProdottoDTO" import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Prodotti">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Prodotti</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>
	
	<div class="navbar">
     <a href="/homeadmin.jsp">Home</a> 
     <a href="/user/getall">Users</a>
     <a href="/wishlist/getall">WishLists</a>
     <a href="/portfolio/getall">Portfolio</a>
     <a class="active" href="/prodotto/getall">Prodotti</a>
     <a href="/progress/getall">Progressi</a>
     <a  href="/category/getall">Categorie</a>
     <a href="/user/logout" id="logout">Logout</a>
     </div>
	<div class="main">
	<%
		List<ProdottoDTO> list = (List<ProdottoDTO>) request.getSession().getAttribute("list");
	%>
	
	<br>
	
	<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Priority</th>
		</tr>
		<%
			for (ProdottoDTO p : list) {
		%>
		<tr>
			<td><a href="/prodotto/read?id=<%=p.getId() %>"> <%=p.getName()%></a></td>
			<td><%=p.getDescription()%></td>
			<td><%=p.getPrice()%></td>
			<td><%=p.getPriority()%></td>
			<td><a href="/prodotto/preupdate?id=<%=p.getId()%>">Edit</a></td>
			<td><a href="/prodotto/delete?id=<%=p.getId()%>">Delete</a></td>
			
		</tr>
		<%
			}
		%>	
	</table>		

	<form id="floatright" action="/prodotto/insert" method="post">
		<div class="row">
			<div class="col-25">
				<label for="prodotti">Prodotti</label>
			</div>
			<div class="col-75">
				<input type="text" id="prodotto" name="name"
					placeholder="inserisci nome">
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="description">Descrizione</label>
			</div>
			<div class="col-75">
				<input type="text" id="description" name="description"
					placeholder="inserisci descrizione">
			</div>
		</div>
			<div class="row">			
				<div class="col-25">
					<label for="price">Prezzo</label>
				</div>
			<div class="col-75">
				<input type="text" id="price" name="price"
					placeholder="inserisci prezzo">
			</div>
			</div>
			<div class="row">
			<div class="col-25">
				<label for="priority">Priorità</label>
			</div>
			<div class="col-75">
				<input type="text" id="priority" name="priority"
					placeholder="inserisci priorità">
			</div>
			
		</div>
		<button type="submit">Insert</button>
		</form>
		
	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>		

</body>
</html>