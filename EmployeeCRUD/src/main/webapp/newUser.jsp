<%@page import="com.coforge.training.employeecrud.UserDAO"%>
<%@page import="com.coforge.training.employeecrud.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Employee</title>
</head>
<body>
<jsp:useBean id="u" class="com.coforge.training.employeecrud.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
 
<%
    int i=UserDAO.save(u);
    if(i>0)
    {
        response.sendRedirect("addUserSuccess.jsp");
    }
    else {response.sendRedirect("addUserError.jsp");}
%>
</body>
</html>