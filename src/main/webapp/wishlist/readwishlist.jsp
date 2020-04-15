<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.WishListDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read WishList</title>
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
<br>
<div class="main">
<%
WishListDTO w = (WishListDTO) request.getSession().getAttribute("dto");
%>

<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Description</th>
</tr>
<tr>
<td><%=w.getId() %></td>
<td><%=w.getName() %></td>
<td><%=w.getDescription() %></td>
</tr>
</table>
<br> <br> <br> <br> <br> <br> <br>
<br> <br> <br> <br> <br> <br> <br>
</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>