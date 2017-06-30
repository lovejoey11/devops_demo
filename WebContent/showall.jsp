<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.demo.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<title>All users</title>
</head>
<body>
<div class="container">
<jsp:useBean id="userService" class="com.demo.service.UserService"></jsp:useBean>
<div class="alert alert-success" role="alert">
	<strong>Hello Admin. You are in dashboard</strong>
</div>
<table class="table thead-default table-striped table-hover">
<thead>
    <tr>
      <th>#</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Username</th>
      <th>Usergroup</th>
      <th>Password</th>
      <th>Action</th>
    </tr>
  </thead>
  <%
  	List<User> list = userService.retriveAll();
  	for (User user: list){
  %>
  		<tr>
  			<td><input type="checkbox" value="<%= user.getId() %>" /></td>
  			<td><%= user.getFirstname() %></td>
  			<td><%= user.getLastname() %></td>
  			<td><%= user.getUsername() %></td>
  			<td><%= user.getUsergroup() %></td>
  			<td><%= user.getPasswd() %></td>
  			<td>
  				<a href="edit.jsp?id=<%= user.getId() %>"><img src="images/edit.png" /></a>
  				<a href="delete.jsp?id=<%= user.getId() %>"><img src="images/delete.png" /> </a>
  			</td>
  		</tr>
  <%
  	}
  %>
</table>
<a href="index.html" class="btn btn-primary btn-md" role="botton">Home</a>
<a href="register.html"><button type="button" class="btn btn-primary btn-md">Add user</button></a>
</div>
</body>
</html>