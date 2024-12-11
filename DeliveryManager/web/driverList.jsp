<%-- 
    Document   : driverList
    Created on : Dec 11, 2024, 7:30:22 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${empty list}">
            List NULL
        </c:if>
        <c:if test="${not empty list}">
        <table>
            <tr>
                <th>Driver id</th>
                <th>Driver name</th>
                <th>Status</th>
            </tr>    
            <c:forEach var="ten" items="${list}">
            <tr>
                <td>${driver_id}</td>
                <td>${name}</td>
                <td>${status}</td>
            </tr>
            </c:forEach>
        </table> 
        </c:if>   
    </body>
</html>
