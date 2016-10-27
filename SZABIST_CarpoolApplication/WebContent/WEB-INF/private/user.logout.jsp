<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>
This is Logout
<%System.out.println("SEESION VALUE IN LOGOUT JSP :"+request.getSession()); %>
<%-- <%if(session != null){
	session.invalidate();
	request.getRequestDispatcher("/WEB-INF/public/login.jsp?success_msg=You+have+Successuly+logged+out").forward(request, response); 
} 
else{
	System.out.println("SESSION IS NOT Invalidate");
}%> --%>

<%-- <% session.invalidate(); %>
<%System.out.println("SESSION VALUE :"+request.getSession()); %> --%>


</body>
</html>