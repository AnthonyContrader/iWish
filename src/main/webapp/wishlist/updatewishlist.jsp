<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.WishListDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Wish List</title>
</head>
<body>
<%@include file="../css/header.jsp"%>
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
<%WishListDTO w = (WishListDTO) request.getAttribute("dto"); %>

<form id="floatleft" action="WishListServlet?mode=update&id=<%=w.getId()%>" method="post">

<div class="row">
<div class="col-25">
<label for="wishlist">Name</label>
</div>
<div class="col-75">
<input type="text" id="wishlist" name="name" value="<%=w.getName()%>" required>
</div>
</div>

<div class="row">
<div class="col-25">
<label for="w_description">Description</label>
</div>
<div class="col-75">
<input type="text" id="w_description" name="description" value="<%=w.getDescription()%>">
</div>
</div>
<button type="submit">Edit</button>
</form>
</div>
<br>
<%@include file="../css/footer.jsp" %>
</body>
</html>