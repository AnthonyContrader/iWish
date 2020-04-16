<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ProgressDTO "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=devide-width,initial-scale=1,
skrink-to-fit=no">
<meta name="description" content="Progress read">
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
     <a href="/portfolio/getall">Portfolio</a>
     <a href="/prodotto/getall">Prodotti</a>
     <a class="active" href="/progress/getall">Progressi</a>
     <a  href="/category/getall">Categorie</a>
     <a href="/user/logout" id="logout">Logout</a>
     </div>
<br>

<div class="main">

<% ProgressDTO p= (ProgressDTO) request.getSession().getAttribute("dto");
%>

<table>
<tr>
<th>Cash</th>
<th>Expectation</th>
<th>Time</th>
</tr>
<tr>
<td><%=p.getCash()%></td>
<td><%=p.getExpectation()%></td>
<td><%=p.getTime()%></td>
</tr>
</table>

        <br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>

</div>
<%@include file="../css/footer.jsp" %>
</body>

</html>