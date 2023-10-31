<%--
  Created by IntelliJ IDEA.
  User: Steam
  Date: 31/10/2023
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserManager</title>
</head>
<body>
<label>
    <select>
        <jsp:useBean id="Player" scope="request" type="java.util.List"/>
        <c:forEach items="${Player}" var="item" >
                 ${item.getUsername()}<br>
        </c:forEach>
    </select>
</label>
</body>
</html>
