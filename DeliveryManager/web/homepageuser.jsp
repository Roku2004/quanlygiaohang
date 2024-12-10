<%-- 
    Document   : homepage
    Created on : Nov 26, 2024, 8:10:03 PM
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
        <a href="${pageContext.request.contextPath}/createorder.jsp">Create Order</a><br>
         <a href="${pageContext.request.contextPath}/OrderListUser.jsp">List Order</a>
    </body>
</html>
