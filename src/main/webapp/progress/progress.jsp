<%@ page import="it.contrader.dto.ProgressDTO" import = "java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Progress Managment">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">

<title>Timeline</title>
</head>
<body>
   
   <%@ include file="../css/header.jsp" %>
   <div class="navbar">
     <a href="/homeadmin.jsp">Home</a> 
     <a href="/user/getall">Users</a>
     <a href="/wishlist/getall">WishLists</a>
     <a href="/portfolio/getall">Portfolio</a>
     <a href="/prodotto/getall">Prodotti</a>
     <a class="active" href="/progress/getall">Progressi</a>
     <a  href="/category/getall">Categorie</a>
     <a href="/user/logout" id="logout">Logout</a>
     </div>
   <div class="main">
   <%
            List<ProgressDTO> list = (List<ProgressDTO>) request.getSession().getAttribute("list");
   %>
   <br>
   
   <table>
   <tr>
                <th>Prodotto</th>
                <th>Cash</th>
				<th>Expectation</th>
				<th>Time</th>
				<th></th>
				<th></th>
			</tr>
   
   <% 
   
      for (ProgressDTO p: list) {
   
   %> 
   
  
   <tr>
   <td><a href="/progress/read?id=<%=p.getId() %>"><%=p.getProdotto().getName() %>
   </a></td>
        <td><%=p.getCash()%></td>
   		<td><%=p.getExpectation()%></td>
		<td><%=p.getTime()%></td>
		
   
      <td><a href="/progress/preupdate?id=<%=p.getId()%>">Edit</a></td>


				<td><a href="/progress/delete?id=<%=p.getId()%>">Delete</a></td>
   
   
   
   
   </tr>
   <% 
   				}
   
   %>
  </table>
  
  
   <form id="floatright" action="/progress/insert" method="post">
			
			<div class="row">
				<div class="col-25">
					<label for="prodotto_id">id Prodotto</label>
				</div>
				<div class="col-75">
					<input type="number" id="prodotto_id" name="prodotto_id"
						placeholder="inserisci id del Prodotto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="cash">Cash</label>
				</div>
				<div class="col-75">
					<input type="number" id="cash" name="cash"
						placeholder="inserisci Cash">
				</div>
		<div class="row">
				<div class="col-25">
					<label for="expectation">Expectation</label>
				</div>
				<div class="col-75">
					<input type="number" id="expectation" name="expectation"
						placeholder="inserisci Expectation">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="time">Time</label>
				</div>
				<div class="col-75">
					<input type="number" id="time" name="time"
						placeholder="inserisci Time">
				</div>
			</div>
				</div>
			
			<button type="submit">Insert</button>
		</form>
   
   
   
   </div>
  
    <br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>