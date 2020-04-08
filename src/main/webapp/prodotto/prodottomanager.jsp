<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.ProdottoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prodotto Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
	<a href="homeadmin.jsp">Home</a>
	<a class="active" href="ProdottoServlet?mode=prodottilist">Prodotti</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<ProdottoDTO> list = (List<ProdottoDTO>) request.getAttribute("list");
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
			for (ProdottoDTO u : list) {
		%>
		<tr>
			<td><a href=ProdottoServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getName()%>
			</a></td>
			<td><%=u.getDescription()%></td>
			<td><%=u.getPrice()%></td>
			<td><%=u.getPriority()%></td>
			<td><a href=ProdottoServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=ProdottoServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>
			
		</tr>
		<%
			}
		%>	
	</table>	



<form id="floatright" action="ProdottoServlet?mode=insert" method="post">
	<div class="row">
	  <div class="col-25">
		<label for="name">Name</label>
	  </div>
	  <div class="col-75">
	  	<input type="text" id="name" name="name" placeholder="inserisci nome">
	  </div>
	  </div>
	<div class="row">
	  <div class="col-25">
		<label for="description">Description</label>
	</div>
	  <div class="col-75">
	  	<input type="text" id="description" name="description" placeholder="inserisci descrizione">
	  </div>
	  </div>
	<div class="row">
	  <div class="col-25">
		<label for="price">Price</label>
	</div>
	  <div class="col-75">
	  	<input type="text" id="price" name="price" placeholder="inserisci prezzo">
	  </div>
	  </div>
	<div class="row">
	  <div class="col-25">
		<label for="priority">Priority</label>
	 </div>
	<div class="col-75">
	  	<input type="text" id="priority" name="priority" placeholder="inserisci priorità">
	</div>
	</div>
	<button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>