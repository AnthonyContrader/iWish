<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ProdottoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Update Prodotto</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
     <a href="/homeadmin.jsp">Home</a> 
     <a href="/user/getall">Users</a>
     <a href="/wishlist/getall">WishLists</a>
     <a href="/portfolio/getall">Portfolio</a>
     <a class="active" href="/prodotto/getall">Prodotti</a>
     <a href="/progress/getall">Progressi</a>
     <a  href="/category/getall">Categorie</a>
     <a href="/user/logout" id="logout">Logout</a>
     </div>
<br>
<div class="main">

<%ProdottoDTO p = (ProdottoDTO) request.getSession().getAttribute("dto");%>

<form id="floatleft" action="/prodotto/update" method="post">
	<div class="row">
		<div class="col-25">
			<label for="user">Name</label>
		</div>
		<div class="col-75">
			<input type="text" id="prodotto" name="name" value=<%=p.getName()%>>
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="user">Description</label>
		</div>
		<div class="col-75">
			<input type="text" id="description" name="description" value=<%=p.getDescription()%>>
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="user">Price</label>
		</div>
		<div class="col-75">
			<input type="text" id="price" name="price" value=<%=p.getPrice()%>>
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="user">Priority</label>
		</div>
		<div class="col-75">
			<input type="text" id="priority" name="priority" value=<%=p.getPriority()%>>
		</div>
	<input type="hidden" name="id" value="<%=p.getId()%>">
	</div>
	 <button type="submit" >Edit</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp"%>
</body>
</html>