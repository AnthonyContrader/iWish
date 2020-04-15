<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.WishListDTO" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>WishList Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
<a href="/homeadmin.jsp">Home</a> 
<a href="/user/getall">Users</a>
<a class="active" href="/wishlist/getall">WishLists</a>
<a href="/portfolio/getall">Portfolio</a>
<a href="/prodotto/getall">Prodotti</a>
<a href="/progress/getall">Progressi</a>
<a href="/category/getall">Categorie</a>
<a href="/user/logout" id="logout">Logout</a>
</div>

<div class="main">
<%
List<WishListDTO> list = (List<WishListDTO>) request.getSession().getAttribute("list");
%>
<br>
<table>
<tr>
<th>Name</th>
<th>Description</th>
<th></th>
<th></th>
</tr>
<%
for(WishListDTO w: list){
%>
<tr>
<td><a href="/wishlist/read?id=<%=w.getId()%>"><%=w.getName()%></a></td>
<td><%=w.getDescription()%></td>
<td><a href="/wishlist/preupdate?id=<%=w.getId()%>">Edit</a></td>
<td><a href="/wishlist/delete?id=<%=w.getId()%>">Delete</a></td>
</tr>
<%} %>
</table>

<form id="floatright" action="/wishlist/insert" method="post">
<div class="row">
<div class="col-25">
<label for="name">Name</label>
</div>
<div class="col-75">
<input type="text" id="name" name="name" placeholder="Inserisci il nome" required>
</div>
</div>
<div class="row">
<div class="col-25">
<label for="description">Description</label>
</div>
<div class="col-75">
<input type="text" id="description" name="description" placeholder="Inserisci la descrizione">
</div>
</div>
<button type ="submit" >Insert</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>