<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ProgressDTO" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Progress</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>


<div class ="navbar">
 <a href="homeadmin.jsp">Home</a>
 <a href="UserServlet?mode=userlist">Users</a>
  <a href="WishListServlet?mode=wishlists">Wishlists</a>
   <a href="PortfolioServlet?mode=portfoliolist">Portafogli</a>
 <a href="ProdottoServlet?mode=prodottolist">Prodotti</a>
  <a class="active" href="ProgressServlet?mode=progresslist">Timeline</a>
  <a href="CategoryServlet?mode=categorylist">Categorie</a>
 <a href="LogoutServlet" id="logout">Logout</a>
 </div>
 <br>
<div class="main">
<%ProgressDTO p=(ProgressDTO) request.getAttribute("dto"); %>

<table>
   <tr>
   <th>Id_prodotto</th>
   <th>Soldi</th>
   <th>Previsione</th>
   <th>Tempo</th>
   </tr>
   <tr>
   <td><%= p.getForeign_prodotto() %></td>  
   <td><%=p.getCash() %></td>
   <td><%=p.getExpectation() %></td>
   <td><%=p.getTime() %></td>
   </tr>
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
<%@include file="../css/footer.jsp" %>
</body>
</html>