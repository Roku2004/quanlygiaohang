<%-- 
    Document   : adminpage
    Created on : Nov 26, 2024, 8:10:38 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/admincreateorder.jsp">Create order</a>
        <a href="${pageContext.request.contextPath}/OrderListAdmin.jsp">Order List</a>
    </body>
</html>
