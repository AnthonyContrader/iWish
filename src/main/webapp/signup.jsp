<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGNUP</title>
<!-- BOOTSTRAP -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"/>
<style type="text/css">
.signup{
position:fixed;
	height:50%;
	width:20%;
	margin-left:35.6%;
	margin-right:44.4%;
	margin-top:10%;
	margin-bottom:auto;
	z-index:1;
}
</style>
</head>
<body>
<div class="signup">
<form action="/user/signup" method="post">
<fieldset>
<legend>SIGN UP</legend>
<div class="form-group">
<label for="username">USERNAME</label>
<input type="text" class="form-control" name="username" id= "username" placeholder="Username" required>
</div>
<div class="form-group">
<label for="password">PASSWORD</label>
<input type="password" class="form-control" name="password" id="password" placeholder="Password" required>
</div>
<div class="form-group">
<button class="btn btn-primary btn-block" type="submit">SIGN UP</button>
</div>
</fieldset>
</form>
</div>
</body>
</html>