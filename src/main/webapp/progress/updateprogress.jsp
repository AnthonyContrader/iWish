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
<div class="navbar">
	<a href="homeadmin.jsp">Home</a>
	<a class="active" href="UserServlet?mode=userList">Users</a>
	<a href="LogoutServlet" id="logout">Logout</a>
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
  <input type="number" step=0.01 id="cash" name="cash" value="<%=p.getCash() %>"required>
  </div>
  </div>
  <div class="raw">
  <div class="col-25">
  <label for="expectation"> Previsione </label> 
  </div>
  <div class="col-75">
  <input type="number"step=0.00001 id="expectation" name ="expectation" value="<%=p.getExpectation()%>"required>
  </div>
  </div>
<div class="raw">
<div class="col-25">
<label for="time">Tempo</label>
</div>
<div class="col-75">
<input type="number"  step=0.00001 id="time" name ="time" value="<%=p.getTime() %>"required>

</div>

</div>

<button type="submit">Edit</button>
</form> 
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>