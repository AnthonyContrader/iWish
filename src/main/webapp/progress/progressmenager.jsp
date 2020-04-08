<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.ProgressDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title> Progress Menager</title>
</head>

<body>
<%@ include file="../css/header.jsp" %>

<div class ="navbar">
 <a href="homeadmin.jsp">Home</a>
 <a href="UserServlet?mode=userlist">Users</a>
  <a href="WishListServlet?mode=wishlists">Wishlist</a>
   <a href="PortfolioServlet?mode=portfoliolist">Portafoglio</a>
 <a href="ProdottoServlet?mode=prodottolist">Prodotto</a>
  <a class="active" href="ProgressServlet?mode=progresslist">Timeline</a>
  <a href="CategoryServlet?mode=categorylist">Categorie</a>
 <a href="LogoutServlet" id="logout">Logout</a>
 </div>
 <div class="main">
 <%
 List<ProgressDTO> list= (List<ProgressDTO>) request.getAttribute("list");
 %>
 <br>
     <table>
     <tr>
     	<th>Soldi</th>
			<th>Progressi</th>
			<th>Tempo</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (ProgressDTO p : list) {
		%>
		<tr>
		<td><a href=ProgressServlet?mode=read&id=<%=p.getId()%>>
		<%=p.getCash() %>
		</a></td>
		<td><%=p.getExpectation()%></td>
		<td><%=p.getTime()%></td>
		<td><a href=ProgressServlet?mode=read&update=true&id=<%=p.getId()%>>Edit</a>
			</td>
			<td><a href=ProgressServlet?mode=delete&id=<%=p.getId()%>>Delete</a>
			</td>
		</tr>
	<%
		} 
	%>
</table>


<form id="floatright" action="ProgressServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="cash">Soldi</label>
    </div>
    <div class="col-75">
      <input type="number" id="cash" name="cash" placeholder="inserisci i Soldi">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="expectation">Progress</label>
    </div>
    <div class="col-75">
      <input type="number" id="expectation" name="expectation" placeholder="inserisci il Progresso">
    </div>
  </div>
   <div class="row">
    <div class="col-25">
      <label for="time">Tempo</label>
    </div>
    <div class="col-75">
      <input type="number" id="time" name="time" placeholder="inserisci il Tempo">
    </div>
  </div>
  <button type="submit">Insert</button>
</form>
 </div>
 <br>
 <%@ include file="../css/footer.jsp" %>
</body>
</html>