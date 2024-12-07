<%-- 
    Document   : login
    Created on : Nov 12, 2024, 8:11:31 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <<link rel="stylesheet" href="logcss.css"/>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <title>Log in</title>
    </head>
    <body>
        <form action="loginservlet" method="post">
        <div class="input-box">
                <input type="text"  class="input-user " name ="Username" placeholder="Username">
                <i class="bx bxs-user"></i>
            </div>

            <div class="input-box">
                <input type="password"  class="input-pass" name ="Password" placeholder="Password">
                <i class="bx bxs-lock-alt"></i>
            </div>
            
            <button type="submit" class="input-login">Log in</button>
             <div class="register">
                 New user?<a href="${pageContext.request.contextPath}/registerservlet">Register here</a>
              </div>
        </div>
        </form>
    </body>
</html>
