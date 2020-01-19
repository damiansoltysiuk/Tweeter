<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 19.01.2020
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = " java.util.* " %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Register page</title>

</head>
<body>
<div>
   <div>
       <strong>${error.message}</strong>
   </div>
</div>

<div>
    <form action="register" method="post" onsubmit="return checkPasswordIdentiti(this)">
        <input name="login" placeholder="Login" type="text" required> </br>
        <input name="email" placeholder="Email" type="email" required> </br>
        <input name="name" placeholder="First name" type="text" required> </br>
        <input name="lastName" placeholder="Surname" type="text" required> </br>
        <input name="password" placeholder="Password" type="password" required> </br>
        <input name="repeatedPassword" placeholder="Confirm password" type="password" required> </br>
        <div>
            <button type="submit">Sign up</button>

        </div>
    </form>
</div>
</body>

<script>
    function checkPasswordIdentiti(form) {
        console.log(form.password + form.repeatedPassword)
        if(form.password.value != form.repeatedPassword.value) {
            alert("Password are not equals");
            return false;
        }
        return true;
    }
</script>
</html>
