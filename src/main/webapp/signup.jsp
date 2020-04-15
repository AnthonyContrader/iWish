<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGNUP</title>
</head>
<body>
<!-- AGGIUNGERE BOOTSTRAP -->
<form action="/user/signup" method="post">
<label for="username">USERNAME</label>
<input type="text" name="username" id= "username" placeholder="Username" required>
<label for="password">PASSWORD</label>
<input type="password" name="password" id="password" placeholder="Password" required>
<button type="submit">SIGN UP</button>
</form>
</body>
</html>