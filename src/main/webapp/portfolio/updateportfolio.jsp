<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PortfolioDTO"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Portfolio</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
     <a href="/homeadmin.jsp">Home</a> 
     <a href="/user/getall">Users</a>
     <a href="/wishlist/getall">WishLists</a>
     <a class="active" href="/portfolio/getall">Portfolio</a>
     <a href="/prodotto/getall">Prodotti</a>
     <a href="/progress/getall">Progressi</a>
     <a  href="/category/getall">Categorie</a>
     <a href="/user/logout" id="logout">Logout</a>
     </div>
<br>
<div class="main">

<%PortfolioDTO u = (PortfolioDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/portfolio/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="portfolio">Totalmoney</label>
    </div>
    <div class="col-75">
      <input type="text" id="portfolio" name="totalmoney" value="<%=u.getTotalmoney()%>"required>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="rev">Revenue</label>
    </div>
    <div class="col-75">
      <input
			type="time" id="rev" name="revenue" value=<%=u.getRevenue()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="out">Outputs</label>
    </div>
   		 <div class="col-75">
   		<input
			type="text" id="out" name="outputs" value=<%=u.getOutputs()%>>
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>