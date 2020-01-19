<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import=" java.util.* " %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<main role="main" class="container">
    <div class="my-3 p-3 bg-white rounded box-shadow">
        <h4 class="text-center mb-4 mt-1">Log in</h4>
        <hr>
        <form action="login" method="POST">
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="login" class="form-control" placeholder="Login" type="text" required>
                </div>
            </div>

            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <input name="password" class="form-control" placeholder="Password" type="password" aria-required>
                </div>
            </div>

            <div class="form-group"></div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block blue">Log in</button>
                <p class="text-center"><a href="login" class="btn">Back to main page</a></p>
            </div>
        </form>
    </div>

    <c:if test="${error.message != null}">
        <div class="alert alert-warning">
            <strong>${error.message}</strong>
        </div>
    </c:if>
</main>
</body>
</html>
