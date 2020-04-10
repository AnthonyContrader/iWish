<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.UserDTO"
     import="it.contrader.dto.CategoryDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Category Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a  href="UserServlet?mode=userlist">Users</a>
  <a href="WishListServlet?mode=wishlists">Wishlists</a>
  <a href="PortfolioServlet?mode=portfoliolist">Portafoglio</a>
  <a href="ProdottoServlet?mode=prodottolist">Prodotto</a>
  <a href="ProgressServlet?mode=progresslist">Timeline</a>
  <a class="active" href="CategoryServlet?mode=categorylist">Categorie</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
	    UserDTO userDTO = (UserDTO)request.getSession(false).getAttribute("user");
		List<CategoryDTO> list = (List<CategoryDTO>) request.getAttribute("list");
	
	%>

<br>

<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Rating</th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		
		<%
			for (CategoryDTO c:list) {
				  String proprietario_c = c.getProprietario_c();
				if(proprietario_c.equals(userDTO.getUsername())){
		%>
		<tr>
			<td><a href=CategoryServlet?mode=read&id=<%=c.getId()%>>
					<%=c.getName()%>
			</a></td>
			<td><%=c.getDescription()%></td>
			<td><%=c.getRating()%></td>
			<td><a href=CategoryServlet?mode=read&update=true&id=<%=c.getId()%>>Edit</a>
			</td>
			<td><a href=CategoryServlet?mode=delete&id=<%=c.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}}
		%>
	</table>

<form id="floatright" action="CategoryServlet?mode=insert" method="post">
  <div class="row">
  <div class="col-25">
   <label for="category">name</label>
   </div>
    <div class="col-75">
      <input type="text" id="category" name="name" placeholder= "Inserisci nome categoria" required>
       </div>
    </div>
  <div class="row">
    <div class="col-25">
     <label for="c_description">Description</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="c_description" name="description" placeholder="inserisci descrizione"> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
     <label for="rate">Preferenza</label>
       </div>
   		 <div class="col-75">
 			<select id="type" name="rating">
  				<option value="0">0</option>
  				<option value="1">1</option>
  				<option value="2">2</option>
  				<option value="3">3</option>
  				<option value="4">4</option>
  				<option value="5">5</option>
 
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
   