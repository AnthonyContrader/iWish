<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ProdottoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Prodotto</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
	<a href="homeadmin.jsp">Home</a>
	<a class="active" href="UserServlet?mode=userlist">Users</a>
 	<a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ProdottoDTO u = (ProdottoDTO) request.getAttribute("dto"); %>

<form id="floatleft" action="ProdottoServlet?mode=update&id=<%=u.getId()%>" method="post">
	<div class="row">
	<div class="col-25">
	<label for="name">Name</label>
	</div>
	<div class="col-75">
		<input type="text" id="prodotto" name="name" value=<%=u.getName()%>>
	</div>
	</div>
   <div class="row">
   	<div class="col-25">
   	<label for="description">Description</label>
   	</div>
   	<div class="col-75">
   	<input
   			type="text" id="description" name="description" value=<%=u.getDescription()%>>
	</div>
   </div>
   <div class="row">
   <div class="col-25">
	<label for="price">Price</label>
	</div>
   <div class="col-75">
   	<input
   			type="text" id="price" name="price" value=<%=u.getPrice()%>>
	</div>
	</div>
   <div class="row">
   <div class="col-25">
	<label for="priority">Priority</label>
	</div>
   <div class="col-75">
   	<input
   			type="text" id="priority" name="priority" value=<%=u.getPriority()%>>
	</div>
	</div>
 
   	<button type="submit" >Edit</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>