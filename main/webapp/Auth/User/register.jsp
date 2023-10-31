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
    <title>Register</title>

    <link rel="stylesheet" href="/public/assets/css/auth.css">

</head>
<body>

<form method="post" action="login">
    <div class="segment">
        <h1>Sign in</h1>
    </div>

    <label>
        <input type="text" placeholder="Name" name="name"/>
    </label>
    <label>
        <input type="password" placeholder="Firstname" name="firstname"/>
    </label>
    <label>
        <input type="text" placeholder="Username" name="username"/>
    </label>
    <label>
        <input type="password" placeholder="Password" name="password"/>
    </label>

    <input type="submit" class="red submit" type="button">

    <div class="segment">
        <a href="login" class="no-account" type="button">Already sign in ?</a>
    </div>


</form>
</body>
</html>
