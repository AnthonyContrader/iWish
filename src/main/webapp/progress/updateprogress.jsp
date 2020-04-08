<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ProgressDTO"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title> Edit Progress</title>
</head>
<body>
<%@ include file="/css/header.jsp" %>
<div class="navebar">
	<a href="homeadmin.jsp">Home</a>
	<a class="active" href="UserServlet?mode=userList">Users</a>
	<a href="LogoutServlet" id="Logout">Logout</a>
</div>
<br>
<div class="main">

<%ProgressDTO p=(ProgressDTO) request.getAttribute("dto"); %>

<form id="floatleft" action="ProgressServlet?mode=update&id=<%=p.getId()%>" method="post">
<div class="row">
<div class="col-25">
  <label for="cash"> Soldi </label> 
  </div>
  <div class="col-75">
  <input type="number" id="cash" name="cash" value=<%=p.getCash() %>>
  </div>
  </div>
  <div class="raw">
  <div class="col-25">
  <label for="expectation"> Previsione </label> 
  </div>
  <div class="col-75">
  <input type="number" id="expectation" value=<%=p.getExpectation() %>>
  </div>
  </div>
<div class="raw">
<div class="col-25">
<label for="time">Tempo</label>
</div>
<div class="col-75">
<input type="number" id="time" value=<%=p.getTime() %>>
</div>

</div>

<button type="submit">Edit</button>
</form> 

<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>