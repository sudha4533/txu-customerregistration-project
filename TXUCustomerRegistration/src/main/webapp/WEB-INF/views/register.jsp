<!DOCTYPE html>
<html lang="en">
<head>
<title>Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>


	<div class="container" style="width: 500px">

		<br>
		<h1 style="color: maroon;">TXU Energy</h1>
		<h3>
			<%
				out.println(request.getAttribute("message").toString());
			%>
		</h3>
		<h4 style="color: maroon;">All fields are mandatory</h4>
		<form role="form" method="POST" action="customer/add">
			<div class="form-group">
				<label for="firstname">First name</label> <input type="text"
					class="form-control" name="firstname"
					placeholder="Enter first name">
			</div>
			<div class="form-group">
				<label for="lastname">Last name</label> <input type="text"
					class="form-control" name="lastname" placeholder="Enter last name">
			</div>
			<div class="form-group">
				<label for="phone">Phone</label> <input type="text"
					class="form-control" name="phone" placeholder="Enter phone">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" name="email" placeholder="Enter email">
			</div>
			<button type="submit" class="btn btn-default">Register</button>
		</form>
	</div>
</body>
</html>