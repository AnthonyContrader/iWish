<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.ProdottoDTO"
    import="it.contrader.dto.CategoryDTO"
    import="it.contrader.dto.WishListDTO"
    import="it.contrader.dto.UserDTO"%>
    
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
	<a  href="UserServlet?mode=userlist">Users</a>
	 <a href="WishListServlet?mode=wishlists">Wishlist</a>
	 <a href="PortfolioServlet?mode=portfoliolist">Portafoglio</a>
	<a class="active" href="ProdottoServlet?mode=prodottolist">Prodotto</a>
	 <a href="ProgressServlet?mode=progresslist">Timeline</a>
	 <a href="CategoryServlet?mode=categorylist">Categorie</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		UserDTO userDTO = (UserDTO)request.getSession(false).getAttribute("user");
		List<ProdottoDTO> list = (List<ProdottoDTO>) request.getAttribute("list");
		List<CategoryDTO> listaCategorie = (List<CategoryDTO>) request.getAttribute("listaCategorie");
		List<WishListDTO> listawishlist = (List<WishListDTO>) request.getAttribute("listaWishlists");
	%>	
	
<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Priority</th>
			<th>Proprietario</th>
			<th>Categoria</th>
			<th>Wishlist</th>
			<th></th>
			<th></th>
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
			<td><%=u.getProprietario() %></td>
			<td><%
				
					for (CategoryDTO c: listaCategorie) 
					{
						if (c.getId() == u.getId_categoria_fk())
						{
							out.print(c.getName());
							break;
						} 
					}
			
				%></td>
			<td><%
				
					for (WishListDTO w: listawishlist) 
					{
						if (w.getId() == u.getId_whishlist_fk())
						{
							out.print(w.getName());
							break;
						} 
					}
			
				%></td>
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
	  	<input type="text" id="name" name="name" placeholder="inserisci nome" required>
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
	<div class="row">
    <div class="col-25">
      <label for="category">Categoria</label>
    </div>
   		 <div class="col-75">
 			<select id="category" name="categoria">
 				<%
 				for (CategoryDTO c:listaCategorie) 
 					
 					{
 					if (c.getProprietario_c().equals(userDTO.getUsername()))
 							{
 								out.print(String.format("<option value= '%d'>", c.getId()) + c.getName() + "</option>");
 							}
 				    }
 				%>
 				
  				
  				<option value="">vuoto</option>
  					
			</select>
    	</div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="wishlists">Wishlist</label>
    </div>
   		 <div class="col-75">
 			<select id="wishlists" name="wishlist">
 				<%
 				for (WishListDTO w:listawishlist) 
 					
 					{
 					if (w.getProprietario().equals(userDTO.getUsername()))
 							{
 								out.print(String.format("<option value= '%d'>", w.getId()) + w.getName() + "</option>");
 							}
 				    }
 				%>
 				  				
  				<option value="">vuoto</option>
  					
			</select>
    	</div>
  </div>
  
	<button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>