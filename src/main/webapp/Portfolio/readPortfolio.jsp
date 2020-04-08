<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PortfolioDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Portfolio</title>
</head>
<body>

<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="PortfolioServlet?mode=portfoliolist">PortfolioList</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%PortfolioDTO u = (PortfolioDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Totalmoney</th>
		<th>Revenue</th>
		<th>Outputs</th>
	</tr>
	<tr>
		<td><%=u.getTotalmoney()%></td>
		<td> <%=u.getRevenue()%></td>
		<td> <%=u.getOutputs()%></td>
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

<%@ include file="../css/footer.jsp" %>

</body>
</html>