<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.WishListDTO" import="java.util.List" import="it.contrader.dto.ProdottoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read wish list</title>
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
<br>
<div class="main">
<%

WishListDTO w = (WishListDTO) request.getAttribute("dto");
List<ProdottoDTO> lista_prodotti = (List<ProdottoDTO>) request.getAttribute("prodotti");
%>


<table>
	<tr> 
		<th>Name</th>
		<th>Description</th>
		
	</tr>
	<tr>
		<td><%=w.getName()%></td>
		<td> <%=w.getDescription()%></td>
		
	</tr>	
</table>
<br>
<br>
</div>
<div class="main">
<h2>PRODOTTI IN QUESTA WISH LIST</h2>
<table>
<tr>
<th>Name</th>
<th>Description</th>
<th>Price</th>
<th>Priority</th>
</tr>
<%
for(ProdottoDTO p: lista_prodotti){
	if(p.getId_whishlist_fk()==w.getId()){
		out.println(String.format("<tr> <td>%s</td> <td>%s</td>  <td>%f</td> <td>%d</td> </tr>",p.getName(), p.getDescription(), p.getPrice(), p.getPriority()));
	}	
	
} 

%>
</table>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>