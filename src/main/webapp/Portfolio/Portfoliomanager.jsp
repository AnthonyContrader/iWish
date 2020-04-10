<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.PortfolioDTO" import = "it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Portfolio Manager</title>
<link href="../css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
   <a href="UserServlet?mode=userlist">Users</a>
    <a href="WishListServlet?mode=wishlists">Wishlists</a>
  <a class="active" href="PortfolioServlet?mode=portfoliolist">Portafoglio</a>
  <a href="ProdottoServlet?mode=prodottolist">Prodotto</a>
   <a href="ProgressServlet?mode=progresslist">Timeline</a>
   <a href="CategoryServlet?mode=categorylist">Categorie</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
	    UserDTO userDTO = (UserDTO) request.getSession(false).getAttribute("user");
		List<PortfolioDTO> list = (List<PortfolioDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Totalmoney</th>
			<th>Revenue</th>
			<th>Outputs</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (PortfolioDTO u : list) {
				String proprietario = u.getProprietario();
		%>
		<tr>
			<td><a href=PortfolioServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getTotalmoney()%>
			</a></td>
			<td><%=u.getRevenue()%></td>
			<td><%=u.getOutputs()%></td>
			<td><%=proprietario%></td>
           <%if(proprietario.equals(userDTO.getUsername())){ %>
			
			<td><a href=PortfolioServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=PortfolioServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>
	

		</tr>
		<%
			}
			}
		%>
	</table>



<form id="floatright" action="PortfolioServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="portfolio">Saldo</label>
    </div>
    <div class="col-75">
      <input type="text" id="portfolio" name="totalmoney" placeholder="inserisci saldo totale">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Entrate</label>
    </div>
    <div class="col-75">
      <input type="text" id="rev" name="revenue" placeholder="inserisci entrate"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Uscite</label>
    </div>
   		 <div class="col-75">
   		  <input type="text" id="out" name="outputs" placeholder="inserisci uscite"> 
    
 			
 
			
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>

</body>
</html>