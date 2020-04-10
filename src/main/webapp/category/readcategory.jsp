<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CategoryDTO" 
    import= "java.util.List" import="it.contrader.dto.ProdottoDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Category</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="WishListServlet?mode=wishlists">Wishlists</a>
  <a href="PortfolioServlet?mode=portfoliolist">Portafoglio</a>
  <a href="ProdottoServlet?mode=prodottolist">Prodotti</a>
  <a href="ProgressServlet?mode=progresslist">Timeline</a>
  <a class="active" href="CategoryServlet?mode=categorylist">Categorie</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class= "main">

<%
CategoryDTO c = (CategoryDTO) request.getAttribute("dto");
 List<ProdottoDTO> prodotto_list = (List<ProdottoDTO>) request.getAttribute("prodotto_list");
 
%>


<table>
	
		<th><%=c.getName()%>
		&ensp;&ensp;&ensp;&ensp;
		    <%=c.getRating() %>
		</th>
		
<% for (ProdottoDTO p: prodotto_list ){
	if(p.getId_categoria_fk() == c.getId()){
	   out.println(String.format("<tr><td>%s</td></tr>", p.getName()));     }
} %>

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
			

<%@ include file="../css/footer.jsp" %>
</body>
</html>