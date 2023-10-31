<%--
  Created by IntelliJ IDEA.
  User: Retr0
  Date: 30/10/2023
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" href="/public/assets/css/auth.css">

</head>
<body>

<form method="post" action="login">
    <div class="segment">
        <h1>Sign up</h1>
    </div>

    <label>
        <input type="text" placeholder="Username" name="username"/>
    </label>
    <label>
        <input type="password" placeholder="Password" name="password"/>
    </label>

    <input type="submit" class="red submit" type="button">

    <div class="segment">
        <a href="register" class="no-account" type="button">No account ?</a>
    </div>


</form>
</body>
</html>
