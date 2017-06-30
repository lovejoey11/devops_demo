<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Demo Site</title>

</head>
<body>
	<div class="container">
		<jsp:useBean id="UserService" class="com.demo.service.LoginService" />
		
		<%
			String uname = request.getParameter("username");
			String pword = request.getParameter("password");
			
			
			boolean flag = UserService.login(uname,pword);
			if(!flag){
				response.sendRedirect("error.jsp");
			}else{
				if (uname.equals("admin")){
					response.sendRedirect("showall.jsp");
				}else{
				response.sendRedirect("success-login.jsp");}
			}
			
		%>


	</div>
</body>
</html>