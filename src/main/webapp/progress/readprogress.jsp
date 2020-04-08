<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ProgressDTO" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Progress</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navebar">
	<a href="homeadmin.jsp">Home</a>
	<a class="active" href="ProgressServlet?mode=progresslist">Progress</a>
    <a href="LogoutServlet" id ="Logout">Logout</a>
</div>
<br>

<div class="main">
<%ProgressDTO p=(ProgressDTO) request.getAttribute("dto"); %>

<table>
   <tr>
   <th>Soldi</th>
   <th>Previsione</th>
   <th>Tempo</th>
   </tr>
   <tr>
   <td><%=p.getCash() %></td>
   <td><%=p.getExpectation() %></td>
   <td><%=p.getTime() %></td>
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
<br>
<br>
<br>

</div>
<%@include file="../css/footer.jsp" %>
</body>
</html>