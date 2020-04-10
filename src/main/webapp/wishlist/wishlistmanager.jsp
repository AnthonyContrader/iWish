<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.WishListDTO" import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wishlist manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="WishListServlet?mode=wishlists">Wishlists</a>
  <a href="PortfolioServlet?mode=portfoliolist">Portafoglio</a>
  <a href="ProdottoServlet?mode=prodottolist">Prodotti</a>
  <a href="ProgressServlet?mode=progresslist">Timeline</a>
  <a href="CategoryServlet?mode=categorylist">Categorie</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class = "main">
<%
   UserDTO userDTO = (UserDTO)request.getSession(false).getAttribute("user");
   List<WishListDTO> list = (List<WishListDTO>) request.getAttribute("list");
%>
<br>
   <table>
   <tr>
   <th>Name</th>
   <th>Description</th>
   <th>Proprietario</th>
   <th></th>
   <th></th>
   </tr>
   <%
   for(WishListDTO w:list){
	   String proprietario = w.getProprietario();
	   //if(proprietario.equals(userDTO.getUsername())){
   %>
   <tr>
   <td><a href=WishListServlet?mode=read&id=<%=w.getId()%> ><%=w.getName() %></a></td>
   <td><%=w.getDescription()%></td>
   <td><%=proprietario%></td>
   <%if(proprietario.equals(userDTO.getUsername())){ %>
   <td><a href=WishListServlet?mode=read&update=true&id=<%=w.getId()%>>Edit</a></td>
   <td><a href=WishListServlet?mode=delete&id=<%=w.getId()%>>Delete</a></td>
   <%} %>
   </tr>
   <%}//} %>
   </table>
   
   <form id="floatright" action="WishListServlet?mode=insert" method="post">
   <div class="row">
   <div class="col-25">
   <label for="wishlist">Name</label>
   </div>
   <div class="col-75">
   <input type="text" id="wishlist" name="name" placeholder="inserisci nome" required>
   </div>
   </div>
   <div class="row">
   <div class="col-25">
   <label for="w_description">Description</label>
   </div>
   <div class="col-75">
   <input type="text" id="w_description" name="description" placeholder="inserisci descrizione">
   </div>
   </div>
   <button type="submit">Insert</button>
   </form>
</div>
<br>
<%@include file="../css/footer.jsp" %>

</body>
</html>