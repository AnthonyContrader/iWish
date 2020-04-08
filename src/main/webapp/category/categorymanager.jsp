<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.CategoryDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Category Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="CategoryServlet?mode=categorylist">Categories</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<CategoryDTO> list = (List<CategoryDTO>) request.getAttribute("list");
	%>

<br>

<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Date</th>
			<th>Rating</th>
			<th>Tags</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (CategoryDTO c : list) {
		%>
		<tr>
			<td><a href=CategoryServlet?mode=read&id=<%=c.getId()%>>
					<%=c.getName()%>
			</a></td>
			<td><%=c.getDescription()%></td>
			<td><%=c.getDate()%></td>
			<td><%=c.getRating()%></td>
			<td><%=c.getTags()%></td>
			<td><a href=CategoryServlet?mode=read&update=true&id=<%=c.getId()%>>Edit</a>
			</td>
			<td><a href=CategoryServlet?mode=delete&id=<%=c.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>

<form id="floatright" action="CategoryServlet?mode=insert" method="post">
  <div class="row">
  <div class="col-25">
   <label for="category">name</label>
   </div>
    <div class="col-75">
      <input type="text" id="category" name="name" placeholder= "Inserisci nome categoria">
    </div>
    </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Description</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="desc" name="description" placeholder="inserisci descrizione"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Date</label>
    </div>
   	  <div class="col-75">
   	    <input
			type="text" id="date" name="date" placeholder="inserisci data"> 
    </div>
    </div>
    <div class="row">
    <div class="col-25">
     <label for="pass">Rating</label>
    </div>
    <div class="col-75">
      <input
			type="number" id="rate" name="rating" placeholder="inserisci valutazione"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Tags</label>
    </div>
   	  <div class="col-75">
   	    <input
			type="text" id="tags" name="tags" placeholder="inserisci etichette"> 
    </div>
    </div>
    <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>
   