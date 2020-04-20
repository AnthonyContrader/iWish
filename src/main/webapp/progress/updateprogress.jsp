<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="it.contrader.dto.ProgressDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
content="tidth=devide-width, initial-scale=1, shrink-to-fit=no">
<meta name= "description" content="Progress Edit page">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">

<title>Timeline</title>
</head>
<body>
 <%@ include file="../css/header.jsp" %>
   <div class="navbar">
     <a href="/homeadmin.jsp">Home</a> 
     <a href="/user/getall">Users</a>
     <a href="/wishlist/getall">WishLists</a>
     <a href="/portfolio/getall">Portafoglio</a>
     <a href="/prodotto/getall">Prodotti</a>
     <a class="active" href="/progress/getall">Progressi</a>
     <a  href="/category/getall">Categorie</a>
     <a href="/user/logout" id="logout">Logout</a>
     </div>
   <br>
   
   <div class="main">
   <%ProgressDTO p =(ProgressDTO) request.getSession().getAttribute("dto"); %>
   
   <form id="floatleft" action="/progress/update" method="post">
 <!--  <div class="row">
    <div class="col-25">
      <label for="cash">Soldi&euro;</label>
    </div>
    <div class="col-75">
      <input type="number" id="cash" name="cash" value=
    </div>
    </div>
    -->
    <div class="row">
    <div class="col-25">
      <label for="time">Tempo</label>
    </div>
    <div class="col-75">
      <input type="number" id="time" name="time" value=<%=p.getTime()%>>
    </div>
    <input type="hidden" name="id" value =<%=p.getId() %>>
    </div>
    <button type="submit" >Edit</button>
</form>
   
   
   
   
   
   </div>
   <br>
   <%@ include file="../css/footer.jsp" %>	
   
</body>
</html>