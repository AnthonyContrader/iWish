<%@ page import="it.contrader.dto.ProdottoDTO" import="java.util.*" import="it.contrader.dto.UserDTO"
import="it.contrader.dto.CategoryDTO" import="it.contrader.dto.WishListDTO"%>
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
     <a href="/portfolio/getall">Portafoglio</a>
     <a class="active" href="/prodotto/getall">Prodotti</a>
     <a href="/progress/getall">Progressi</a>
     <a  href="/category/getall">Categorie</a>
     <a href="/user/logout" id="logout">Logout</a>
     </div>
	<div class="main">
	<%
		UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
		List<ProdottoDTO> list = (List<ProdottoDTO>) request.getSession().getAttribute("list");
		List<WishListDTO> listawishlist = (List<WishListDTO>) request.getSession().getAttribute("wishlists");
		List<CategoryDTO> listaCategorie = (List<CategoryDTO>) request.getSession().getAttribute("category_list");
	%>
	
	<br>
	
	<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Priority</th>
			<th>WishList</th>
			<th>Category</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (ProdottoDTO p : list) {
			
				if(p.getProprietario().equals(userDTO)){	
		%>
		<tr>
			<td><a href="/prodotto/read?id=<%=p.getId() %>"> <%=p.getName()%></a></td>
			<td><%=p.getDescription()%></td>
			<td><%=p.getPrice()%> &euro;</td>
			<td><%=p.getPriority()%></td>
			<td><%
			if (p.getWishlist() != null){
				out.print(p.getWishlist().getName());}%></td>
			<td>
			<%
			if (p.getCategory() != null){
			out.print(p.getCategory().getName());}
			%>
			</td>
			<td><a href="/prodotto/preupdate?id=<%=p.getId()%>">Edit</a></td>
			<td><a href="/prodotto/delete?id=<%=p.getId()%>">Delete</a></td>
			
		</tr>
		<%
			}}
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
		<div class="row">
    <div class="col-25">
      <label for="category">Categoria</label>
    </div>
   		 <div class="col-75">
 			<select id="category" name="category">
 				<%
 				for (CategoryDTO c:listaCategorie) 
 					
 					{
 					if (c.getProprietario_c().equals(userDTO))
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
 					if (w.getProprietario().equals(userDTO))
 							{
 								out.print(String.format("<option value= '%d'>", w.getId()) + w.getName() + "</option>");
 							}
 				    }
 				%>
 				  				
  				<option value="">vuoto</option>
  					
			</select>
    	</div>
  </div>
		<button type="submit">Insert</button>
		</form>
		
	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>		
</body>
</html>