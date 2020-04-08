<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PortfolioDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Portfolio</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="PortfolioServlet?mode=portfoliolist">PortfolioList</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%PortfolioDTO u = (PortfolioDTO) request.getAttribute("dto");%>


<form id="floatleft" action="PortfolioServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="portfolio">Totalmoney</label>
    </div>
    <div class="col-75">
      <input type="text" id="portfolio" name="totalmoney" value=<%=u.getTotalmoney()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="rev">Revenue</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="rev" name="revenue" value=<%=u.getRevenue()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Outputs</label>
    </div>
   		 <div class="col-75">
 			
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	

</body>
</html>