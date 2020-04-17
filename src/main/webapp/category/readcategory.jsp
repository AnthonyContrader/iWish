<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CategoryDTO" import= "java.util.List"
    import="it.contrader.dto.ProdottoDTO"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Category</title>
</head>
<body>

<%@ include file="../css/header.jsp"%>
	<div class="navbar">
     <a href="/homeadmin.jsp">Home</a> 
     <a href="/user/getall">Users</a>
     <a href="/wishlist/getall">WishLists</a>
     <a href="/portfolio/getall">Portfolio</a>
     <a href="/prodotto/getall">Prodotti</a>
     <a href="/progress/getall">Progressi</a>
     <a class="active" href="/category/getall">Categorie</a>
     <a href="/user/logout" id="logout">Logout</a>
     </div>
	<br>

	<div class="main">
	
	<%
     
	  CategoryDTO c = (CategoryDTO) request.getSession().getAttribute("dto");
	List<ProdottoDTO> prodotto_list = (List<ProdottoDTO>) request.getSession().getAttribute("prodotto_list");

	 
	%>

<table>
			
				
				<th><%=c.getName()%></th>
			<tr>
		<%  
		for (ProdottoDTO p: prodotto_list ){
			if(p.getCategory().equals(c)){
			   out.println(String.format("<tr><td>%s</tr></td>", p.getName())); 
			   }}  %>	
 </tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>
      
	</div>

    	<%@ include file="../css/footer.jsp"%>
</body>
</html>