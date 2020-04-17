
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Sample Login page">
<meta name="author" content="Vittorio Valent">

<title>Login</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"/>
<style type="text/css">
.login{
position:relative;
	height:50%;
	width:20%;
	margin-left:35.6%;
	margin-right:44.4%;
	margin-top:10%;
	margin-bottom:auto;
	z-index:1;
}
</style>


<!-- Custom styles for this template -->

</head>


<body>
	<div class = "login">
	<form action="/user/login" method="post">
		<fieldset>
		<legend>LOGIN</legend>
		<div class="form-group">
<label for="username">USERNAME</label>
<input type="text" class="form-control" name="username" id= "username" placeholder="Username" required>
</div>
<div class="form-group">
<label for="password">PASSWORD</label>
<input type="password" class="form-control" name="password" id="password" placeholder="Password" required>
</div>
<div class="form-group">
<button class="btn btn-primary btn-block" type="submit">LOGIN</button>

</div>
</fieldset>
	</form>
	
	<a href="/user/presignup"><button class = "btn btn-primary btn-block">SIGN UP</button></a>
	</div>
	
</body>
</html>