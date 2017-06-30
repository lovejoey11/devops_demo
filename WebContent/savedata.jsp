<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="UserService" class="com.demo.service.UserService" />
<jsp:useBean id="user" class="com.demo.model.User" />
<jsp:setProperty property="*" name="user"/>
<%	
	int id = Integer.parseInt(request.getParameter("id"));
	int result = 0;
	result = UserService.editUser(user, id);
	if (result ==1){
		response.sendRedirect("success_op.jsp");	
	}else{
		response.sendRedirect("error.jsp");
	}
%>
<!-- 
<p>id = <%= id %> </p>
<p>First name = <%= user.getFirstname() %>
<p>Last name = <%= user.getLastname() %>
<p>User group= <%= user.getUsergroup() %>
<p>Password= <%= user.getPasswd() %>
<p>result = <%= result %>
-->
</body>
</html>