<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CategoryDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Category</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
    <a href="homeadmin.jsp">Home</a>
    <a class="active" href="CategoryServlet?mode=categorylist">Categories</a>
    <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class= "main">
<%CategoryDTO c = (CategoryDTO) request.getAttribute("dto");%>

<table>
   <tr>
      <th>Name</th>
      <th>Description</th>
      <th>Rating</th>
     
      </tr>
      <tr>
      <td><%=c.getName()%></td>
      <td><%=c.getDescription()%></td>
      <td><%=c.getRating()%></td>
     
      </tr>
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>