<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	margin-left: 200px;
	margin-top: 100px;
	font-style: italic;
	font-weight: bold;
}

h3, p {
	color: maroon;
}
</style>
</head>
<body>

	<h3>
		<%
			out.println(request.getAttribute("message").toString());
		%>
		<br> <br>Profile
	</h3>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<p>Name: &nbsp; ${customer.firstname}  ${customer.lastname}</p>
	<p>Phone: &nbsp; ${customer.phone}</p>
	<p>Email: &nbsp; ${customer.email}</p>
	<p>Service Plan details</p>
	<p>Name: &nbsp;${customer.servicePlan.plan_name}</p>
	<p>Description: &nbsp;${customer.servicePlan.description}</p>
	<p>Start date: &nbsp;${customer.servicePlan.start_date}</p>
	<p>End date: &nbsp;${customer.servicePlan.end_date}</p>


</body>
</html>