<%--
  Created by IntelliJ IDEA.
  User: maksym
  Date: 01.12.18
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Homepage</title>
</head>
<body>
    <form:form method="post" modelAttribute="person">
        <form:input path="firstName"/>
        <form:input path="lastName"/>
        <input type="submit" value="Save">
    </form:form>
</body>
</html>
