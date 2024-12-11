<%-- 
    Document   : OrderListUser
    Created on : Dec 8, 2024, 3:53:20 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Order</title>
    </head>
    <body>
        <form action="searchorderuserservlet" method="GET">
            <label for="id">Nhập ID:</label>
            <input type="text" id="id" name="id" required>
            <button type="submit">Search</button>
        </form>
        <c:if test="${empty list}">
            List NULL
        </c:if>
        <c:if test="${not empty list}">
        <table>
            <tr>
                <th>Bill of lading no</th>
                <th>Sender</th>
                <th>Receiver</th>
                <th>Origin_address</th>
                <th>Destination_address</th>
                <th>Sender_phone</th>
                <th>Receiver_phone</th>
                <th>Status</th>
                <th>Weight</th>
                <th>Total_cost</th>
                <th>Payment status</th>
            </tr>    
            <c:forEach var="ten" items="${list}">
            <tr>
                <td>${ten.order_id}</td>
                <td>${ten.sender}</td>
                <td>${ten.receiver}</td>
                <td>${ten.originAddress}</td>
                <td>${ten.destinationAddress}</td>
                <td>${ten.sender_phone}</td>
                <td>${ten.receiver_phone}</td>
                <td>${ten.status}</td>
                <td>${ten.weight}</td>
                <td>${ten.total_cost}</td>
                <td>${ten.payment_status}</td>
            </tr>
            </c:forEach>
        </table> 
        </c:if>     
    </body>
</html>
