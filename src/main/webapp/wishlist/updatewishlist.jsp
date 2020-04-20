<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.WishListDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Update WishList</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
<a href="/homeadmin.jsp">Home</a> 
<a href="/user/getall">Users</a>
<a class="active" href="/wishlist/getall">WishLists</a>
<a href="/portfolio/getall">Portafoglio</a>
<a href="/prodotto/getall">Prodotti</a>
<a href="/progress/getall">Progressi</a>
<a href="/category/getall">Categorie</a>
<a href="/user/logout" id="logout">Logout</a>
</div>
<div class="main">
<%WishListDTO w = (WishListDTO) request.getSession().getAttribute("dto");%>

<form id="floatleft" action="/wishlist/update" method="post">
<div class="row">
<div class="col-25">
<label for="name">Name</label>
</div>
<div class="col-75">
<input type="text" id="name" name="name" value="<%=w.getName()%>">
</div>
</div>
<div class="row">
<div class="col-25">
<label for="description">Description</label>
</div>
<div class="col-75">
<input type="text" id="description" name="description" value="<%=w.getDescription() %>">
</div>
<input type="hidden" name="id" value=<%=w.getId()%>>
</div>
<button type="submit">Edit</button>
</form> 
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>