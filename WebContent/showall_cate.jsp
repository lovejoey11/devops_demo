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
<title>All Categories</title>
</head>
<body>
<div class="container">
<jsp:useBean id="categoryService" class="com.demo.service.CategoryService"></jsp:useBean>
<div class="alert alert-success" role="alert">
	<strong>Hello User. You are in dashboard</strong>
</div>
<table class="table thead-default table-striped table-hover">
<thead>
    <tr>
      <th>Category ID</th>
      <th>Category Name</th>
      <th>Category Description</th>
      <th>Action</th>
    </tr>
  </thead>
  <%
  	List<Category> list = categoryService.retriveAll();
  	for (Category cate: list){
  %>
  		<tr>
  			<td><%= cate.getCategoryID() %></td>
  			<td><%= cate.getCategoryName() %></td>
  			<td><%= cate.getCategoryDescription() %></td>
  			<td>
  				<a href="edit.jsp?id=<%= cate.getCategoryID() %>"><img src="images/edit.png" /></a>
  				<a href="delete.jsp?id=<%= cate.getCategoryID() %>"><img src="images/delete.png" /> </a>
  			</td>
  		</tr>
  <%
  	}
  %>
</table>
<a href="index.html" class="btn btn-primary btn-md" role="botton">Home</a>
<!--  TODO add register_cate.html -->
<a href="register_cate.html"><button type="button" class="btn btn-primary btn-md">Add Category</button></a>
</div>
</body>
</html>