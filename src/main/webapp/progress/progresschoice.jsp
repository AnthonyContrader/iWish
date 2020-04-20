<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="it.contrader.dto.ProgressDTO" import = "java.util.*"%>


<!DOCTYPE html>

<html lang = "en">
<head>
<meta charset="utf-8">
<meta name="viewport"
content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Progress Choice">
<meta name="author" content="Vittorio Valent">

<link href="../css/vittoriostyle.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<title>Timeline Choice</title>
</head>
<body>
 <%@ include file="../css/header.jsp" %>
   <div class="navbar">
     <a href="/homeadmin.jsp">Home</a> 
     <a href="/user/getall">Users</a>
     <a href="/wishlist/getall">WishLists</a>
     <a href="/portfolio/getall">Portafoglio</a>
     <a href="/prodotto/getall">Prodotti</a>
     <a class="active" href="/progress/getall">Progressi</a>
     <a  href="/category/getall">Categorie</a>
     <a href="/user/logout" id="logout">Logout</a>
     </div>
     <div class="row">
     <div class="col-sm-8">

   <%
            List<ProgressDTO> list = (List<ProgressDTO>) request.getSession().getAttribute("list");
   %>
   <br>
   
   <table>
   <tr>
                <th>Nome Prodotto</th>
                <th>Prezzo Prodotto&euro;</th>
                <th>Soldi&euro;</th>
				<th>Percentuale</th>
				<th>Giorni</th>
				<th></th>
				<th></th>
			</tr>
   
   <% 
   
      for (ProgressDTO p: list) {
   
   %> 
   
  
   <tr>
   <td><a href="/progress/read?id=<%=p.getId() %>"><%=p.getProdotto().getName() %>
   </a></td>
        <td><%=p.getProdotto().getPrice()%>Euro</td>
        <td><%=p.getCash()%>&euro;</td>
   		<td><%out.print(String.format("%.2f",p.getExpectation()));%>%</td>
		<td><%=p.getTime()%></td>
		
   
      <td><a href="/progress/preupdate?id=<%=p.getId()%>">Edit</a></td>


				<td><a href="/progress/delete?id=<%=p.getId()%>">Delete</a></td>
   
   
   
   
   </tr>
   <% 
   				}
   
   %>
  </table>
  </div>
  <div class="col-sm-4">
  <br>
  <h1 style ="background-color : rgb(0, 128, 255); color:white">Come vuoi fare il tuo calcolo?</h1>
  <a href="/progress/progressTimejsp.jsp"><button class = "btn btn-block" >Tempo </button></a>
  <a href="/progress/progressCash.jsp"><button class = "btn  btn-block">Soldi</button></a>
 </div>
  </div>

</body>
</html>