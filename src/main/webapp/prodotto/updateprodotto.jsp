<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ProdottoDTO"
    import="it.contrader.dto.ProdottoDTO"
    import="it.contrader.dto.CategoryDTO"
    import="it.contrader.dto.WishListDTO"
    import="it.contrader.dto.UserDTO"
    import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Prodotto</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
	<a href="homeadmin.jsp">Home</a>
	<a  href="UserServlet?mode=userlist">Users</a>
	 <a href="WishListServlet?mode=wishlists">Wishlists</a>
	 <a href="PortfolioServlet?mode=portfoliolist">Portafoglio</a>
	<a class="active" href="ProdottoServlet?mode=prodottolist">Prodotti</a>
	 <a href="ProgressServlet?mode=progresslist">Timeline</a>
	 <a href="CategoryServlet?mode=categorylist">Categorie</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">
	<%
		UserDTO userDTO = (UserDTO)request.getSession(false).getAttribute("user");
		List<CategoryDTO> listaCategorie = (List<CategoryDTO>) request.getAttribute("listaCategorie");
		List<WishListDTO> listawishlist = (List<WishListDTO>) request.getAttribute("listaWishlists");
		ProdottoDTO u = (ProdottoDTO) request.getAttribute("dto");
	%>	

<form id="floatleft" action="ProdottoServlet?mode=update&id=<%=u.getId()%>" method="post">
	<div class="row">
	<div class="col-25">
	<label for="name">Name</label>
	</div>
	<div class="col-75">
		<input type="text" id="prodotto" name="name" value=<%=u.getName()%>>
	</div>
	</div>
   <div class="row">
   	<div class="col-25">
   	<label for="description">Description</label>
   	</div>
   	<div class="col-75">
   	<input
   			type="text" id="description" name="description" value=<%=u.getDescription()%>>
	</div>
   </div>
   <div class="row">
   <div class="col-25">
	<label for="price">Price</label>
	</div>
   <div class="col-75">
   	<input
   			type="text" id="price" name="price" value=<%=u.getPrice()%>>
	</div>
	</div>
   <div class="row">
   <div class="col-25">
	<label for="priority">Priority</label>
	</div>
   <div class="col-75">
   	<input
   			type="text" id="priority" name="priority" value=<%=u.getPriority()%>>
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
 								if (c.getId() == u.getId_categoria_fk())
 								{
 									out.print(String.format("<option value= '%d'autofocus>", c.getId()) + c.getName() + "</option>");
 								} else 
 									{out.print(String.format("<option value= '%d'>", c.getId()) + c.getName() + "</option>");}
 							}
 				    }
 				%>
 				
  				
  				<option value="">nessuna-categoria</option>
  					
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
 								if (w.getId() == u.getId_categoria_fk())
								{
									out.print(String.format("<option value= '%d'autofocus>", w.getId()) + w.getName() + "</option>");
								} else 
									{out.print(String.format("<option value= '%d'>", w.getId()) + w.getName() + "</option>");}
								}}
 				    %>
 				  				
  				<option value="">nessuna-whishlist</option>
  					
			</select>
    	</div>
  </div>
   	<button type="submit" >Edit</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>