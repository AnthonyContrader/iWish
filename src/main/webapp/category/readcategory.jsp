<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CategoryDTO"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Category</title>
</head>
<body>

<%@ include file="../css/header.jsp"%>
	<div class="navbar">
     <a href="/homeadmin.jsp">Home</a> 
     <a href="/user/getall">Users</a>
     <a href="/wishlist/getall">WishLists</a>
     <a href="/portfolio/getall">Portfolio</a>
     <a href="/prodotto/getall">Prodotti</a>
     <a href="/progress/getall">Progressi</a>
     <a class="active" href="/category/getall">Categorie</a>
     <a href="/user/logout" id="logout">Logout</a>
     </div>
	<br>

	<div class="main">
	
	<%
	
	  CategoryDTO c = (CategoryDTO) request.getSession().getAttribute("dto");
	
	%>

<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Rating</th>
			</tr>
			<tr>
				<td><%=c.getId()%></td>
				<td><%=c.getName()%></td>
				<td><%=c.getDescription()%></td>
				<td><%=c.getRating()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

    	<%@ include file="../css/footer.jsp"%>
</body>
</html>