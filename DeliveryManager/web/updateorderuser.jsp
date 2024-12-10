<%-- 
    Document   : updateorderuser
    Created on : Dec 9, 2024, 1:14:17 PM
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
        <form action="UpdateOrderUserservlet" method="post"><br>
            <input type="hidden" name="order_id" value="${Order.id}">
            Sender:<input type="text" name="sender"><br>
            Receiver:<input type="text" name="receiver"><br>
            Origin_address: <input type="text" name="origin_address"><br>
            Destination_address:<input type="text" name="destination_address"><br>
            Sender_phone:<input type="text" name="sender_phone"><br>
            Receiver_phone:<input type="text" name="receiver_phone"><br>
            Weight:<input type="text" name="weight"><br>
            <button type="submit">Submit</button>
    </body>
</html>
