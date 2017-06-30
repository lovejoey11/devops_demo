<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>

<title>Edit</title>
</head>
<body>
<div class="container">
	<form method="post" action="savedata.jsp?id=<%= Integer.parseInt(request.getParameter("id"))%>">
		<div class="form-group row">
			<div class="col-xs-3">
				  <label for="fname">First Name:</label>
				  <input type="text" class="form-control" placeholder="First name" id="fname" name="firstname">
			</div>
		</div>
		<div class="form-group row">
			<div class="col-xs-3">
				<label for="lname">Last Name:</label>
			 	<input type="text" class="form-control" placeholder="Last name" id="lname" name="lastname">
			</div>
		</div>
		<div class="form-group row">
			<div class="col-xs-3">
				<label for="username">User name:</label>
			 	<input type="text" class="form-control" placeholder="Username" id="username" name="username">
			</div>
		</div>
		<div class="form-group row">
			<div class="col-xs-3">
				<label for="passwd">Password:</label>
			 	<input type="password" class="form-control" placeholder="Password" id="passwd" name="passwd">
			</div>
		</div>
		<select name="usergroup"> 
			<option value="User"> User </option>
			<option value="Admin"> Admin </option>
			<option value="Guest"> Guest </option>
		</select> <br><br>
		<input type="submit" class="btn btn-primary btn-md" value="Submit Edit" /> 
		<a href="index.html" class="btn btn-primary btn-md" role="botton">Home</a>
	</form>
</div>


</body>
</html>