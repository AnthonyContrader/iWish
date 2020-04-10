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
      <input type="text" id="category" name="name" value="<%=c.getName()%>" required>
    </div>
    </div>
    
  <div class="row">
    <div class="col-25">
     <label for="c_description">Description</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="c_description" name="description" value="<%=c.getDescription()%>"> 
    </div>
  </div>
     <div class="row">
    <div class="col-25">
     <label for="rate">Preferenza</label>
      </div>
       <div class="col-75">
 			<select id="type" name="rating">
  				<option value="0">0</option>
  				<option value="1">1</option>
  				<option value="2">2</option>
  				<option value="3">3</option>
  				<option value="4">4</option>
  				<option value="5">5</option>
 
			</select>
			</div>
		</div>
			     <button type="submit" >Edit</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>

