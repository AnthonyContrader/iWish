<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CategoryDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Category</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="CategoryServlet?mode=categorylist">Categories</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%CategoryDTO c = (CategoryDTO) request.getAttribute("dto");%>

<form id="floatleft" action="CategoryServlet?mode=update&id=<%=c.getId()%>" method="post">
  <div class="row">
  <div class="col-25">
   <label for="category">name</label>
   </div>
    <div class="col-75">
      <input type="text" id="category" name="name" value=<%=c.getName()%>>
    </div>
    </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Description</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="desc" name="description" value=<%=c.getDescription()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Date</label>
    </div>
   	  <div class="col-75">
   	    <input
			type="text" id="date" name="date" value=<%=c.getDate()%>> 
    </div>
    </div>
    <div class="row">
    <div class="col-25">
     <label for="pass">Rating</label>
    </div>
    <div class="col-75">
      <input
			type="number" id="rate" name="rating" value=<%=c.getRating()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Tags</label>
    </div>
   	  <div class="col-75">
   	    <input
			type="text" id="tags" name="tags" value=<%=c.getTags()%>> 
    </div>
    </div>
 			   <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>

