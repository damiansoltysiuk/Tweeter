<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 13.01.2020
  Time: 09:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
    <form action="addUser" method="post">
        <div>
            <input name="login" placeholder="Login" typeof="text" aria-required="true"/><br/>
        </div>

        <div>
            <input name="name" placeholder="Name" typeof="text" aria-required="true"/><br/>
        </div>

        <div>
            <input name="lastName" placeholder="Last name" typeof="text" aria-required="true"/><br/>
        </div>

        <div>
            <input name="email" placeholder="Email" typeof="text" aria-required="true"/><br/>
        </div>

        <div>
            <input name="password" placeholder="Password" typeof="password" aria-required="true"/><br/>
        </div>

        <div>
            <input name="repeatedPassword" placeholder="Repeat the password" typeof="password" aria-required="true"/><br/>
        </div>

        <button typeof="submit">Sign in</button>

    </form>
</body>
</html>
